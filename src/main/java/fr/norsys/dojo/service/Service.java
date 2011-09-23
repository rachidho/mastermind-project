package fr.norsys.dojo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.norsys.dojo.DAO.DaoResultat;
import fr.norsys.dojo.DAO.DaoUtilisateur;
import fr.norsys.dojo.DAO.interfaceDAO.IDaoResultat;
import fr.norsys.dojo.DAO.interfaceDAO.IDaoUtilisateur;
import fr.norsys.dojo.entity.ResultatEntity;
import fr.norsys.dojo.entity.Utilisateur;
import fr.norsys.dojo.util.ConnexionBDD;

public class Service extends AbstractTableModel implements IService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8003672297839912768L;

	private List<Utilisateur> users = new ArrayList<Utilisateur>();

	private final String[] entetes = { "ID", "Prénom", "Nom" };

	Connection conn = null;

	public Service() {
		super();
		try {
			users = findAllUtilisateurs();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// methode permet de faire la connexion a la base de donnee
	private void connexion() {
		try {
			conn = ConnexionBDD.getConnectionTOBACKOFFICE();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// methode permet d'ajoute un utilisateur
	public int ajoutResultat(ResultatEntity resultat) throws SQLException {
		connexion();
		IDaoResultat iDaoResultat = new DaoResultat(conn);
		int i = iDaoResultat.ajoutResultat(resultat);
		conn.close();
		return i;
	}

	// methode permet de modifier un utilisateur
	public int updateResultat(ResultatEntity resultat) throws SQLException {
		connexion();
		IDaoResultat iDaoResultat = new DaoResultat(conn);
		int i = iDaoResultat.updateResultat(resultat);
		conn.close();
		return i;
	}

	// methode permet de supprimer un utilisateur
	public int deleteResultat(Long idResultat) throws SQLException {
		connexion();
		IDaoResultat iDaoResultat = new DaoResultat(conn);
		int i = iDaoResultat.deleteResultat(idResultat);
		conn.close();
		return i;
	}

	// methode permet d'ajoute un utilisateur
		public void ajoutUtilisateur(Utilisateur utilisateur) throws SQLException {
			connexion();
			IDaoUtilisateur iDaoUtilisateur = new DaoUtilisateur(conn);
			iDaoUtilisateur.ajoutUtilisateur(utilisateur);
			users.add(utilisateur);
			fireTableRowsInserted(users.size() - 1, users.size() - 1);
			conn.close();
		}

		
	// methode permet de liste tout les utilisateur
	public List<Utilisateur> findAllUtilisateurs() throws SQLException {
		connexion();
		IDaoUtilisateur iDaoUtilisateur = new DaoUtilisateur(conn);
		List<Utilisateur> result = null;
		try {
			result = (List<Utilisateur>) iDaoUtilisateur.findAllUtilisateurs();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return result;
	}

	// methode permet de recupere un utilisateur
	public Utilisateur utilisateurById(Long idUtilisateur) throws SQLException {
		connexion();
		IDaoUtilisateur iDaoUtilisateur = new DaoUtilisateur(conn);
		Utilisateur utilisateur = iDaoUtilisateur
				.utilisateurById(idUtilisateur);
		conn.close();
		return utilisateur;
	}

	// methode permet de modifier un utilisateur
	public void updateUtilisateur(Utilisateur utilisateur) throws SQLException {
		connexion();
		IDaoUtilisateur iDaoUtilisateur = new DaoUtilisateur(conn);
		iDaoUtilisateur.updateUtilisateur(utilisateur);
		conn.close();
	}

	// methode permet de supprimer un utilisateur
	public void deleteUtilisateur(Long idUtilisateur) throws SQLException {
		connexion();
		IDaoUtilisateur iDaoUtilisateur = new DaoUtilisateur(conn);
		iDaoUtilisateur.deleteUtilisateur(idUtilisateur);
		conn.close();
	}

	// methode permet de genere l'ID suivant
	public Long iDtable(String s) throws SQLException {
		connexion();
		Long il = (long) 0;
		if (s.equals("Adresse")) {
			IDaoResultat iDaoAdresse = new DaoResultat(conn);
			il = iDaoAdresse.iDtable();
		} else if (s.equals("Utilisateur")) {
			IDaoUtilisateur iDaoUtilisateur = new DaoUtilisateur(conn);
			il = iDaoUtilisateur.iDtable();
		}
		conn.close();
		return il;
	}

	public int getRowCount() {
		return users.size();
	}

	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return users.get(rowIndex).getInUtilisateur();
		case 1:
			return users.get(rowIndex).getNomUtilisateur();
		case 2:
			return users.get(rowIndex).getPreUtilisateur();
		default:
			return null;
		}
	}

	public void addUtilisateur(Utilisateur utilisateur) {
		users.add(utilisateur);
		fireTableRowsInserted(users.size() - 1, users.size() - 1);
	}

	public void removeUtilisateur(int rowIndex) {
		users.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

}

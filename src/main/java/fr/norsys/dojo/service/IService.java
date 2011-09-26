package fr.norsys.dojo.service;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.dojo.DAO.DaoResultat;
import fr.norsys.dojo.DAO.interfaceDAO.IDaoResultat;
import fr.norsys.dojo.entity.ResultatEntity;
import fr.norsys.dojo.entity.Utilisateur;

public interface IService {
	// methode permet d'ajoute un resultet
	public int ajoutResultat(ResultatEntity resultat) throws SQLException;
	// methode permet de modifier un resultat
	public int updateResultat(ResultatEntity resultat) throws SQLException;
	// methode permet de supprimer un resultat
	public int deleteResultat(Long idResultat) throws SQLException;
	// methode permet l'ajout d'un utilisateur
	public int ajoutUtilisateur(Utilisateur utilisateur) throws SQLException;
	// methode permet de supprimer un resultat
	public void addUtilisateur(Utilisateur utilisateur);
	// methode permet de supprimer un utilisateur
	public void removeUtilisateur(int rowIndex);
	//public int getRowCount();
	// liste de  tous les utilisateur
	public List<Utilisateur> findAllUtilisateurs() throws SQLException;
	// recuper un utilisateur par son id
	public Utilisateur utilisateurById(Long idUtilisateur) throws SQLException;
	// modification d'un utilisateur
	public int updateUtilisateur(Utilisateur utilisateur) throws SQLException;
	// suppression d'un utilisateur
	public int deleteUtilisateur(Long idUtilisateur) throws SQLException;
	public int getRowCount();
	public int getColumnCount();
	public String getColumnName(int columnIndex);
	public Object getValueAt(int i, int j);
	public Long iDtable(String s) throws SQLException;
}

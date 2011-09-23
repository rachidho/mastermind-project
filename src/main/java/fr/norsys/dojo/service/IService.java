package fr.norsys.dojo.service;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.dojo.DAO.DaoResultat;
import fr.norsys.dojo.DAO.interfaceDAO.IDaoResultat;
import fr.norsys.dojo.entity.ResultatEntity;
import fr.norsys.dojo.entity.Utilisateur;

public interface IService {

	public void ajoutResultat(ResultatEntity resultat) throws SQLException;

	// methode permet de modifier un utilisateur
	public int updateResultat(ResultatEntity resultat) throws SQLException;

	// methode permet de supprimer un utilisateur
	public int deleteResultat(Long idResultat) throws SQLException;
	//
	public void ajoutUtilisateur(Utilisateur utilisateur) throws SQLException;

	public void addUtilisateur(Utilisateur utilisateur);

	public void removeUtilisateur(int rowIndex);

	public int getRowCount();

	public List<Utilisateur> findAllUtilisateurs() throws SQLException;

	public Utilisateur utilisateurById(Long idUtilisateur) throws SQLException;

	public void updateUtilisateur(Utilisateur utilisateur) throws SQLException;

	public void deleteUtilisateur(Long idUtilisateur) throws SQLException;

	public Object getValueAt(int i, int j);

	// public Long iDtable(String s) throws SQLException;
}

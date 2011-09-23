package fr.norsys.dojo.DAO.interfaceDAO;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.dojo.entity.Utilisateur;

public interface IDaoUtilisateur {
	// ajoute des utilisateur 
	public void ajoutUtilisateur(Utilisateur utilisateur) throws SQLException;
	// liste de tous les utilisateur
	public List<Utilisateur> findAllUtilisateurs() throws SQLException;
	// recupere un utilisateur par son id
	public Utilisateur utilisateurById(Long idUtilisateur) throws SQLException;
	// modification d'un utilisateur
	public void updateUtilisateur(Utilisateur utilisateur) throws SQLException;
	// supression des utilisateur
	public void deleteUtilisateur(Long idUtilisateur) throws SQLException;
	// generation des id
	public Long iDtable() throws SQLException;
}

package fr.norsys.dojo.DAO.interfaceDAO;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.dojo.entity.Utilisateur;

public interface IDaoUtilisateur {

	public void ajoutUtilisateur(Utilisateur utilisateur) throws SQLException;
	
	public List<Utilisateur> findAllUtilisateurs() throws SQLException;
	
	public Utilisateur utilisateurById(Long idUtilisateur) throws SQLException;
	
	public void updateUtilisateur(Utilisateur utilisateur) throws SQLException;
	
	public void deleteUtilisateur(Long idUtilisateur) throws SQLException;
	
	public Long iDtable() throws SQLException;
}

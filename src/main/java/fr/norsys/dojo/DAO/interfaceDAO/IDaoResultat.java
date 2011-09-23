package fr.norsys.dojo.DAO.interfaceDAO;

import java.sql.SQLException;

import fr.norsys.dojo.entity.ResultatEntity;

public interface IDaoResultat {
	// methode permt d'ajoute un utilisateur
	public int ajoutResultat(ResultatEntity resultat) throws SQLException;
	// methode permet de modifier un utilisateur
	public int updateResultat(ResultatEntity resultat) throws SQLException;
	// methode permet de supprimer un utilisateur
	public int deleteResultat(Long idResultat) throws SQLException;

}

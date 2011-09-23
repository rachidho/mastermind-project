package fr.norsys.dojo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.norsys.dojo.DAO.interfaceDAO.IDaoResultat;
import fr.norsys.dojo.entity.ResultatEntity;

/**
 * @author technomaker01
 *
 */
public class DaoResultat implements IDaoResultat {
	
	Connection conn;
	private String createResultat = "insert into RESULTATENTITY ( IDRESULTE, IDUTILISATEUR, GAGNEES, PERDUS ) values (?, ?, ?, ?)";
	private String updateResultat = "UPDATE RESULTATENTITY SET GAGNEES = ?, PERDUS = ? where IDRESULTE = ? and IDUTILISATEUR = ?";
	private String deleteResultat = "DELETE FROM RESULTATENTITY WHERE IDRESULTE = ?";
	private String findAllResultat = "select * from RESULTATENTITY";
	
	public DaoResultat(Connection conn) {
		this.conn = conn;
	}
	// methode permt d'ajoute un utilisateur
		public int ajoutResultat(ResultatEntity resultat) throws SQLException {
			PreparedStatement pstmt = conn.prepareStatement(createResultat);
			pstmt.setLong(1, resultat.getIdResulte());
			pstmt.setLong(2, resultat.getIdUtilisateur());
			pstmt.setInt(3, resultat.getGagnees());
			pstmt.setInt(4, resultat.getPerdus());
			int i = pstmt.executeUpdate();
			pstmt.close();
			return i;
		}
		
		// methode permet de modifier un utilisateur
		public int updateResultat(ResultatEntity resultat) throws SQLException {
			PreparedStatement pstmt = conn.prepareStatement(updateResultat);
			pstmt.setInt(1, resultat.getGagnees());
			pstmt.setInt(2, resultat.getPerdus());
			pstmt.setLong(3, resultat.getIdResulte());
			pstmt.setLong(4, resultat.getIdUtilisateur());
			int i = pstmt.executeUpdate();
			pstmt.close();
			return i;
		}

		// methode permet de supprimer un utilisateur
		public int deleteResultat(Long idResultat) throws SQLException {
			PreparedStatement pstmt = conn.prepareStatement(deleteResultat);
			pstmt.setLong(1, idResultat);
			int i = pstmt.executeUpdate();
			pstmt.close();
			return i;
		}
		
		// methode permet de genere le id de la tabel resultat
		public Long iDtable() throws SQLException{
			PreparedStatement pstmt = conn.prepareStatement(findAllResultat);
			ResultSet rs = pstmt.executeQuery();
			Long il = (long) 0;
			while (rs.next()){
				il = rs.getLong(1);
			}
			return il+1;
		}

}

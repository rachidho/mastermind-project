package fr.norsys.dojo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.norsys.dojo.DAO.interfaceDAO.IDaoUtilisateur;
import fr.norsys.dojo.entity.Utilisateur;

public class DaoUtilisateur implements IDaoUtilisateur {

	Connection conn;
	private String createUtilisateur = "insert into utilisateur (inUtilisateur,nomUtilisateur,preUtilisateur) values (?, ?, ?)";
	private String findAllUtilisateurs = "select * from utilisateur";
	private String findUtilisateurById = findAllUtilisateurs
			+ " where inUtilisateur = ?";
	private String updateUtilisateur = "update utilisateur set nomUtilisateur = ?, preUtilisateur = ? where inUtilisateur = ? ";
	private String deleteUtilisateur = "delete from utilisateur where inUtilisateur = ?";

	public DaoUtilisateur(Connection conn) {
		this.conn = conn;
	}
	// methode permt d'ajoute un utilisateur
	public void ajoutUtilisateur(Utilisateur utilisateur) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(createUtilisateur);
		pstmt.setLong(1, utilisateur.getInUtilisateur());
		pstmt.setString(2, utilisateur.getNomUtilisateur());
		pstmt.setString(3, utilisateur.getPreUtilisateur());
		pstmt.executeUpdate();
		pstmt.close();
	}
	// methode permet de list tous les utilisateurs
	public List<Utilisateur> findAllUtilisateurs() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(findAllUtilisateurs);
		ResultSet rs = stmt.executeQuery();
		List<Utilisateur> utilisateurList = resultSetToUtilisateur(rs);
		stmt.close();
		return utilisateurList;
	}
	// methode permet de passe les donne de resultSet vers list<Utilisateur>
	private List<Utilisateur> resultSetToUtilisateur(ResultSet rs)
			throws SQLException {
		List<Utilisateur> utilisateurList = new ArrayList<Utilisateur>();
		while (rs.next()) {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setInUtilisateur(rs.getLong(1));
			utilisateur.setNomUtilisateur(rs.getString(2));
			utilisateur.setPreUtilisateur(rs.getString(3));
			utilisateurList.add(utilisateur);
		}
		return utilisateurList;
	}
	// methode permet chercher un utilisateur par son ID
	public Utilisateur utilisateurById(Long idUtilisateur) throws SQLException {
		Utilisateur utilisateur = null;
		PreparedStatement pstmt = conn.prepareStatement(findUtilisateurById);
		pstmt.setLong(1, idUtilisateur);
		ResultSet rs = pstmt.executeQuery();
		utilisateur = getUtilisateur(rs);
		pstmt.close();
		return utilisateur;
	}
	// methode permet de passe les donne de resultSet vers objet Utilisateur
	private Utilisateur getUtilisateur(ResultSet rs) throws SQLException {
		Utilisateur newUtilisateur = new Utilisateur();
		while (rs.next()) {
			newUtilisateur.setInUtilisateur(rs.getLong(1));
			newUtilisateur.setNomUtilisateur(rs.getString(2));
			newUtilisateur.setPreUtilisateur(rs.getString(3));
		}
		return newUtilisateur;
	}
	// methode permet de modifier un utilisateur
	public void updateUtilisateur(Utilisateur utilisateur) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(updateUtilisateur);
		pstmt.setString(1, utilisateur.getNomUtilisateur());
		pstmt.setString(2, utilisateur.getPreUtilisateur());
		pstmt.setLong(3, utilisateur.getInUtilisateur());
		pstmt.executeUpdate();
		pstmt.close();
	}
	// methode permet de supprimer un utilisateur
	public void deleteUtilisateur(Long idUtilisateur) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(deleteUtilisateur);
		pstmt.setLong(1, idUtilisateur);
		pstmt.executeUpdate();
		pstmt.close();
	}
	public Long iDtable() throws SQLException{
		PreparedStatement pstmt = conn.prepareStatement(findAllUtilisateurs);
		ResultSet rs = pstmt.executeQuery();
		Long il = (long) 0;
		while (rs.next()){
			il = rs.getLong(1);
		}
		return il+1;
	}
}

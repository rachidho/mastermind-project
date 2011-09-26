package fr.norsys.dojo.mastermind;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import fr.norsys.dojo.DAO.DaoResultat;
import fr.norsys.dojo.DAO.DaoUtilisateur;
import fr.norsys.dojo.DAO.interfaceDAO.IDaoResultat;
import fr.norsys.dojo.DAO.interfaceDAO.IDaoUtilisateur;
import fr.norsys.dojo.entity.ResultatEntity;
import fr.norsys.dojo.entity.Utilisateur;
import fr.norsys.dojo.service.IService;
import fr.norsys.dojo.service.Service;
import fr.norsys.dojo.util.ConnexionBDD;

public class MastermindTest {
	Connection conn = null;

	// methode permet de faire la connexion a la base de donnee
	private void connexion() {
		try {
			conn = ConnexionBDD.getConnectionTOBACKOFFICE();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// methode permet de faire le test sur l'insertion, modification et
	// suppresion a partir de DAO
	// test de DAO
	@Test
	public void shouldCRUDResultatDAO() throws SQLException {
		connexion();
		IDaoResultat iDaoResultat = new DaoResultat(conn);
		ResultatEntity resultatEntity = new ResultatEntity();
		resultatEntity.setIdResulte((long) 1);
		resultatEntity.setIdUtilisateur((long) 1);
		resultatEntity.setGagnees(1);
		resultatEntity.setPerdus(3);
		// ajout du resultat
		assertTrue(1 == iDaoResultat.ajoutResultat(resultatEntity));
		// modification
		resultatEntity.setGagnees(1);
		assertTrue(1 == iDaoResultat.updateResultat(resultatEntity));
		// generated ID utilisateur
		assertNotNull(iDaoResultat.iDtable());
		// supression
		assertTrue(1 == iDaoResultat.deleteResultat((long) 1));
		conn.close();
	}

	// methode permet de faire le test sur l'insertion, modification et
	// suppresion a partir de service
	// test de SERVICE
	@Test
	public void shouldCRUDResultatSERVICE() throws SQLException {
		IService iService = new Service();
		ResultatEntity resultatEntity = new ResultatEntity();
		resultatEntity.setIdResulte((long) 1);
		resultatEntity.setIdUtilisateur((long) 1);
		resultatEntity.setGagnees(1);
		resultatEntity.setPerdus(3);
		// ajout du resultat
		assertTrue(1 == iService.ajoutResultat(resultatEntity));
		// modification
		resultatEntity.setGagnees(1);
		assertTrue(1 == iService.updateResultat(resultatEntity));
		// supression
		assertTrue(1 == iService.deleteResultat((long) 1));
	}

	// methode permet de faire le test sur l'insertion, modification et
	// suppresion d'un utilisateur a partir de service
	// test de SERVICE
	@Test
	public void shouldCRUDUtilisateurSERVICE() throws SQLException {
		IService iService = new Service();
		// creation de l'objet 1
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setInUtilisateur((long) 1);
		utilisateur.setNomUtilisateur("nomUtilisateur");
		utilisateur.setPreUtilisateur("preUtilisateur");
		// creation de l'objet 2
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setInUtilisateur((long) 2);
		utilisateur1.setNomUtilisateur("nomUtilisateur");
		utilisateur1.setPreUtilisateur("preUtilisateur");
		// ajout du resultat
		assertTrue(1 == iService.ajoutUtilisateur(utilisateur));
		// modification
		utilisateur.setNomUtilisateur("test");
		assertTrue(1 == iService.updateUtilisateur(utilisateur));
		// recherche by id
		assertNotNull(iService.utilisateurById((long) 1));
		// recherche All Utilisateur
		assertNotNull(iService.findAllUtilisateurs());
		// generated ID resulta
		assertNotNull(iService.iDtable("Resultat"));
		// generated ID utilisateur
		assertNotNull(iService.iDtable("Utilisateur"));
		// le valeur de chaque chemp de jtble
		assertNotNull(iService.getValueAt(0, 0));
		assertNotNull(iService.getValueAt(0, 1));
		assertNotNull(iService.getValueAt(0, 2));
		assertNull(iService.getValueAt(0, 3));
		// nom de premier colonne
		assertNotNull(iService.getColumnName(0));
		// nombre colonne de la table
		assertEquals(3, iService.getColumnCount());
		// ajouter d'un objet a la collection
		iService.addUtilisateur(utilisateur1);
		// nembre d'objet dans la collestion 1 dans la base de donne et 2eme une
		// anstance
		assertEquals(2, iService.getRowCount());
		// suppresion de 2eme objet inser dans la collection
		iService.removeUtilisateur(1);
		assertEquals(1, iService.getRowCount());
		// supression
		assertTrue(1 == iService.deleteUtilisateur((long) 1));
	}

	// methode permet de faire le test sur l'insertion, modification et
	// suppresion d'un utilisateur a partir de DAO
	// test de DAO
	@Test
	public void shouldCRUDUtilisateurDAO() throws SQLException {
		connexion();
		IDaoUtilisateur iDaoUtilisateur = new DaoUtilisateur(conn);
		// creation de l'objet
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setInUtilisateur((long) 1);
		utilisateur.setNomUtilisateur("nomUtilisateur1");
		utilisateur.setPreUtilisateur("preUtilisateur1");
		// ajout du utilisateurs
		assertTrue(1 == iDaoUtilisateur.ajoutUtilisateur(utilisateur));
		// modification
		utilisateur.setNomUtilisateur("test");
		assertTrue(1 == iDaoUtilisateur.updateUtilisateur(utilisateur));
		// recherche by id
		assertNotNull(iDaoUtilisateur.utilisateurById((long) 1));
		// recherche All Utilisateur
		assertNotNull(iDaoUtilisateur.findAllUtilisateurs());
		// generated ID utilisateur
		assertNotNull(iDaoUtilisateur.iDtable());
		// supression
		assertTrue(1 == iDaoUtilisateur.deleteUtilisateur((long) 1));
		conn.close();
	}

	@Test
	public void shouldAvoirSolution() {
		verifySetGetCouleur(new Couleur[] { Couleur.ROUGE, Couleur.ROUGE,
				Couleur.ROUGE, Couleur.ROUGE });
	}

	@Test
	public void shouldSaveSolution() {

		verifySetGetCouleur(new Couleur[] { Couleur.ROUGE, Couleur.ROUGE,
				Couleur.ROUGE, Couleur.ROUGE });
		verifySetGetCouleur(new Couleur[] { Couleur.ROUGE, Couleur.ROUGE,
				Couleur.ROUGE, Couleur.BLEU });
	}

	@Test
	public void shouldVerifyOneGood() {
		MasterMind masterMind = verifySetGetCouleur(Couleur.ROUGE);
		// 1 de bien placé
		assertEquals(1, masterMind.setProposition(Couleur.ROUGE).getNbGood());
	}

	@Test
	public void shouldVerifyTwoGood() {
		MasterMind masterMind = verifySetGetCouleur(Couleur.ROUGE,
				Couleur.ROUGE);
		// 2 de bien placé
		assertEquals(2, masterMind.setProposition(Couleur.ROUGE, Couleur.ROUGE)
				.getNbGood());
	}

	@Test
	public void shouldVerifyOneFalsePosition() {
		MasterMind masterMind = verifySetGetCouleur(Couleur.VERT, Couleur.BLEU);
		Resultat resultat = masterMind.setProposition(Couleur.BLEU,
				Couleur.ROUGE);
		// 2 de bien placé
		assertEquals(1, resultat.getNbMalPace());
	}

	@Test
	public void shouldAcceptDifferentSize() {

		MasterMind masterMind = verifySetGetCouleur(Couleur.ROUGE);
		// 2 de bien placé
		assertEquals(1, masterMind.setProposition(Couleur.ROUGE, Couleur.ROUGE)
				.getNbGood());
	}

	@Test
	public void shouldVerifyZeroGood() {
		MasterMind masterMind = verifySetGetCouleur(Couleur.BLEU);
		// 0 de bien placé
		assertEquals(0, masterMind.setProposition(Couleur.ROUGE).getNbGood());
	}

	private MasterMind verifySetGetCouleur(Couleur... solution) {
		MasterMind mastermind = new MasterMind();
		mastermind.setSolution(solution);
		int i = 0;
		for (Couleur couleur : solution) {
			assertEquals(couleur, mastermind.getSolution()[i]);
			i++;
		}
		return mastermind;
	}
}

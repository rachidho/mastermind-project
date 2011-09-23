package fr.norsys.dojo.mastermind;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import fr.norsys.dojo.DAO.DaoResultat;
import fr.norsys.dojo.DAO.interfaceDAO.IDaoResultat;
import fr.norsys.dojo.entity.ResultatEntity;
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

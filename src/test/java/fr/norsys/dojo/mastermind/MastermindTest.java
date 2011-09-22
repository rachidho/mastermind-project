package fr.norsys.dojo.mastermind;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MastermindTest {

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
	public void shouldVerifyOneGood(){
		MasterMind masterMind = verifySetGetCouleur(Couleur.ROUGE);
		//1 de bien placé
		assertEquals(1,masterMind.setProposition(Couleur.ROUGE).getNbGood());
		
	}
	
	@Test
	public void shouldVerifyTwoGood(){
		MasterMind masterMind = verifySetGetCouleur(Couleur.ROUGE,Couleur.ROUGE);
		//2 de bien placé
		assertEquals(2,masterMind.setProposition(Couleur.ROUGE,Couleur.ROUGE).getNbGood());
		
	}
	
	@Test
	public void shouldVerifyOneFalsePosition(){
		MasterMind masterMind = verifySetGetCouleur(Couleur.VERT,Couleur.BLEU);
		Resultat resultat = masterMind.setProposition(Couleur.BLEU,Couleur.ROUGE);
		//2 de bien placé
		assertEquals(1,resultat.getNbMalPace());
		
	}
	
	@Test
	public void shouldAcceptDifferentSize(){
		
		MasterMind masterMind = verifySetGetCouleur(Couleur.ROUGE);
		//2 de bien placé
		assertEquals(1,masterMind.setProposition(Couleur.ROUGE,Couleur.ROUGE).getNbGood());
		
	}
	
	@Test
	public void shouldVerifyZeroGood(){
		MasterMind masterMind = verifySetGetCouleur(Couleur.BLEU);
		//0 de bien placé
		assertEquals(0,masterMind.setProposition(Couleur.ROUGE).getNbGood());
		
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

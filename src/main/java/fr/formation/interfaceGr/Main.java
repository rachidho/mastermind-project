package fr.formation.interfaceGr;

import fr.norsys.dojo.mastermind.Couleur;
import fr.norsys.dojo.mastermind.MasterMind;
import fr.norsys.dojo.mastermind.Resultat;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		Ihmjeux ui = new Ihmjeux();
//		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		ui.setVisible(true);
		
		// petit exemple pratique
		MasterMind masterMind = new MasterMind();
		Resultat resultat = new Resultat();
		masterMind.setSolution(Couleur.ROUGE,Couleur.VERT,Couleur.ROUGE);
		resultat = masterMind.setProposition(Couleur.VERT,Couleur.ROUGE,Couleur.ROUGE);
		System.out.println(" NbMalPace "+resultat.getNbMalPace()+"  NbGood "+ resultat.getNbGood());
		
		
		
	}

}

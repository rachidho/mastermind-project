package fr.norsys.dojo.mastermind;

public class MasterMind {
	private Couleur[] couleurs;
	// envoy des la solution a chaque debut de jeux
	public void setSolution(Couleur... solution) {
		couleurs = solution;
	}
	// recupere la solution
	public Couleur[] getSolution() {
		return couleurs;
	}
	// methode permet de comparais les choix proposer par l'utilisateur a selle
	// qui est donne comme solution et retourn le resultat
	public Resultat setProposition(Couleur... proposition) {
		Resultat resultat = new Resultat();
		int nbGood = 0;
		int nbMalPlace = 0;
		int i = 0;
		for (Couleur couleur : proposition) {
			if (i < couleurs.length && couleurs[i] == couleur) {
				nbGood++;
			} else {
				for (Couleur couleurMP : couleurs) {
					if (couleurMP == couleur) {
						nbMalPlace++;
					}
				}
			}
			i++;

		}
		resultat.setNbGood(nbGood);
		resultat.setNbMalPlace(nbMalPlace);
		return resultat;
	}

}

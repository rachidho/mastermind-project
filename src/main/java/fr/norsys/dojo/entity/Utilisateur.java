package fr.norsys.dojo.entity;

import fr.norsys.dojo.annotation.ClePrimaire;
import fr.norsys.dojo.annotation.Colonne;
import fr.norsys.dojo.annotation.NomTable;

@NomTable( name = "Utilisateur")
public class Utilisateur {

	@ClePrimaire( name ="inUtilisateur")
	private Long inUtilisateur;
	@Colonne(name = "nomUtilisateur")
	private String nomUtilisateur;
	@Colonne(name = "preUtilisateur")
	private String preUtilisateur;

	public Utilisateur() {
	}
	
	public Utilisateur(Long inUtilisateur, String nomUtilisateur,
			String preUtilisateur) {
		this.inUtilisateur = inUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.preUtilisateur = preUtilisateur;
	}

	public Long getInUtilisateur() {
		return inUtilisateur;
	}

	public void setInUtilisateur(Long inUtilisateur) {
		this.inUtilisateur = inUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPreUtilisateur() {
		return preUtilisateur;
	}

	public void setPreUtilisateur(String preUtilisateur) {
		this.preUtilisateur = preUtilisateur;
	}

	@Override
	public String toString() {
		return "Utilisateur [inUtilisateur=" + inUtilisateur
				+ ", nomUtilisateur=" + nomUtilisateur + ", preUtilisateur="
				+ preUtilisateur + "]";
	}

}

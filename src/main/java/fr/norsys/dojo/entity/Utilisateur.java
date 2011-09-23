package fr.norsys.dojo.entity;

import fr.norsys.dojo.annotation.ClePrimaire;
import fr.norsys.dojo.annotation.Colonne;
import fr.norsys.dojo.annotation.NomTable;
/**
 * @author technomaker01
 *
 *				netity utilisé pour stocke les utilisateur qui peuve jouer a ce jeux
 */
@NomTable( name = "Utilisateur")
public class Utilisateur {
	@ClePrimaire( name ="inUtilisateur")
	private Long inUtilisateur;
	@Colonne(name = "nomUtilisateur")
	private String nomUtilisateur;
	@Colonne(name = "preUtilisateur")
	private String preUtilisateur;
	// constructeur vide
	public Utilisateur() {
	}
	// constructeur initialisé
	public Utilisateur(Long inUtilisateur, String nomUtilisateur,
			String preUtilisateur) {
		this.inUtilisateur = inUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.preUtilisateur = preUtilisateur;
	}
	// les getters et les setters
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

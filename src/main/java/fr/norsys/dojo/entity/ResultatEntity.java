package fr.norsys.dojo.entity;

import fr.norsys.dojo.annotation.ClePrimaire;
import fr.norsys.dojo.annotation.NomTable;

/**
 * @author technomaker01
 *	
 *			entity utilisé pour stocké les resulta d'un utilisateur identifier
 */
@NomTable( name = "ResultatEntity")
public class ResultatEntity {
	
	@ClePrimaire( name ="idResulte")
	private Long idResulte;
	@ClePrimaire( name ="idUtilisateur")
	private Long idUtilisateur;
	@ClePrimaire( name ="gagnees")
	private int gagnees;
	@ClePrimaire( name ="perdus")
	private int perdus;
	
	// constructeur initialisé
	public ResultatEntity(Long i, Long j, int gagnees, int perdus) {
		super();
		this.idResulte = i;
		this.idUtilisateur = j;
		this.gagnees = gagnees;
		this.perdus = perdus;
	}
	
	// constructeur vide
	public ResultatEntity() {
		// TODO Auto-generated constructor stub
	}
	
	// les getter et les setters
	public Long getIdResulte() {
		return idResulte;
	}
	public void setIdResulte(Long idResulte) {
		this.idResulte = idResulte;
	}
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public int getGagnees() {
		return gagnees;
	}
	public void setGagnees(int gagnees) {
		this.gagnees = gagnees;
	}
	public int getPerdus() {
		return perdus;
	}
	public void setPerdus(int perdus) {
		this.perdus = perdus;
	}

}

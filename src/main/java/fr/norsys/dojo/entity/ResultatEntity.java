package fr.norsys.dojo.entity;

/**
 * @author technomaker01
 *
 */
public class ResultatEntity {
	
	private Long idResulte;
	private Long idUtilisateur;
	private int gagnees;
	private int perdus;
	
	
	public ResultatEntity(Long i, Long j, int gagnees, int perdus) {
		super();
		this.idResulte = i;
		this.idUtilisateur = j;
		this.gagnees = gagnees;
		this.perdus = perdus;
	}
	public ResultatEntity() {
		// TODO Auto-generated constructor stub
	}
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

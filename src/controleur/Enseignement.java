package controleur;

public class Enseignement {
	private int idenseignement; 
	private String matiere; 
	private int nbheures, coeff, idclasse, idprofesseur;
	public Enseignement(int idenseignement, String matiere, int nbheures, int coeff, int idclasse, int idprofesseur) {
		 
		this.idenseignement = idenseignement;
		this.matiere = matiere;
		this.nbheures = nbheures;
		this.coeff = coeff;
		this.idclasse = idclasse;
		this.idprofesseur = idprofesseur;
	}
	public Enseignement(String matiere, int nbheures, int coeff, int idclasse, int idprofesseur) {
		 
		this.idenseignement = 0;
		this.matiere = matiere;
		this.nbheures = nbheures;
		this.coeff = coeff;
		this.idclasse = idclasse;
		this.idprofesseur = idprofesseur;
	}
	public int getIdenseignement() {
		return idenseignement;
	}
	public void setIdenseignement(int idenseignement) {
		this.idenseignement = idenseignement;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public int getNbheures() {
		return nbheures;
	}
	public void setNbheures(int nbheures) {
		this.nbheures = nbheures;
	}
	public int getCoeff() {
		return coeff;
	}
	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}
	public int getIdclasse() {
		return idclasse;
	}
	public void setIdclasse(int idclasse) {
		this.idclasse = idclasse;
	}
	public int getIdprofesseur() {
		return idprofesseur;
	}
	public void setIdprofesseur(int idprofesseur) {
		this.idprofesseur = idprofesseur;
	}
	
}
 
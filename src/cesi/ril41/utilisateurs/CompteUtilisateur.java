package cesi.ril41.utilisateurs;

import cesi.ril41.autentification.Identifiant;
import cesi.ril41.autentification.generateurMDP;

public class CompteUtilisateur {

	private Integer idUtilisateur;
	private String nom;
	private String prenom;
	private generateurMDP generateur;	

	public generateurMDP getGenerateur() {
		return generateur;
	}

	public void setGenerateur(generateurMDP generateur) {
		this.generateur = generateur;
	}

	private static String DROITS = "util";

	public static String getDROITS() {
		return DROITS;
	}

	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Génère un objet Identifiant (les valeurs de login et motDePasse seront
	 * définis à partir des valeurs de nom et prenom)
	 * 
	 * @param nom
	 * @param prenom
	 * @return CompteUtilisateur
	 */
	public Identifiant genererIdentifiant() {
		return new Identifiant(this.prenom.substring(0, 1) + this.nom, getGenerateur());
	}
	
	/**
	 * Constructeur de la class CompteUtilisateur
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param generateur
	 */
	public CompteUtilisateur(Integer id, String nom, String prenom, generateurMDP generateur) {
		setIdUtilisateur(id);
		setNom(prenom);
		setPrenom(nom);
		setGenerateur(generateur);
	}

}

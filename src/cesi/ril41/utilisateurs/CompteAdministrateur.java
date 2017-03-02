package cesi.ril41.utilisateurs;

import cesi.ril41.autentification.generateurMDP;

public class CompteAdministrateur extends CompteUtilisateur {

	private static String DROITS = "admin";
	
	public static String getDROITS() {
		return DROITS;
	}
	
	/**
	 * Constructeur pour un compte administrateur
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param generateur
	 */
	public CompteAdministrateur(Integer id, String nom, String prenom, generateurMDP generateur) {
		super(id, nom, prenom, generateur);
	}

}

package cesi.ril41;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import cesi.ril41.autentification.Identifiant;
import cesi.ril41.autentification.generateurMDPComplex;
import cesi.ril41.autentification.generateurMDPSimple;
import cesi.ril41.utilisateurs.CompteAdministrateur;
import cesi.ril41.utilisateurs.CompteUtilisateur;
import cesi.ril41.exceptions.IdentifiantException;
import cesi.ril41.exceptions.PasswordException;

public class Program {

	public static void main(String[] args) {

		// Initisialisation des 5 utilisateurs
		List<CompteUtilisateur> comptesUtilisateur = new ArrayList<CompteUtilisateur>();
		comptesUtilisateur.add(new CompteUtilisateur(1, "lanrent", "remy", new generateurMDPSimple()));
		comptesUtilisateur.add(new CompteAdministrateur(2, "bob", "lenon", new generateurMDPComplex()));
		comptesUtilisateur.add(new CompteUtilisateur(3, "jean", "michel", new generateurMDPSimple()));
		comptesUtilisateur.add(new CompteAdministrateur(4, "pierre", "davant", new generateurMDPComplex()));
		comptesUtilisateur.add(new CompteAdministrateur(5, "john", "doe", new generateurMDPComplex()));

		Scanner monLecteur;
		try {
			monLecteur = new Scanner(new File("utilisateurs.txt"));
			while (monLecteur.hasNext()) {
				int id = monLecteur.nextInt();
				String nom = monLecteur.next();
				String prenom = monLecteur.next();
				System.out.println("L’élément " + nom + " a été lu.");
			}
			monLecteur.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
// input console
/*
 * System.out.println("Veuillez saisir votre identifiant"); Scanner inputUser =
 * new Scanner(System.in); String inputIdentifiant = inputUser.nextLine();
 * System.out.println("Veuillez saisir votre mot de passe"); String
 * inputPassword = inputUser.nextLine(); inputUser.close();
 * 
 * Identifiant identifiant = new Identifiant(inputIdentifiant, inputPassword);
 * boolean goodLogin = false; boolean goodPassword = false; // Caclule le poids
 * de chaque utilisateur for (int i = 0; i < comptesUtilisateur.size(); i++) {
 * Identifiant user = comptesUtilisateur.get(i).genererIdentifiant();
 * //System.out.println("Mot de passe généré : " + user.getMotDePasse());
 * //System.out.println("Somme de controle trouvé : " +
 * user.getSommeDeControle());
 * 
 * if (identifiant.testSommeControle(user.getSommeDeControle())) {
 * System.out.println("Bienvenue !"); goodLogin = true; goodPassword = true;
 * break; }
 * 
 * if (identifiant.getLogin().equals(user.getLogin())) { goodLogin = true;
 * break; }
 * 
 * } try { if (!goodLogin) { throw new
 * IdentifiantException("Identifiant inconnu."); }
 * 
 * if (goodLogin && !goodPassword) { throw new
 * PasswordException("Mot de passe erroné."); } } catch (Exception e) {
 * System.out.println(e.getMessage()); } }
 * 
 * }
 */

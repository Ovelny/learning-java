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

	public static List<CompteUtilisateur> comptesUtilisateur = new ArrayList<CompteUtilisateur>();
	public static Window panel;
	public static void main(String[] args) {

		// Initialisation des 5 utilisateurs
		/*
		 * comptesUtilisateur.add(new CompteUtilisateur(1, "lanrent", "remy",
		 * new generateurMDPSimple())); comptesUtilisateur.add(new
		 * CompteAdministrateur(2, "bob", "lenon", new generateurMDPComplex()));
		 * comptesUtilisateur.add(new CompteUtilisateur(3, "jean", "michel", new
		 * generateurMDPSimple())); comptesUtilisateur.add(new
		 * CompteAdministrateur(4, "pierre", "davant", new
		 * generateurMDPComplex())); comptesUtilisateur.add(new
		 * CompteAdministrateur(5, "john", "doe", new generateurMDPComplex()));
		 */

		panel = new Window();
		panel.setVisible(true);

		// input console

		// System.out.println("Veuillez saisir votre identifiant");
		//
		// Scanner inputUser = new Scanner(System.in);
		// String inputIdentifiant = inputUser.nextLine();
		// System.out.println("Veuillez saisir votre mot de passe");
		// String inputPassword = inputUser.nextLine();
		// inputUser.close();
	}

	public static void loadUsers() {
		Scanner monLecteur;
		try {
			monLecteur = new Scanner(new File("utilisateurs.txt"));
			while (monLecteur.hasNext()) {
				int id = monLecteur.nextInt();
				String nom = monLecteur.next();
				String prenom = monLecteur.next();
				comptesUtilisateur.add(new CompteUtilisateur(id, nom, prenom, new generateurMDPSimple()));

			}
			monLecteur.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void checkLogin(Identifiant identifiant) {
		boolean goodLogin = false;
		boolean goodPassword = false;

		// Caclule le poids de chaque utilisateur
		for (int i = 0; i < comptesUtilisateur.size(); i++) {
			Identifiant user = comptesUtilisateur.get(i).genererIdentifiant();
			// System.out.println("Mot de passe g�n�r� : " +
			// user.getMotDePasse());
			// System.out.println("Somme de controle trouv� : " +
			// user.getSommeDeControle());

			if (identifiant.testSommeControle(user.getSommeDeControle())) {
				panel.setMessage("Bienvenue!");
				goodLogin = true;
				goodPassword = true;
				break;
			}

			if (identifiant.getLogin().equals(user.getLogin())) {
				goodLogin = true;
				break;
			}

		}

		try {

			if (!goodLogin) {
				throw new IdentifiantException(" Identifiant inconnu.");
			}

			if (goodLogin && !goodPassword) {
				throw new PasswordException(" Mot de passe erron�.");
			}
		} catch (Exception e) {
			panel.setMessage(e.getMessage());
		}
	}
}

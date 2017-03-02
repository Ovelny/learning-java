package cesi.ril41.autentification;

import cesi.ril41.exceptions.IdentifiantException;
import cesi.ril41.exceptions.PasswordException;

public class Identifiant {

	private String login;
	private String motDePasse;
	private long sommeDeControle;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public long getSommeDeControle() {
		return sommeDeControle;
	}

	public void setSommeDeControle(long sommeDeControle) {
		this.sommeDeControle = sommeDeControle;
	}

	/**
	 * Initialise la valeur de sommeDeControle en utilisant le calcul défini
	 * précédemment
	 */
	public void calculeSommeControle() {

		String[][] alphaPoids = { { "a", "1" }, { "b", "2" }, { "c", "3" }, { "d", "4" }, { "e", "5" }, { "f", "6" },
				{ "g", "7" }, { "h", "8" }, { "i", "9" }, { "j", "10" }, { "k", "11" }, { "l", "12" }, { "m", "13" },
				{ "n", "14" }, { "o", "15" }, { "p", "16" }, { "q", "17" }, { "r", "18" }, { "s", "19" }, { "t", "20" },
				{ "u", "21" }, { "v", "22" }, { "w", "23" }, { "x", "24" }, { "y", "25" }, { "z", "26" }, { "0", "0" },
				{ "1", "1" }, { "2", "2" }, { "3", "3" }, { "4", "4" }, { "5", "5" }, { "6", "6" }, { "7", "7" },
				{ "8", "8" }, { "9", "9" } };

		// 1. Additionner le poids* de chaque lettre du login
		Integer sommePoidsLogin = 0;
		// Récupère le login courant et le transforme en tableau de char
		char[] tabLogin = this.getLogin().toLowerCase().toCharArray();
		try {
			for (int i = 0; i < tabLogin.length; i++) {
	
				Integer poidsLogin = 0;
				// Recherche de la valeur du poids dans la liste d'alphabet
				for (int k = 0; k < alphaPoids.length; k++) {
					if (alphaPoids[k][0].equals(Character.toString(tabLogin[i]))) {
						poidsLogin = Integer.parseInt(alphaPoids[k][1]);
						break; // On sort de la boucle dès qu'on a trouvé
					}
				}
				// On fait la somme des poids trouvés
				sommePoidsLogin += poidsLogin;
			}
			
			if (sommePoidsLogin == 0) {
				throw new IdentifiantException("Le poids du login est vide (égal à 0)");
			}
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String SommePoidsLogin = sommePoidsLogin.toString();

		// 2. Concaténer le reste de la division par 3 du poids* de chaque

		// Récupère le mots de passe courant et le transforme en tableau de
		// char
		char[] tbMdp = this.getMotDePasse().toLowerCase().toCharArray();
		StringBuilder resultatEntier = new StringBuilder();
		for (int i = 0; i < tbMdp.length; i++) {
			Integer poidsMdp = 0;
			// Recherche de la valeur du poids dans la liste d'alphabet
			for (int k = 0; k < alphaPoids.length; k++) {
				if (alphaPoids[k][0].equals(Character.toString(tbMdp[i]))) {
					poidsMdp = Integer.parseInt(alphaPoids[k][1]);
					break; // On sort de la boucle dès qu'on a trouvé
				}
			}
			// Récupère le reste de la division du poids trouvé par 3
			Integer val = poidsMdp % 3;
			// On concatène tous les poids trouvés
			resultatEntier.append(val.toString());
		}
		// 3. Concaténer le résultat entier et le reste de la division de
		// l'étape 2 par l'étape 1
		Integer poidsLogin = Integer.parseInt(SommePoidsLogin);
		Integer poidsMdp = Integer.parseInt(resultatEntier.toString());
		Integer sommeControleEntier = poidsMdp / poidsLogin;
		Integer sommeControleReste = poidsMdp % poidsLogin;
		// Set la somme de controle
		this.setSommeDeControle(Long.parseLong(sommeControleEntier + "" + sommeControleReste));
	}

	/**
	 * Renvoie vrai si la valeur de sommeControle est identique à la valeur de
	 * sommeDeControle
	 * 
	 * @param sommeControle
	 * @return boolean
	 */
	public boolean testSommeControle(long sommeControle) {
		return (this.sommeDeControle == sommeControle);
	}

	public void genererMotDePasse(generateurMDP generateur)
	{
		setMotDePasse(generateur.genererMotDePasse());
	}
	
	public Identifiant(String login, generateurMDP generateur) {
		try {
			
			if (login.isEmpty()) {
				throw new IdentifiantException("Le login n'existe pas");
			}
			
			if (login.equals("")) {
				throw new IdentifiantException("Le login est vide");
			}
			
			if (generateur.genererMotDePasse().isEmpty()) {
				throw new PasswordException("le mot de passe n'existe pas");
			}
			
			if (generateur.equals("")) {
				throw new PasswordException("le mot de passe est vide");
			}
			
			setLogin(login);
			genererMotDePasse(generateur);
			this.calculeSommeControle();
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public Identifiant(String login, String MDP) {
		try {
			
			if (login.isEmpty()) {
				throw new IdentifiantException("Le login n'existe pas");
			}
			
			if (login.equals("")) {
				throw new IdentifiantException("Le login est vide");
			}
			
			if (MDP.isEmpty()) {
				throw new PasswordException("le mot de passe n'existe pas");
			}
			
			if (MDP.equals("")) {
				throw new PasswordException("le mot de passe est vide");
			}
			
			setLogin(login);
			this.motDePasse = MDP;
			this.calculeSommeControle();
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}

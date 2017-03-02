package cesi.ril41.exceptions;

public class PasswordException extends Exception {
	public PasswordException(String msg) {
		super("Erreur avec votre mot de passe :" + msg);
	}
}

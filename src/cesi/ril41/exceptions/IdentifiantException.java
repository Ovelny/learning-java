package cesi.ril41.exceptions;

public class IdentifiantException extends Exception {
	public IdentifiantException(String msg) {
		super("Erreur avec votre identifiant :" + msg); 
	}
}

package org.serratec.backend.exerciciobiblioteca.exception;

public class BibliotecaException extends Exception {

	private static final long serialVersionUID = 1L;

	// Constructor
	public BibliotecaException() {
		super();
	}

	public BibliotecaException(String message) {
		super(message);
	}

	public BibliotecaException(String message, Exception cause) {
		super(message, cause);
	}

	public BibliotecaException(Exception e) {
		super(e);
	}
}

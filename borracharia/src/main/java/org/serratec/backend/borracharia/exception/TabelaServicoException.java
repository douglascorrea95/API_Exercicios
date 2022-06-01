package org.serratec.backend.borracharia.exception;

public class TabelaServicoException extends Exception{
	
	private static final long serialVersionUID = 1L;

	// Constructor
	public TabelaServicoException() {
		super();
	}

	public TabelaServicoException(String message) {
		super(message);
	}

	public TabelaServicoException(String message, Exception cause) {
		super(message, cause);
	}

	public TabelaServicoException(Exception e) {
		super(e);
	}

}

package br.com.drogaria.exception;

public class DaoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2430749028420008755L;

	public DaoException(String mensagem) {
		super(mensagem);
	}
}
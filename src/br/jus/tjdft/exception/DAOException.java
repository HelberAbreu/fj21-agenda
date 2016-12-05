package br.jus.tjdft.exception;

public class DAOException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5946323536786968821L;


	public DAOException(Exception e) {
		super(e);
	}

}

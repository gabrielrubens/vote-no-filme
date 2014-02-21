package br.com.gabrielrubens.filme.exception;

public class SemFilmesException extends Exception {
	private static final long serialVersionUID = 1L;
	public SemFilmesException(String message) {
		super(message);
	}

	public SemFilmesException(String mensagem, Throwable e) {
		super(mensagem, e);
	}

}

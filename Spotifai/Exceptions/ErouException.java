package Exceptions;

import user.ClasseAbstrataUser;

public class ErouException extends Exception {
	private ClasseAbstrataUser conta;

	public ErouException() {
		super("A conta  nao foi encontrada nos registros.");
	}
}

package Exceptions;

public class RadioNaoEncontradaException extends Exception {
	public RadioNaoEncontradaException() {
		super("Radio não encontrada");
	}
}
package Exceptions;
public class NaoHaGeneroException extends Exception {
	public NaoHaGeneroException() {
		super("Não há músicas do gênero");
	}
}

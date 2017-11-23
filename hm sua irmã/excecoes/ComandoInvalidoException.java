package excecoes;

public class ComandoInvalidoException extends Exception {
	public ComandoInvalidoException() {
		super("Comando inválido");
	}
}

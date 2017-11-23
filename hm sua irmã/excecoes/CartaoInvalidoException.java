package excecoes;

public class CartaoInvalidoException extends Exception{
	public CartaoInvalidoException() {
		super("O numero de cartao inserido e invalido.");
	}
}

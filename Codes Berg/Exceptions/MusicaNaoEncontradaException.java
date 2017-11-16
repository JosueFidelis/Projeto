
public class MusicaNaoEncontradaException extends Exception {
	public  MusicaNaoEncontradaException (String musica) {
		super("Musica "+musica+" não encontrada");
	}
}

package Exceptions;
public class PlaylistNaoEncontradaException extends Exception {
	public  PlaylistNaoEncontradaException (String musica) {
		super("Playlist "+musica+" n�o encontrada");
	}
}

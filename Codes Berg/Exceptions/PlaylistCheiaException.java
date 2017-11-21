package Exceptions;
public class PlaylistCheiaException extends Exception{
	public PlaylistCheiaException() {
		super("Playlist já se encontra cheia");
	}
}

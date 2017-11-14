package nope;

public class Playlist {
	private Musica musica;
	private Playlist proximo;

	public Playlist() {
		this.musica = null;
		this.proximo = null;
	}

	public Musica getMusica() {
		return this.musica;
	}

	public Playlist getProximo() {
		return this.proximo;
	}
}
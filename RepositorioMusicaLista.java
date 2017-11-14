package nope;

public class RepositorioMusicaLista implements RepositorioMusicas {
	private Musica musica;
	private RepositorioMusicaLista proximo;

	public Musica getMusica() {
		return musica;
	}

	public RepositorioMusicaLista getProximo() {
		return proximo;
	}

}

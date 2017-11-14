package nope;

public class RepositorioPlaylistLista implements RepositorioPlaylists {
	private Playlist playlist;
	private RepositorioPlaylistLista proximo;

	public Playlist getPlaylist() {
		return playlist;
	}

	public RepositorioPlaylistLista getProximo() {
		return proximo;
	}

}

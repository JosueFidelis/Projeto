package repositorio;

import Exceptions.PlaylistNaoEncontradaException;
import Playlists.Playlist;

public interface RepositorioPlaylists {
	public void inserir(String playlist,boolean ispremium);
	public void remover(String playlist)throws PlaylistNaoEncontradaException;
	public Playlist buscar(String playlist)throws PlaylistNaoEncontradaException;
	public String listar();
}

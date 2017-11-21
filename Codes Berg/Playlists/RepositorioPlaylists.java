package Playlists;

import Exceptions.PlaylistNaoEncontradaException;

public interface RepositorioPlaylists {
	public void inserir(Playlist playlist);
	public void remover(String playlist)throws PlaylistNaoEncontradaException;
	public String buscar(String playlist)throws PlaylistNaoEncontradaException;
}

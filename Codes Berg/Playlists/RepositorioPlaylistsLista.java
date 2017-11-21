package Playlists;

import Exceptions.PlaylistNaoEncontradaException;

public class RepositorioPlaylistsLista implements RepositorioPlaylists {
	private Playlist playlist;
	private RepositorioPlaylistsLista proximo;

	@Override
	public void inserir(Playlist playlist) {
		if(this.playlist == null) {
			this.playlist = playlist;
			proximo = new RepositorioPlaylistsLista();
		}else {
			proximo.inserir(playlist);
		}

	}

	@Override
	public void remover(String playlist)throws PlaylistNaoEncontradaException {
		if(this.playlist != null) {
			if(this.playlist.getNome().equals(playlist)) {
				this.playlist = proximo.playlist;
				this.proximo = proximo.proximo;
			}else {
				proximo.remover(playlist);
			}
		}else {
			PlaylistNaoEncontradaException e;
			e = new  PlaylistNaoEncontradaException(playlist);
			throw e;
		}

	}

	@Override
	public String buscar(String playlist) throws PlaylistNaoEncontradaException{
		// TODO Auto-generated method stub
		if(this.playlist != null) {
			if(this.playlist.getNome().equals(playlist)) {
				return "Playlist" + playlist +"/n"+this.playlist.listar();
			}else {
				return proximo.buscar(playlist);
			}
		}else {
			PlaylistNaoEncontradaException e;
			e = new  PlaylistNaoEncontradaException(playlist);
			return e.getMessage();
		}
	}

}

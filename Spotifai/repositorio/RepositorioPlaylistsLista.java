package repositorio;

import Exceptions.PlaylistNaoEncontradaException;
import Playlists.Playlist;
import Playlists.PlaylistFree;
import Playlists.PlaylistPremium;

public class RepositorioPlaylistsLista implements RepositorioPlaylists {
	private Playlist playlist;
	private RepositorioPlaylistsLista proximo;

	@Override
	public void inserir(String playlist,boolean ispremium) {
		Playlist pf;
		if(ispremium)
			pf = new PlaylistPremium(playlist);
		else {
			pf = new PlaylistFree(playlist);
		}
		if(this.playlist == null) {
			this.playlist = pf;
			proximo = new RepositorioPlaylistsLista();
		}else {
			proximo.inserir(playlist,ispremium);
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
	public Playlist buscar(String playlist) throws PlaylistNaoEncontradaException{
		// TODO Auto-generated method stub
		if(this.playlist != null) {
			if(this.playlist.getNome().equals(playlist)) {
				return this.playlist;
			}else {
				return proximo.buscar(playlist);
			}
		}else {
			PlaylistNaoEncontradaException e;
			e = new  PlaylistNaoEncontradaException(playlist);
			throw e;
		}
	}
	@Override
	public String listar()
	{
		if(this.playlist == null)
		{
			return "";
		}else {
			return this.playlist.getNome() +"/n"+proximo.listar();
		}
	}

}

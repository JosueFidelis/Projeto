package Playlists;

import Exceptions.PlaylistNaoEncontradaException;

public class RepositorioPlaylistsArray implements RepositorioPlaylists {
	int index = 0;
	Playlist[] playlist = new Playlist[20];
	@Override
	public void inserir(Playlist playlist) {
		if(this.index == this.playlist.length)
		{
		this.playlist[index] = playlist;
		index++;
		}else {
			Playlist[] playlistr = new Playlist[index*2];
			for(int i = 0;i<index;i++) {
				playlistr[i] = this.playlist[i];
			}
			index++;
			this.playlist = playlistr;
			this.playlist[index] = playlist;
		}
	
	}

	@Override
	public void remover(String playlist) throws PlaylistNaoEncontradaException {
		boolean achou = false;
		for(int i = 0;i<index;i++) {
			if(this.playlist[i].getNome().equals(playlist)) {
				achou = true;
				this.playlist[i] = this.playlist[index-1];
				this.playlist[index-1] = null;
				index--;
			}
		}
		if(!achou) {
			PlaylistNaoEncontradaException e;
			e = new PlaylistNaoEncontradaException(playlist);
			throw e;
			
 		}

	}

	@Override
	public String buscar(String playlist) throws PlaylistNaoEncontradaException {
		boolean achou = false;
		for(int i = 0;i<index;i++) {
			if(this.playlist[i].getNome().equals(playlist)) {
				achou = true;
				return "Playlist Encontrada";
			}
		}
		if(!achou) {
			PlaylistNaoEncontradaException e;
			e = new PlaylistNaoEncontradaException(playlist);
			return e.getMessage();
			
 		}
		return "";
	}

}

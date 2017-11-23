package repositorio;

import Exceptions.PlaylistNaoEncontradaException;
import Playlists.Playlist;
import Playlists.PlaylistFree;
import Playlists.PlaylistPremium;


public class RepositorioPlaylistsArray implements RepositorioPlaylists {
	int index = 0;
	Playlist[] playlist = new Playlist[20];
	@Override
	public void inserir(String playlist,boolean ispremium) {
		Playlist pf;
		if(!ispremium)
			 pf = new PlaylistFree(playlist);
		else
			pf = new PlaylistPremium(playlist);
		if(this.index == this.playlist.length)
		{
		this.playlist[index] = pf;
		index++;
		}else {
			Playlist[] playlistr = new Playlist[index*2];
			for(int i = 0;i<index;i++) {
				playlistr[i] = this.playlist[i];
			}
			index++;
			this.playlist = playlistr;
			this.playlist[index] = pf;
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
	public Playlist buscar(String playlist) throws PlaylistNaoEncontradaException {

		boolean achou = false;
		int index = 0;
		for(int i = 0;i<index;i++) {
			if(this.playlist[i].getNome().equals(playlist)) {
				achou = true;
				index = i;
			}
		}
		if(!achou) {
			PlaylistNaoEncontradaException e;
			e = new PlaylistNaoEncontradaException(playlist);
			throw e;
			
 		}else {
 			return this.playlist[index];
 		}
		
	}
	@Override
	public String listar() {
		String a = "Playlist existentes: ";
		for(int i = 0; i<index;i++)
		{
			a += playlist[i].getNome() +"\n";
		}
		return a;
	}

}

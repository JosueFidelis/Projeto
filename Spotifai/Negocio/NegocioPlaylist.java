package Negocio;
import Exceptions.PlaylistNaoEncontradaException;
import Playlists.Playlist;
import repositorio.RepositorioPlaylists;
import repositorio.RepositorioPlaylistsArray;
import repositorio.RepositorioPlaylistsLista;
public class NegocioPlaylist {
	private RepositorioPlaylists list;
	
	public NegocioPlaylist(boolean islist)
	{
		if(islist = true)
			list = new RepositorioPlaylistsLista();
		else
			list =new RepositorioPlaylistsArray();
	}
	
	public Playlist buscarPlaylist(String nome) throws PlaylistNaoEncontradaException{
		return list.buscar(nome);
	}
	public void inserirPlaylist(String nome,boolean ispremium)
	{
		list.inserir(nome, ispremium);
	}
	public void removerPlaylist(String nome) throws PlaylistNaoEncontradaException{
		list.remover(nome);
	}
	public String listarPlaylists() {
		return list.listar();
	}
	
}

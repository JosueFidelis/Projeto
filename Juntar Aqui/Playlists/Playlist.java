package Playlists;
import Exceptions.PlaylistNaoEncontradaException;

public abstract class Playlist {
	private String nome;
	public Playlist(String nome)
	{
		this.nome = nome;
	}
	public abstract String adicionar(String musica);
	public abstract String remover(String musica) throws PlaylistNaoEncontradaException;
	public abstract String listar();
	public String getNome()
	{
		return this.nome;
	}
	
	
}

package ISpotifai;

import Exceptions.PlaylistNaoEncontradaException;
import Negocio.NegocioPlaylist;
import Negocio.NegocioUser;
import Negocio.NegocioArtista;
import Artista.Artista;
import Playlists.Playlist;
import user.ClasseAbstrataUser;
import Exceptions.ErouException;
import Exceptions.ComandoInvalidoException;
import Exceptions.AJCException;
import Exceptions.ANEException;
public class Spotify {
	private NegocioPlaylist playlist;
	private NegocioUser user;
	private NegocioArtista artista;
	public Spotify(boolean islist) {
		playlist =new NegocioPlaylist(islist);
		user = new NegocioUser(islist);
	}
	public void criarPlaylist(String nome,boolean ispremium)
	{
		playlist.inserirPlaylist(nome,ispremium);
	}
	public void removerPlaylist(String nome) throws PlaylistNaoEncontradaException
	{
		playlist.removerPlaylist(nome);
	}
	public Playlist buscarPlaylist(String nome)throws PlaylistNaoEncontradaException
	{
		return playlist.buscarPlaylist(nome);
	}
	public String listar()

	{
		return playlist.listarPlaylists();
	}
	public String inserir(ClasseAbstrataUser user, int i) {
		return this.user.inserirConta(user);
	}
	public String removerConta(String x) throws ErouException{
		return this.user.removerConta(x);
	}
	
	public ClasseAbstrataUser procurarConta(String x) throws ErouException{
		return this.user.procurarConta(x);
	}
	
	public String conectarMetodos(String x, String y) throws ErouException, ComandoInvalidoException{
		return this.user.conectarMetodos(x, y, 0);
	}
	public void criarArtista(String nome,String b, String c)throws AJCException{
		artista.inserirArtista(nome,b,c);
	}
	public void removerArtista(String nome)throws ANEException{
		artista.removerArtista(nome);
	}
	public String buscarArtista(String nome)throws ANEException{
		artista.buscarArtista(nome);
	}
	public void atualizarArtista(String nome, String b, String c)throws ANEException{
		artista.atualizarArtista(nome,b,c);
	}
}

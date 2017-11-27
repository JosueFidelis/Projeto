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
import user.ContaFree;
public class Spotify {
	private NegocioPlaylist playlist;
	private NegocioUser user;
	private NegocioArtista artista;
	public Spotify(boolean islist) {
		playlist =new NegocioPlaylist(islist);
		user = new NegocioUser(islist);
	}
	//Playlists
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
	//fim playlist
	
	//Contas
	
	
	
	public String inserirConta(String login, String numeroCartao) {
		
		return this.user.inserirConta(new ContaFree(login, numeroCartao));
	}
	public String removerConta(String x) throws ErouException{
		return this.user.removerConta(x);
	}
	
	public ClasseAbstrataUser procurarConta(String x) throws ErouException{
		return this.user.procurarConta(x);
	}
	
	public String seguir(String x, String y) throws ErouException, ComandoInvalidoException{
		ClasseAbstrataUser c = this.user.procurarConta(x);
		return c.seguir(y) + ". " + this.user.conectarMetodos(y, "ser seguido");
	}
	
	public String deixarDeSeguir(String x, String y)throws ErouException, ComandoInvalidoException{
		ClasseAbstrataUser c = this.user.procurarConta(x);
		return c.deixarDeSeguir(y) + this.conectarMetodos(y, "deixar de ser seguido");
	}
	
	public String trocarPlano(String x) throws ErouException {
		ClasseAbstrataUser c = this.procurarConta(x);
		return c.trocarPlano();
	}
	
	
	public String cheatDePlano1(String x, String y) throws ErouException, ComandoInvalidoException{
		ClasseAbstrataUser c = this.procurarConta(x);
		if (c instanceof ContaFree) {
			return ((ContaFree) c).comandoSecreto1(y);
		}else {
			throw new ComandoInvalidoException();
		}
	}
	
	public String cheatDePlano2(String x, String y) throws ErouException, ComandoInvalidoException{
		ClasseAbstrataUser c = this.procurarConta(x);
		if (c instanceof ContaFree) {
			return ((ContaFree) c).comandoSecreto2(y);
		}else {
			throw new ComandoInvalidoException();
		}
	}
	
	public String cheatDePlano3(String x, String y) throws ErouException, ComandoInvalidoException{
		ClasseAbstrataUser c = this.procurarConta(x);
		if (c instanceof ContaFree) {
			return ((ContaFree) c).comandoSecreto3(y);
		}else {
			throw new ComandoInvalidoException();
		}
	}
	
	public String cheatDePlano4(String x, String y) throws ErouException, ComandoInvalidoException{
		ClasseAbstrataUser c = this.procurarConta(x);
		if (c instanceof ContaFree) {
			return ((ContaFree) c).comandoSecreto4(y);
		}else {
			throw new ComandoInvalidoException();
		}
	}
	
	public String cheatDePlano5(String x, String y) throws ErouException, ComandoInvalidoException{
		ClasseAbstrataUser c = this.procurarConta(x);
		if (c instanceof ContaFree) {
			return ((ContaFree) c).comandoSecreto5(y);
		}else {
			throw new ComandoInvalidoException();
		}
	}
	
	public String promover(String x, String y) throws ErouException, ComandoInvalidoException{
		ClasseAbstrataUser c = this.procurarConta(x);
		if (c instanceof ContaFree) {
			return ((ContaFree) c).promocao(y);
		}else {
			throw new ComandoInvalidoException();
		}
	}
	public String alterarNumeroCartao(String x, String y) throws ErouException{
		ClasseAbstrataUser c = this.procurarConta(x);
		return c.alterarNumeroCartao(y);
	}
	public String conectarMetodos(String x, String y) throws ErouException, ComandoInvalidoException{
		return this.user.conectarMetodos(x, y);
	}
	
	
	//fim Contas
	
	//Inicia Artista
	public void criarArtista(String nome,String b, String c)throws AJCException{
		artista.inserirArtista(nome,b,c);
	}
	public void removerArtista(String nome)throws ANEException{
		artista.removerArtista(nome);
	}
	public String buscarArtista(String nome)throws ANEException{
		return artista.buscarArtista(nome);
	}
	public void atualizarArtista(String nome, String b, String c)throws ANEException{
		artista.atualizarArtista(nome,b,c);
	}
	//fim Artistas
}

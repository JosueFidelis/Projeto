package user;

import Exceptions.ComandoInvalidoException;
import Playlists.Playlist;
import Playlists.PlaylistFree;
import repositorio.RepositorioPlaylistsArray;

public class ContaFree extends ClasseAbstrataUser {
	private PlaylistFree playlists[];
	private int nplays;

	public ContaFree(String login, String numeroCartao) {
		super(login, numeroCartao);
		this.setPlano("Free");
		playlists = new PlaylistFree[5];
		nplays = 0;
	}

	public String trocarPlano() {
		new ContaPremium(this.getLogin(), this.getNumeroCartao());
		return "Sua conta Free agora e Premium!";
	}
	
	public String comandoSecreto1(String x) throws ComandoInvalidoException {
		if(x.equals("trivial")) {
			return "1 estrela";
		}else {
			throw new ComandoInvalidoException();
		}
	}
	
	public String comandoSecreto2(String x) throws ComandoInvalidoException {
		if(x.equals("robo fumante")) {
			return "2 estrelas";
		}else {
			throw new ComandoInvalidoException();
		}
	}
	
	public String comandoSecreto3(String x) throws ComandoInvalidoException {
		if(x.equals("eu nao resisto")) {
			return "3 estrela";
		}else {
			throw new ComandoInvalidoException();
		}
	}
	
	public String comandoSecreto4(String x) throws ComandoInvalidoException {
		if(x.equals("desliguem os monitores")) {
			return "4 estrelas";
		}else {
			throw new ComandoInvalidoException();
		}
	}
	
	public String comandoSecreto5(String x) throws ComandoInvalidoException {
		if(x.equals("rodrigo ainda nao trouxe bolo")) {
			return "5 estrelas";
		}else {
			throw new ComandoInvalidoException();
		}
	}
	
	public String promocao(String x) throws ComandoInvalidoException{
		if(x.equals("5 estrelas")) {
			return this.trocarPlano();
		}else {
			throw new ComandoInvalidoException();
		}
	}
	public void adicionarPlaylist(String x) { 
		
		this.playlists[nplays] = new PlaylistFree(x); 
		this.nplays++;
		
	}
	public void removerPLaylist(String x){ 
		for(int i = 0; i<nplays;i++)
		{
			if(this.playlists[i].getNome().equals(x)) {
				this.playlists[i] = this.playlists[nplays-1];
				this.playlists[nplays-1] = null;
				nplays--;
			}
		}
	}
	
	/*
	 * 
	 * 
	 * ; }
	 * 
	 * public void ouvirPLaylist(String x) { this.playlists.Listen(x); }
	 * 
	 * public void escutarMusica(String x) { this.playlists.procurar(x); }
	 */

}
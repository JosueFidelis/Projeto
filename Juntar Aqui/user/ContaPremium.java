package user;

import Exceptions.CartaoInvalidoException;

public class ContaPremium extends ClasseAbstrataUser {
	private int tempoAssinatura;
	// private RepositorioPlaylistsLista playlists;

	public ContaPremium(String login, String numeroCartao) {
		super(login, numeroCartao);
		this.setPlano("Premium");
		this.tempoAssinatura = 30;
	}

	public String trocarPlano() {
		new ContaFree(this.getLogin(), this.getNumeroCartao());
		return "Sua conta Premium foi rebaixada para conta free D:/nASSINE NOVAMENTE XD!";
	}

	public String reduzirAssinatura() {
		this.tempoAssinatura--;
		if (this.tempoAssinatura == 0) {
			return this.trocarPlano();
		} else {
			return "Seu tempo de assinatura foi reduzido: agora restam apenas " + this.getTempo() + ".";
		}
	}

	public int getTempo() {
		return this.tempoAssinatura;
	}
	
	public String addTempo(int i) {
		this.tempoAssinatura += i;
		return "Parabens, seu tempo de assinatura aumentou em " + "dias.";
	}
	
	public String aumentarAssinatura(int i, String numeroCartao) throws CartaoInvalidoException {
		if(this.getNumeroCartao().equals(numeroCartao)) {
			return this.addTempo(i/2);
		}else {
			return new CartaoInvalidoException().getMessage();
		}
	}

	/*
	 * public adicionarPlaylist(String x) { this.playlists.addPLaylist(x); }
	 * 
	 * public removerPLaylist(String x){ this.playlists.removePlaylist(x); }
	 * 
	 * public void ouvirPLaylist(String x) { this.playlists.Listen(x); }
	 * 
	 * public void escutarMusica(String x) { this.playlists.procurar(x); }
	 */
}

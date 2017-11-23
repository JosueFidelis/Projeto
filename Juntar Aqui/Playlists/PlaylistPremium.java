package Playlists;

import Exceptions.PlaylistNaoEncontradaException;

public class PlaylistPremium extends Playlist {
	Musica musica;
	PlaylistPremium proximo;
	
	public PlaylistPremium(String nome) {
		super(nome);
		
	}

	public String adicionar(String musica){
		if(this.musica == null) {
			Musica a= new Musica(musica);
			this.musica = a;
			this.proximo = new PlaylistPremium(this.getNome());
		}else {
			proximo.adicionar(musica);
		}
		return "Musica adicionada com sucesso";
  
	}

	
	public String remover(String musica) throws PlaylistNaoEncontradaException {
		if(this.musica != null)
		{
			if(this.musica.getNome().equals(musica)) {
				return "Musica removida com sucesso";
			}else {
				return proximo.remover(musica);
			}
		}else {
			PlaylistNaoEncontradaException e;
			e = new PlaylistNaoEncontradaException(musica);
			return e.getMessage();
		}
		
		
	}
	public String listar() {
		if(this.musica == null)
		{
			return "";
		}else {
			return this.musica.getNome() +"/n"+proximo.listar();
		}
	}
}

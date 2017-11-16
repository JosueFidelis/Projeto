
public class PlaylistPremium extends Playlist {
	Musica musica;
	PlaylistPremium proximo;
	
	public PlaylistPremium(String nome) {
		super(nome);
		
	}

	public String adicionar(Musica musica){
		if(this.musica == null) {
			this.musica = musica;
			this.proximo = new PlaylistPremium(this.getNome());
		}else {
			proximo.adicionar(musica);
		}
		return "Musica adicionada com sucesso";
  
	}

	
	public String remover(String musica) throws MusicaNaoEncontradaException {
		if(this.musica != null)
		{
			if(this.musica.getNome().equals(musica)) {
				return "Musica removida com sucesso";
			}else {
				return proximo.remover(musica);
			}
		}else {
			MusicaNaoEncontradaException e;
			e = new MusicaNaoEncontradaException(musica);
			return e.getMessage();
		}
		
		
	}

}

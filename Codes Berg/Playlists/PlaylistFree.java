
public class PlaylistFree extends Playlist{
	private Musica[] musicas ;
	private int index;
	public PlaylistFree(String nome)
	{
		super(nome);
		musicas = new Musica[10];
		index = 0;
	}
	
	public String adicionar(Musica musica){
			try {
				this.musicas[index] = musica;
				index ++;
				return "Musica "+musica.getNome()+" adicionada à playlist.";
			}catch(ArrayIndexOutOfBoundsException e) {
				return "Sua playlist já está cheia.";
			}
			
	}
	public String remover(String musica) throws MusicaNaoEncontradaException{
		boolean achou = false;
		for(int i = 0; i < 10; i++) {
			if(musicas[i].getNome().equals(musica)) {
				achou = true;
			}
		}
		if(!achou) {
			MusicaNaoEncontradaException e;
			e = new MusicaNaoEncontradaException(musica);
			return e.getMessage();
		}else {
			return "Musica removida com sucesso.";
		}
	}
						
		
	
}

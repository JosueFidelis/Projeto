package Playlists;

import Exceptions.PlaylistNaoEncontradaException;

public class PlaylistFree extends Playlist{
	private Musica[] musicas ;
	private int index;
	private int override;
	private boolean replace = false;
	public PlaylistFree(String nome)
	{
		super(nome);
		musicas = new Musica[10];
		index = 0;
	}
	
	public String adicionar(String musica){
			
			try {
				Musica a = new Musica(musica);
				this.musicas[index] = a;
				index ++;
				return "Musica "+musica+" adicionada à playlist.";
			}catch(ArrayIndexOutOfBoundsException e) {
				return "Sua playlist já está cheia.";
			}
	
			
	}
	
	public String remover(String musica) throws PlaylistNaoEncontradaException{
		boolean achou = false;
		for(int i = 0; i < 10; i++) {
			if(musicas[i].getNome().equals(musica)) {
				achou = true;
				musicas[i] = musicas[index-1];
				musicas[index-1] = null;
				index--;
			}
		}
		if(!achou) {
			PlaylistNaoEncontradaException e;
			e = new PlaylistNaoEncontradaException(musica);
			throw e;
		}else {
			return "Musica removida com sucesso.";
		}
	}
	public String listar() {
		String a = "";
		for(int i = 0;i<index;i++)
		{
			if(musicas[i] != null)
			 a += (i+1)+" "+musicas[i].getNome()+"\n";
		}
		return a;
	}
		
	
}

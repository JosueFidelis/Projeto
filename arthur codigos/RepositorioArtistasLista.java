

public class RepositorioArtistasLista implements RepositorioArtistas {
	private Artista artista;
	private RepositorioArtistasLista proximo;

	public String inserirArtista(Artista artista)throws ANEException {
		boolean j=false;
		if (this.artista!=null) {
			if (this.artista==artista) {
				j=true;
			}else {
			
			}
		}
		
		if (this.artista == null) {
			this.artista = artista;
			this.proximo = new RepositorioArtistasLista();
			return "Artista adicionado!!";
		} else {
			this.proximo.inserirArtista(artista);
		}
	}

	public String removerArtista(Artista artista) throws ANEException{
		if (this.artista != null) {
			if (this.artista.equals(artista)) {
				this.artista = this.proximo.artista;
				this.proximo = this.proximo.proximo;
				return "artista removido com sucesso";
			} else {
				return this.proximo.removerArtista(artista);
			}
		}else {
			ANEException e;
			e=new ANEException(artista.getNome());
			return e.getMessage();
		}
	}

	public String buscarArtista(Artista artista) throws ANEException{
		if (this.artista != null) {
			if(this.artista==artista) {
				
				return "Artista encontrado";
			}else {
				return this.proximo.buscarArtista(artista);
			}

		}else {
			ANEException e;
			e = new ANEException(artista.getNome());
			return e.getMessage();
		}

	}

}

// meu amor te amo
// •cj cantor☻
// System.out.print ► 0:18______________2:35

// PARA SA PORRA

// meu amor te amo
// •cj cantor☻
// System.out.print ■ 0:18______________2:35

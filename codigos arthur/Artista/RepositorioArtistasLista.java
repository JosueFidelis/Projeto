
public class RepositorioArtistasLista implements RepositorioArtistas {
	private Artista artista;
	private RepositorioArtistasLista proximo;
	
	public RepositorioArtistasLista() {
		
	}
	

	public String inserirArtista(Artista artista, boolean j) throws AJCException {
		if (j == true) {
			if (this.artista == null) {
				this.artista = artista;
				this.proximo = new RepositorioArtistasLista();
				return "Artista adicionado!!";
			} else {
				return this.proximo.inserirArtista(artista, j);
			}
		} else {
			AJCException e;
			e = new AJCException(artista.getNome());
			return e.getMessage();
		}

	}

	public String removerArtista(Artista artista) throws ANEException {
		if (this.artista != null) {
			if (this.artista.equals(artista)) {
				this.artista = this.proximo.artista;
				this.proximo = this.proximo.proximo;
				return "artista removido com sucesso";
			} else {
				return this.proximo.removerArtista(artista);
			}
		} else {
			ANEException e;
			e = new ANEException(artista.getNome());
			return e.getMessage();
		}
	}

	public String buscarArtista(Artista artista) throws ANEException {
		if (this.artista != null) {
			if (this.artista == artista) {

				return "Artista encontrado";
			} else {
				return this.proximo.buscarArtista(artista);
			}

		} else {
			ANEException e;
			e = new ANEException(artista.getNome());
			return e.getMessage();
		}

	}

	public boolean findArtista(Artista artista) {
		if (this.artista != null) {
			if (this.artista.Igual(artista)) {
				return true;
			} else {
				return this.proximo.findArtista(artista);
			}
		} else {
			return false;
		}

	}

}

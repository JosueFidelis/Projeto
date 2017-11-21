
public class RepositorioArtistasLista implements RepositorioArtistas {
	private Artista artista;
	private RepositorioArtistasLista proximo;

	public RepositorioArtistasLista() {
		this.artista = null;
		this.proximo = null;
	}

	public void inserirArtista(Artista artista) throws AJCException {
		if (this.artista == null) {
			this.artista = artista;
			this.proximo = new RepositorioArtistasLista();
			System.out.println("Artista adicionado!!"); 
		} else {
			if (this.artista.getNome().equals(artista.getNome())) {
				AJCException e;
				e = new AJCException(artista.getNome());
				throw e;
			} else {
				this.proximo.inserirArtista(artista);
			}	
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

	/*public boolean findArtista(Artista artista) {
		if (this.artista != null) {
			System.out.println("TESTADO");
			if (this.artista.Igual(artista)) {
				return false;
			} else {
				return this.proximo.findArtista(artista);
			}
		} else {
			return true;
		}
	}*/

	public void print() {
		Artista a = this.artista;
		while (a != null) {
			System.out.println(this.artista.getNome());
			a = proximo.artista;
		}
	}

}

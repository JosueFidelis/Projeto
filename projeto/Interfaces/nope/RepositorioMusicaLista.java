package nope;

public class RepositorioMusicaLista implements RepositorioMusicas {

	private Musica musica;
	private RepositorioMusicaLista proximo;

	public RepositorioMusicaLista() {
		this.musica = null;
		this.proximo = null;
	}

	public Musica getMusica() {
		return musica;
	}

	public RepositorioMusicaLista getProximo() {
		return proximo;
	}

	public void inserir(Musica musica) {
		if (this.musica == null) {
			this.musica = musica;
			this.proximo = new RepositorioMusicaLista();
		} else {
			this.proximo.inserir(musica);
		}
	}

	public void remover(Musica musica) {
		if (this.musica != null) {
			if (this.musica.equals(musica)) {
				this.musica = this.proximo.musica;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(musica);
			}
		} else {
			throw new RuntimeException("Musica não encontrada");
		}

	}

	public void tocar(Musica musica) {
		if (this.musica != null) {
			if (this.musica.equals(musica)) {
				System.out.println("A musica " + musica.getNome() + " está sendo reproduzida");
			} else {
				this.proximo.tocar(musica);
			}
		} else {
			System.out.println("A musica " + musica.getNome() + " não foi encontrada");
		}

	}

	public void buscar(Musica musica) {
		if (this.musica != null) {
			if (this.musica.equals(musica)) {
				System.out.println(musica.getNome() + "\n\nArtista: " + musica.getArtista() + "\nGenero: "
						+ musica.getGenero() + "\nDuracao: " + musica.getDuracao());
			} else {
				this.proximo.buscar(musica);
			}
		} else {
			System.out.println("A musica " + musica.getNome() + " não foi encontrada");
		}
	}

	public RepositorioMusicaLista getNext() {
		return this.proximo;
	}

	public RepositorioMusicaLista josue(String genero, RepositorioMusicaLista albiderg) {
		if (this.musica != null) {
			if (this.musica.getGenero().equals(genero)) {
				albiderg.inserir(this.musica);
				return this.proximo.josue(genero, albiderg);
			} else {
				return this.proximo.josue(genero, albiderg);
			}
		} else {
			return albiderg;
		}
	}
}
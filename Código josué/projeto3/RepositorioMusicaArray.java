public class RepositorioMusicaArray {

	private Musica[] musica = new Musica[99];

	public RepositorioMusicaArray() {
		musica[0] = null;
	}
	public Musica musicaP (int i) {
		return this.musica[i];
	}
	public void inserir(Musica musica) {
		for (int i = 0; i < this.musica.length; i++) {
			if (this.musica[i] == null) {
				this.musica[i] = musica;
			}
		}
	}

	public void remover(Musica musica) {
		for (int i = 0; i < this.musica.length; i++) {
			if (this.musica[i].equals(musica)) {
				this.musica[i] = null;
			}
		}
	}

	public void tocar(Musica musica) {
		boolean achou = true;
		for (int i = 0; ((i < this.musica.length) && (achou)); i++) {

			if (this.musica[i].equals(musica)) {
				System.out.println("A musica " + musica.getNome() + " está sendo reproduzida");
				achou = false;
			}
		}
		if (achou) {
			System.out.println("A musica " + musica.getNome() + " não foi encontrada");
		}
	}

	public void buscar(Musica musica) {
		boolean achou = true;
		for (int i = 0; ((i < this.musica.length) && (achou)); i++) {
			if (this.musica[i].equals(musica)) {
				System.out.println(musica.getNome() + "\n\nArtista: " + musica.getArtista() + "\nGenero: "
						+ musica.getGenero() + "\nDuracao: " + musica.getDuracao());
				achou = false;
			}
		}
		if (achou) {
			System.out.println("A musica " + musica.getNome() + " não foi encontrada");
		}
	}

	public RepositorioMusicaArray josue(String genero, RepositorioMusicaArray albiderg) {
		for (int i = 0; i < this.musica.length; i++) {
			if (this.musica[i].getGenero().equals(genero)) {
				albiderg.inserir(this.musica[i]);
			}
		}
		return albiderg;
	}
}
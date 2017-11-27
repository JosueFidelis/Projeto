package Repositorios;
import Exceptions.NaoEncontradaException;
import Radio.Musica;

public class RepositorioMusicaArray implements RepositorioMusicas {

	private Musica[] musica;

	public RepositorioMusicaArray() {
		this.musica = new Musica[99];
	}

	public void inserir(Musica musica) {
		boolean a = true;
		for (int i = 0; i < this.musica.length && a; i++) {
			if (this.musica[i] == null) {
				this.musica[i] = musica;
				a = false;
			}
		}
	}

	public Musica musicaP(int i) {
		return this.musica[i];
	}

	public void remover(Musica musica) throws NaoEncontradaException {
		boolean achou = true;
		for (int i = 0; i < this.musica.length; i++) {
			if (this.musica[i].equals(musica)) {
				this.musica[i] = null;
				achou = false;
			}
		}
		if(achou) {
			NaoEncontradaException e = new NaoEncontradaException();
			throw e;
		}
	}
	public Musica[] getArray() {
		return this.musica;
	}
	public void tocar(Musica musica) throws NaoEncontradaException {
		boolean achou = true;
		for (int i = 0; ((i < this.musica.length) && (achou)); i++) {

			if (this.musica[i].equals(musica)) {
				System.out.println("A musica " + musica.getNome() + " está sendo reproduzida");
				achou = false;
			}
		}
		if (achou) {
			NaoEncontradaException e = new NaoEncontradaException();
			throw e;
		}
	}

	public void buscar(Musica musica) throws NaoEncontradaException {
		boolean achou = true;
		for (int i = 0; ((i < this.musica.length) && (achou)); i++) {
			if (this.musica[i].equals(musica)) {
				System.out.println(musica.getNome() + "\n\nArtista: " + musica.getArtista() + "\nGenero: "
						+ musica.getGenero() + "\nDuracao: " + musica.getDuracao());
				achou = false;
			}
		}
		if (achou) {
			NaoEncontradaException e = new NaoEncontradaException();
			throw e;
		}
	}
}
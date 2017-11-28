package repositorio;

import Exceptions.NaoEncontradaException;
import Musica.Musica;

public class RepositorioMusicaArray implements RepositorioMusicas {

	private Musica[] musica;

	public RepositorioMusicaArray() {
		this.musica = new Musica[99];
	}

	public String inserir(Musica musica) {
		boolean a = true;
		for (int i = 0; i < this.musica.length && a; i++) {
			if (this.musica[i] == null) {
				this.musica[i] = musica;
				a = false;
				return "Musica adicionada com sucesso";
			}
		}
		return "numero de musicas ultrapassou o limite";
	}

	public Musica musicaP(int i) {
		return this.musica[i];
	}

	public String remover(Musica musica) throws NaoEncontradaException {
		boolean achou = false;
		for (int i = 0; (i < this.musica.length) && (!achou); i++) {
			if ((this.musica[i] != null) && (this.musica[i].equals(musica))) {
				this.musica[i] = null;
				achou = true;
				return "Musica removida com sucesso";
			}
		}
		if (!achou) {
			NaoEncontradaException e = new NaoEncontradaException();
			throw e;
		}
		return "que erro é esse meu deus?";
	}

	public Musica[] getArray() {
		return this.musica;
	}

	public String tocar(Musica musica) throws NaoEncontradaException {
		boolean achou = false;
		for (int i = 0; ((i < this.musica.length) && (!achou)); i++) {

			if ((this.musica[i] != null) && (this.musica[i].equals(musica))) {
				achou = true;
				return "A musica " + musica.getNome() + " está sendo reproduzida";
			}
		}
		if (!achou) {
			NaoEncontradaException e = new NaoEncontradaException();
			throw e;
		}
		return "erro desconhecido";
	}

	public boolean buscar(Musica musica) throws NaoEncontradaException {
		boolean achou = false;
		for (int i = 0; ((i < this.musica.length) && (!achou)); i++) {

			if ((this.musica[i] != null) && (this.musica[i].equals(musica))) {

				achou = true;
			}
		}
		if (!achou) {
			NaoEncontradaException e = new NaoEncontradaException();
			throw e;
		} else {
			return true;
		}
	}

}
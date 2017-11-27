package nopee;

import Exceptions.NaoEncontradaException;

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

	public String inserir(Musica musica) {
		if (this.musica == null) {
			this.musica = musica;
			this.proximo = new RepositorioMusicaLista();
			return "Musica adicionada com sucesso";
		} else {
			return this.proximo.inserir(musica);
		}
	}

	public String remover(Musica musica) throws NaoEncontradaException {
		if (this.musica != null) {
			if (this.musica.equals(musica)) {

				this.musica = this.proximo.musica;
				this.proximo = this.proximo.proximo;
				return "Musica removida com sucesso";
			} else {
				return this.proximo.remover(musica);
			}
		} else {
			NaoEncontradaException e = new NaoEncontradaException();
			throw e;

		}

	}

	public String tocar(Musica musica) throws NaoEncontradaException {
		if (this.musica != null) {
			if (this.musica.equals(musica)) {
				return "A musica " + musica.getNome() + " está sendo reproduzida";
			} else {
				return this.proximo.tocar(musica);
			}
		} else {
			NaoEncontradaException e = new NaoEncontradaException();
			throw e;
		}

	}

	public boolean buscar(Musica musica) throws NaoEncontradaException {
		if (this.musica != null) {
			if (this.musica.equals(musica)) {
				return true;
			} else {
				return this.proximo.buscar(musica);
			}
		} else {
			NaoEncontradaException e = new NaoEncontradaException();
			throw e;
		}
	}

	public RepositorioMusicaLista getNext() {
		return this.proximo;
	}
}
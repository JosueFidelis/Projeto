package Artista;

import Exceptions.AJCException;
import Exceptions.ANEException;

public class RepositorioArtistasArray implements RepositorioArtistas {
	private Artista[] artistas;
	private int index;

	public RepositorioArtistasArray() {
		artistas = new Artista[1000];
		index = 0;
	}

	public void inserir(Artista artista) throws AJCException {
		if (artistas[index] == null) {
			artistas[index] = artista;
			index++;
			System.out.println("Artista adicionado!!");
		} else {
			if (artistas[index] == artista) {
				AJCException e;
				e = new AJCException(artista.getNome());
				throw e;

			} else {
				index++;
				inserir(artista);
			}
		}
	}

	public void remover(String artista) throws ANEException {
		boolean achado = false;
		for (int i = 0; i < index; i++) {
			if (this.artistas[i].getNome().equals(artista)) {
				achado = true;
				this.artistas[i] = artistas[index - 1];
				this.artistas[index - 1] = null;
				index--;
			}
		}
		if (!achado) {
			ANEException e;
			e = new ANEException(artista);
			throw e;
		}
	}

	@Override
	public String buscar(String artista) throws ANEException {
		boolean achado = false;
		for (int i = 0; i < index; i++) {
			if (this.artistas[i].getNome().equals(artista)) {
				achado = true;

			}
		}
		if (!achado) {
			ANEException e;
			e = new ANEException(artistas[index].getNome());
			throw e;
		} else {
			return "Artista Encontrado";
		}
	}

	public String Atualizar(Artista artista) throws ANEException {
		boolean achado = false;
		for (int i = 0; i < index; i++) {
			if (this.artistas[i].getNome().equals(artista)) {
				this.artistas[i] = artista;
				achado = true;

			}
		}
		if (!achado) {
			ANEException e;
			e = new ANEException(artistas[index].getNome());
			throw e;
		} else {
			return "Artista Encontrado";
		}
	}

}
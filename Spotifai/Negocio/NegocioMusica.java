package Negocio;

import Exceptions.NaoEncontradaException;
import Musica.Musica;
import repositorio.RepositorioMusicaArray;
import repositorio.RepositorioMusicaLista;
import repositorio.RepositorioMusicas;


public class NegocioMusica {
	private RepositorioMusicas lista;

	public NegocioMusica(boolean a) {
		if (a) {
			this.lista = new RepositorioMusicaLista();
		} else {
			this.lista = new RepositorioMusicaArray();
		}
	}
	public RepositorioMusicas getRep(){
		return this.lista;
	}
	public String inserir(Musica musica) {
		return lista.inserir(musica);
	}

	public String remover(Musica musica) throws NaoEncontradaException {
		return lista.remover(musica);
	}

	public boolean buscar(Musica musica) throws NaoEncontradaException {
		return lista.buscar(musica);
	}

	public String tocar(Musica musica) throws NaoEncontradaException {
		return lista.tocar(musica);
	}
}

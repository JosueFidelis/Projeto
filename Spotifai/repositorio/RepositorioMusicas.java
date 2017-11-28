package repositorio;

import Exceptions.NaoEncontradaException;
import Musica.Musica;

public interface RepositorioMusicas {
	public String inserir(Musica musica);

	public String remover(Musica musica) throws NaoEncontradaException;

	public String tocar(Musica musica) throws NaoEncontradaException;

	public boolean buscar(Musica musica) throws NaoEncontradaException;

}
package nopee;

import Exceptions.NaoEncontradaException;

public interface RepositorioMusicas {
	public String inserir(Musica musica);

	public String remover(Musica musica) throws NaoEncontradaException;

	public String tocar(Musica musica) throws NaoEncontradaException;

	public boolean buscar(Musica musica) throws NaoEncontradaException;

}
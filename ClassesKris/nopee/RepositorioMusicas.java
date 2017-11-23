package nopee;

import Exceptions.NaoEncontradaException;

public interface RepositorioMusicas {
	public void inserir(Musica musica);

	public void remover(Musica musica) throws NaoEncontradaException;

	public void tocar(Musica musica) throws NaoEncontradaException;

	public void buscar(Musica musica) throws NaoEncontradaException;
	
	
}
package repositorio;

import Artista.Artista;
import Exceptions.AJCException;
import Exceptions.ANEException;

public interface RepositorioArtistas {
public void inserir(Artista artista)throws AJCException;
public void remover(String artista)throws ANEException;
public String buscar (String artista)throws ANEException;
public String Atualizar (Artista artista)throws ANEException;
}

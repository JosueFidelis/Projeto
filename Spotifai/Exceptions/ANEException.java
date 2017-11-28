package Exceptions;
public class ANEException extends Exception {
	public ANEException(String artista)
	{
		super("Artista "+artista+" não encontrado");
	}
}

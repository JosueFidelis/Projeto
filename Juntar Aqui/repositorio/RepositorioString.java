package repositorio;

import Exceptions.ErouException;

public interface RepositorioString {
	String imprimir(int i);

	void inserir(String x, int i);

	String remover(String x, int i) throws ErouException;

}

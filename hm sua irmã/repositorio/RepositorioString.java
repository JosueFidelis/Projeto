package interfaces;

import excecoes.ErouException;

public interface RepositorioString {
	String imprimir(int i);

	void inserir(String x, int i);

	String remover(String x, int i) throws ErouException;

}

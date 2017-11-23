package interfaces;

import excecoes.ErouException;
import user.ClasseAbstrataUser;
import excecoes.ComandoInvalidoException;

public interface RepositorioContas {
	String inserir(ClasseAbstrataUser conta, int i);

	String remover(String x, int i) throws ErouException;

	ClasseAbstrataUser procurar(String x, int i) throws ErouException;

}

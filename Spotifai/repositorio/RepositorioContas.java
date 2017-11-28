package repositorio;

import Exceptions.ErouException;
import user.ClasseAbstrataUser;


public interface RepositorioContas {
	String inserir(ClasseAbstrataUser conta, int i);

	String remover(String x, int i) throws ErouException;

	ClasseAbstrataUser procurar(String x, int i) throws ErouException;

}

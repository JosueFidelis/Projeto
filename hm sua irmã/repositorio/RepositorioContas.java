package repositorio;

import excecoes.Erou;
import user.ClasseAbstrataUser;

public interface RepositorioContas {
	String inserir(ClasseAbstrataUser conta, int i);
	String remover(ClasseAbstrataUser conta, int i)throws Erou;
	boolean procurar(ClasseAbstrataUser conta, int i);
	
}

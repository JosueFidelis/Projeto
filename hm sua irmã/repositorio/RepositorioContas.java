package repositorio;

import excecoes.Erou;
import user.ClasseAbstrataUser;

public interface RepositorioContas {
	String inserir(ClasseAbstrataUser conta);
	String remover(ClasseAbstrataUser conta)throws Erou;
	boolean procurar(ClasseAbstrataUser conta);
	
}

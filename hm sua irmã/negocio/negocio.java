package negocio;

import interfaces.RepositorioContas; 
import repositorios.RepositorioContasArray;
import repositorios.RepositorioContasLista;
import user.ClasseAbstrataUser;
import excecoes.ErouException;
import excecoes.ComandoInvalidoException;
import excecoes.ErouException;


public class negocio {
	private RepositorioContas x;
	
	public negocio(boolean islist) {
		if(islist) {
			this.x= new RepositorioContasLista();
		} else
			this.x = new RepositorioContasArray();
	}
	public String inserirConta(ClasseAbstrataUser x) {
		return this.x.inserir(x, 0);
	}
	
	public String removerContar(String x) throws ErouException {
		return this.x.remover(x, 0);
	}
	
	public ClasseAbstrataUser procurarConta(String x) throws ErouException {
		return this.x.procurar(x, 0);
	}
	
	public String conectarMetodos(String x, String y, int i) throws ErouException, ComandoInvalidoException {
		ClasseAbstrataUser c = this.x.procurar(x, i);
		return c.distribuidor(x, y);

	}
	
}

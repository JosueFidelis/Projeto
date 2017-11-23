package Negocio;

import Exceptions.ComandoInvalidoException;
import Exceptions.ErouException;
import repositorio.RepositorioContas;
import repositorio.RepositorioContasArray;
import repositorio.RepositorioContasLista;
import user.ClasseAbstrataUser;

public class NegocioUser {
	private RepositorioContas x;
	
	public NegocioUser(boolean islist) {
		if(islist) {
			this.x= new RepositorioContasLista();
		} else
			this.x = new RepositorioContasArray();
	}
	public String inserirConta(ClasseAbstrataUser x) {
		return this.x.inserir(x, 0);
	}
	
	public String removerConta(String x) throws ErouException {
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

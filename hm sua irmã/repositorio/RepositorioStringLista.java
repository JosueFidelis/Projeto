package repositorio;

import interfaces.RepositorioString;

public class RepositorioStringLista implements RepositorioString{
	private String nome;
	private RepositorioStringLista proximo;
	
	public RepositorioStringLista() {
		this.nome = null;
		this.proximo = null;
	}
	public String imprimir() {
		return "hm sua irmã";
	}

	public void inserir(String x) {
		if(this.nome == null) {
			this.nome = x;
			this.proximo = new RepositorioStringLista();
		}else {
			this.proximo.inserir(x);
		}
	}

	public void remover(String x) {
		if(this.nome == null) {
			return;
		}else if(this.nome.equals(x)){
			this.nome = this.proximo.nome;
			this.proximo = this.proximo.proximo;
		}else {
			this.proximo.remover(x);
		}
	}
	
}

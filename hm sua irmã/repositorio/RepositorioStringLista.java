package repositorios;

import interfaces.RepositorioString;
import excecoes.ErouException;

public class RepositorioStringLista implements RepositorioString {
	private String nome;
	private RepositorioStringLista proximo;

	public RepositorioStringLista() {
		this.nome = null;
		this.proximo = null;
	}

	public String imprimir(int i) {
		if (this.nome == null) {
			return null;
		} else {
			return this.getNome() + "\n" + this.proximo.imprimir(i);
		}
	}

	public String getNome() {
		return this.nome;
	}

	public void inserir(String x, int i) {
		if (this.nome == null) {
			this.nome = x;
			this.proximo = new RepositorioStringLista();
		} else {
			this.proximo.inserir(x, i);
		}
	}

	public String remover(String x, int i) throws ErouException {
		if (this.nome == null) {
			throw new ErouException();
		} else if (this.nome.equals(x)) {
			this.nome = this.proximo.nome;
			this.proximo = this.proximo.proximo;
			return null;
		} else {
			return this.proximo.remover(x, i);
		}
	}

}

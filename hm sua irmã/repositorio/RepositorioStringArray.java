package repositorios;

import interfaces.RepositorioString;
import excecoes.ErouException;

public class RepositorioStringArray implements RepositorioString {
	private String[] nome;

	public RepositorioStringArray() {
		this.nome = new String[9999999];
	}

	public String imprimir(int i) {
		if (this.nome[i] == null) {
			return null;
		} else {
			return this.nome[i] + "\n" + this.imprimir(i + 1);
		}
	}

	public void inserir(String x, int i) {
		if (this.nome[i] == null) {
			this.nome[i] = x;
		} else {
			this.inserir(x, i + 1);
		}

	}

	public String remover(String x, int i) throws ErouException {
		if (this.nome[i] == null) {
			throw new ErouException();
		} else if (this.nome[i].equals(x)) {
			return null;
		} else {
			return this.remover(x, i + 1);
		}

	}
}

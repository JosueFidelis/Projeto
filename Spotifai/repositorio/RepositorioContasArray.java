package repositorio;

import Exceptions.ErouException;

import user.ClasseAbstrataUser;

public class RepositorioContasArray implements RepositorioContas {
	private ClasseAbstrataUser conta[];
	
	public RepositorioContasArray() {
		this.conta = new ClasseAbstrataUser[9999999];
	}

	public String inserir(ClasseAbstrataUser conta, int i) {
		if (this.conta[i] == null) {
			this.conta[i] = conta;
			return "Conta " + this.conta[i].getLogin() + " registrada com sucesso!";
		} else {
			return this.inserir(conta, i + 1);
		}
	}

	public String remover(String x, int i) throws ErouException {
		if (this.conta[i] == null) {
			throw new ErouException();
		} else if (this.conta[i].getLogin().equals(x)) {
			this.realocar(i);
			return "Conta " + x + " foi removida com sucesso.";
		} else {
			return this.remover(x, i + 1);
		}

	}

	public void realocar(int i) {
		if (this.conta[i] == null || this.conta[i + 1] == null) {
			return;
		} else {
			this.conta[i] = this.conta[i + 1];
			this.realocar(i + 1);
		}

	}

	public ClasseAbstrataUser procurar(String x, int i) throws ErouException {
		if (this.conta[i] == null) {
			throw new ErouException();
		} else if (this.conta[i].getLogin().equals(x)) {
			return this.conta[i];
		} else {
			return this.procurar(x, i + 1);
		}
	}

}

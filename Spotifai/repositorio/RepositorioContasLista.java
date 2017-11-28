package repositorio;

import Exceptions.ErouException;
import user.ClasseAbstrataUser;


public class RepositorioContasLista implements RepositorioContas {
	private ClasseAbstrataUser conta;
	private RepositorioContasLista proximo;

	public RepositorioContasLista() {
		this.conta = null;
		this.proximo = null;
	}

	public String inserir(ClasseAbstrataUser conta, int i) {
		if (this.conta == null) {
			this.conta = conta;
			this.proximo = new RepositorioContasLista();
			return "Conta " + conta.getLogin() + " registrada com sucesso!";
		} else {
			return this.proximo.inserir(conta, i);

		}
	}

	public String remover(String x, int i) throws ErouException {
		if (this.conta == null) {
			ErouException e;
			e = new ErouException();
			throw e;
		} else if (this.conta.getLogin().equals(x)) {
			this.conta = this.proximo.conta;
			this.proximo = this.proximo.proximo;
			return "Conta " + x + " removida com sucesso.";
		} else {
			return this.proximo.remover(x, i);
		}
	}

	public ClasseAbstrataUser procurar(String x, int i) throws ErouException {
		if (this.conta.getLogin() == null) {
			throw new ErouException();
		} else if (this.conta.getLogin().equals(x)) {
			return this.conta;
		} else {
			return this.proximo.procurar(x, i);
		}

	}

}

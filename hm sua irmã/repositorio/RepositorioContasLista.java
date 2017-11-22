package repositorio;

mport excecoes.Erou;
import user.ClasseAbstrataUser;
import interfaces.RepositorioContas;

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

	public String remover(ClasseAbstrataUser conta, int i) throws Erou {
		if (this.conta == null) {
			Erou e;
			e = new Erou();
			return e.getMessage();
		} else if (this.conta == conta) {
			this.conta = this.proximo.conta;
			this.proximo = this.proximo.proximo;
			return "Conta " + conta.getLogin() + " removida com sucesso.";
		} else {
			return this.proximo.remover(conta, i);
		}
	}

	public boolean procurar(ClasseAbstrataUser conta, int i) {
		if (this.conta == null) {
			return false;
		} else if (this.conta == conta) {
			return true;
		} else {
			return this.procurar(conta, i);
		}

	}

}

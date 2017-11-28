package user;

import repositorio.RepositorioStringLista;
import Exceptions.ErouException;
import Exceptions.ComandoInvalidoException;

public abstract class ClasseAbstrataUser {
	private String login, numeroCartao, plano;
	private int numSeguidores, numSeguindo;
	private RepositorioStringLista seguidores, seguindo;

	public ClasseAbstrataUser(String login, String numeroCartao) {
		this.login = login;
		this.numeroCartao = numeroCartao;
		this.numSeguidores = 0;
		this.numSeguindo = 0;
	}

	public abstract String trocarPlano();

	public String getLogin() {
		return this.login;
	}

	public String getNumeroCartao() {
		return this.numeroCartao;
	}

	public String getPlano() {
		return this.plano;
	}

	public int getNumSeguidores() {
		return this.numSeguidores;
	}

	public int getNumSeguindo() {
		return this.numSeguindo;
	}

	public String getSeguidores() {
		return this.seguidores.imprimir(0);
	}

	public String getSeguindo() {
		return this.seguindo.imprimir(0);
	}

	public void setPlano(String x) {
		this.plano = x;
	}

	public String seguir(String x) {
		this.seguidores.inserir(x, 0);
		this.numSeguidores++;
		return this.getLogin() + " agora esta seguindo " + x + "!";
	}

	public String deixarDeSeguir(String x) throws ErouException {
		this.seguindo.remover(x, 0);
		this.numSeguindo--;
		return this.getLogin() + "deixou de seguir " + x + ".";
	}

	public String serSeguido(String x) {
		this.seguidores.inserir(x, 0);
		this.numSeguidores++;
		return this.getLogin() + "agora esta sendo seguido por " + x + ".";
	}

	public String deixarDeSerSeguido(String x) throws ErouException {
		return this.seguidores.remover(x, 0);
	}

	public String alterarNumeroCartao(String x) {
		this.numeroCartao = x;
		return "O numero do seu cartao foi alterado com sucesso para " + x + ".";
	}

	public String distribuidor(String x, String y) throws ComandoInvalidoException, ErouException {
		if (y.equals("seguir")) {
			return this.seguir(x);
		} else if (y.equals("deixar de seguir")) {
			return this.deixarDeSeguir(x);
		} else if (y.equals("ser seguido")) {
			return this.serSeguido(x);
		} else if (y.equals("deixar se ser seguido")) {
			return this.deixarDeSerSeguido(x);
		} else {
			throw new ComandoInvalidoException();
		}
	}
}

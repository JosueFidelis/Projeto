package user;

import repositorio.RepositorioStringLista;
import excecoes.Erou;

public abstract class ClasseAbstrataUser {
	private String login, numeroCartao, plano;
	private int numSeguidores, numSeguindo;
	private RepositorioStringLista seguidores, seguindo;
	
	public ClasseAbstrataUser(String login, String numeroCartao){
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
	
	public String Seguir(String x) {
		this.seguidores.inserir(x, 0);
		this.numSeguidores++;
		return "Você agora está seguindo " + x + "!";
	}
	
	public String deixarDeSeguir(String x) throws Erou {
		this.seguidores.remover(x, 0);
		this.numSeguindo--;
		return "Você deixou de seguir " + x + ".";
	}
	
	public String serSeguido(String x) {
		this.seguidores.inserir(x, 0);
		this.numSeguidores++;
		return this.getLogin() + "agora está sendo seguido por " + x + ".";
 	}
	
	public String deixarDeSerSeguido(String x) throws Erou {
			return this.seguidores.remover(x, 0);
	}
	public String alterarLogin(String x) {
		this.login = x;
		return "Seu login foi alterado com sucesso para " + x + ".";
	}
	
	public String alterarNumeroCartao(String x) {
		this.numeroCartao = x;
		return "O numero do seu cartao foi alterado com sucesso para " + x + ".";
	}
}

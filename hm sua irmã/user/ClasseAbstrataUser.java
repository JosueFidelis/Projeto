package user;

import repositorio.RepositorioStringLista;

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
		return this.seguidores.imprimir();
	}
	
	public String getSeguindo() {
		return this.seguidores.imprimir();
	}
	
	public void setPlano(String x) {
		this.plano = x;
	}
	
	public String Seguir(String x) {
		this.seguidores.inserir(x);
		this.numSeguidores++;
		return "Você agora está seguindo " + x + "!";
	}
	
	public String deixarDeSeguir(String x) {
		this.seguidores.remover(x);
		this.numSeguindo--;
		return "Você deixou de seguir " + x + ".";
	}
	
	public String serSeguido(String x) {
		this.seguidores.inserir(x);
		return this.getLogin() + "agora está sendo seguido por " + x + ".";
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

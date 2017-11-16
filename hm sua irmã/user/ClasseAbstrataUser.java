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
}

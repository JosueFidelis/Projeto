package excecoes;

import user.ClasseAbstrataUser;

public class Erou extends Exception {
	private ClasseAbstrataUser conta;
	public Erou() {
		super ("A conta  nao foi encontrada nos registros.");
	}
}

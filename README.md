# Projeto


	// Radio
	public String tocarRadio () throws NaoHaMusicasException {
		return this.radio.tocarRadio();
	}
	public Radio buscar (String genero) throws RadioNaoEncontradaException {
		return this.radio.buscar(genero);
	}
	public void remover (String genero) throws RadioNaoEncontradaException {
		this.radio.remover(genero);
	}
	public Radio criar (String genero, RepositorioMusicas rep, int i) throws NaoHaGeneroException {
		return radio.criar(genero, rep, i);
	}
	//fim Radio

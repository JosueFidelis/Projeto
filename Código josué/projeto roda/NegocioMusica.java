public class NegocioMusica {
	private RepositorioMusicas lista;

	public NegocioMusica(boolean a) {
		if (a) {
			this.lista = new RepositorioMusicaLista();
		} else {
			this.lista = new RepositorioMusicaArray();
		}
	}
	public void inserir(Musica musica) {
		lista.inserir(musica);
	}
	public void remover(Musica musica) throws NaoEncontradaException {
		lista.remover(musica);
	}
	public void buscar(Musica musica) throws NaoEncontradaException {
		lista.buscar(musica);
	}
	public void tocar(Musica musica) throws NaoEncontradaException {
		lista.tocar(musica);
	}
}

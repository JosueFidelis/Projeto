public class NegócioRadio {
	private RepositorioRadio radio;
	public NegócioRadio (boolean a) {
		if (a) {
			this.radio = new RepositorioRadioLista();
		} else {
			this.radio = new RepositorioRadioArray();
		}
	}
	public void inserir (Radio radio) {
		this.radio.inserir(radio);
	}
	public void remover (String genero) {
		this.radio.remover(genero);
	}
	public Radio buscar (String genero) throws RadioNaoEncontradaException {
		return this.radio.buscar(genero);
	}
	public void update (String genero){ 
		this.radio.update(genero);
	}
	public Radio josue (boolean a, String genero, RepositorioMusicas global, Radio radio) {
		if (a) {
			RepositorioMusicaLista globa = (RepositorioMusicaLista) global;
			if (globa.getMusica() != null) {
				if (globa.getMusica().getGenero().equals(genero)) {
					radio.getRadio().inserir(genero, globa.getMusica());
					return josue(a, genero, globa.getNext(), radio);
				} else {
					return josue (a, genero, globa.getNext(), radio);
				}
			} else {
				return radio;
			}
		} else {
			RepositorioMusicaArray globa = (RepositorioMusicaArray) global;
			for (int i = 0; i < globa.getArray().length; i++) {
				if (globa.musicaP(i).getGenero().equals(genero)) {
					radio.getRadio().inserir(genero, globa.musicaP(i));
				}
			}
			return radio;
		}
	}
}

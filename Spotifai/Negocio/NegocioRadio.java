package Negocio;
import Exceptions.*;
import Radio.Radio;
import repositorio.*;
public class NegocioRadio {
	private RepositorioRadio radioR;
	private boolean a;
	public NegocioRadio (boolean a) {
		if (a) {
			this.radioR = new RepositorioRadioLista();
			this.a = true;
		} else {
			this.radioR = new RepositorioRadioArray();
			this.a = false;
		}
	}
	public void inserir (Radio radio) {
		this.radioR.inserir(radio);
	}
	public void remover (String genero) throws RadioNaoEncontradaException {
		this.radioR.remover(genero);
	}
	public Radio buscarRadio (String genero) throws RadioNaoEncontradaException {
		return this.radioR.buscar(genero);
	}
	public String tocarRadio (String genero) throws NaoHaMusicasException, RadioNaoEncontradaException {
		return this.radioR.tocarRadio(genero);
	}
	public Radio criarRadio (String genero, RepositorioMusicas global, int o, Radio radio) throws NaoHaGeneroException {
		if (this.a) {
			RepositorioMusicaLista globa = (RepositorioMusicaLista) global;
			if (globa.getMusica() != null) {
				if (globa.getMusica().getGenero().equals(genero)) {
					radio.getRadio().inserir(genero, globa.getMusica());
					return criarRadio(genero, globa.getNext(), o + 1, radio);
				} else {
					return criarRadio (genero, globa.getNext(), o + 1, radio);
				}
			} else if (radio.getRadio().getMusica() == null) {
				NaoHaGeneroException e = new NaoHaGeneroException ();
				throw e;
			} else {
				this.radioR.inserir(radio);
				return radio;
			}
			
		} else {
			RepositorioMusicaArray globa = (RepositorioMusicaArray) global;
			boolean b = true;
			for (int i = 0; i < globa.getArray().length && b; i++) {
				if (globa.musicaP(i) == null) {
					b = false;
				} else {
					if (globa.musicaP(i).getGenero().equals(genero)) {
						radio.getRadio().inserir(genero, globa.musicaP(i));					
					}
				}
			}
			if (radio.getRadio().getMusica() == null) {
				NaoHaGeneroException e = new NaoHaGeneroException();
				throw e;
			}
			this.radioR.inserir(radio);
			return radio;
		}
	}
}

package Negócio;
import Classebasica.Radio;
import Exceptions.*;
import Repositorios.RepositorioMusicaArray;
import Repositorios.RepositorioMusicaLista;
import Repositorios.RepositorioMusicas;
import Repositorios.RepositorioRadio;
import Repositorios.RepositorioRadioArray;
import Repositorios.RepositorioRadioLista;
public class NegócioRadio {
	private RepositorioRadio radioR;
	private boolean a;
	public NegócioRadio (boolean a) {
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
	public void remover (String genero) {
		this.radioR.remover(genero);
	}
	public Radio buscar (String genero) throws RadioNaoEncontradaException {
		return this.radioR.buscar(genero);
	}
	public void update (String genero){ 
		this.radioR.update(genero);
	}
	public Radio josue (String genero, RepositorioMusicas global, Radio radio) throws NaoHaGeneroException {
		if (this.a) {
			RepositorioMusicaLista globa = (RepositorioMusicaLista) global;
			if (globa.getMusica() != null) {
				if (globa.getMusica().getGenero().equals(genero)) {
					radio.getRadio().inserir(genero, globa.getMusica());
					return josue(genero, globa.getNext(), radio);
				} else {
					return josue (genero, globa.getNext(), radio);
				}
			} else if (radio.getRadio().getMusica() == null) {
				NaoHaGeneroException e = new NaoHaGeneroException ();
				throw e;
			} else {
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
			return radio;
		}
	}
}

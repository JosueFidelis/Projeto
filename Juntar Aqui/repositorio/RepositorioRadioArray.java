package repositorio;

import Exceptions.*;
import Radio.Radio;

public class RepositorioRadioArray implements RepositorioRadio {
	private Radio[] radio;

	public RepositorioRadioArray() {
		radio = new Radio[99];
		radio[0] = null;
	}

	public void duplicar() {
		Radio[] NovoArray = new Radio[2 * this.radio.length];
		for (int i = 0; i < 2 * radio.length; i++) {
			NovoArray[i] = this.radio[i];
		}
	}

	public void trocar(int i) {
		for (; i < this.radio.length - 1; i++) {
			this.radio[i] = this.radio[i + 1];
		}
	}

	public void inserir(Radio radio) {
		boolean a = true;
		int o = 0;
		for (int i = 0; i < this.radio.length && a; i++) {
			if (this.radio[i] == null) {
				this.radio[i] = radio;
				o = i;
				a = false;
			}
		}
		if (o >= this.radio.length - 2) {
			duplicar();
		}
	}

	public void remover(String str) throws RadioNaoEncontradaException {
		boolean u = true;
		for (int i = 0; i < this.radio.length; i++) {
			if (radio[i].getRadio().getGenero().equals(str)) {
				trocar(i);
				u = false;
			}
		}
		if (u) {
			RadioNaoEncontradaException e = new RadioNaoEncontradaException();
			throw e;
		}
	}
	
	public Radio buscar(String genero) throws RadioNaoEncontradaException {
		for (int i = 0; i < this.radio.length; i++) {
			if ((this.radio[i] != null) && (this.radio[i].getRadio().getGenero().equals(genero))) {
				return this.radio[i];
			}
		}
		RadioNaoEncontradaException e = new RadioNaoEncontradaException();
		throw e;
	}
}

package Repositorios;
import Exceptions.RadioNaoEncontradaException;
import Radio.Radio;

public class RepositorioRadioLista implements RepositorioRadio {
	private Radio radio;
	private RepositorioRadioLista next;
	public RepositorioRadioLista () {
		this.radio = null;
		this.next = null;
	}
	public void inserir (Radio radio1) {
		if (this.radio == null) {
			this.radio = radio1;
			this.next = new RepositorioRadioLista ();
		} else {
			this.next.inserir(radio1);
		}
	}
	public Radio buscar (String genero) throws RadioNaoEncontradaException{
		if (this.radio != null) {
			if (this.radio.getRadio().equalsS(genero)) {
				return this.radio;
			} else if (this.next.radio != null){
				return this.next.buscar(genero);
			} else {
				RadioNaoEncontradaException e = new RadioNaoEncontradaException();
				throw e;
			} 
		}else {
			RadioNaoEncontradaException e = new RadioNaoEncontradaException();				
			throw e;
		}
	}
	public void remover (String genero) {
		if (this.radio.getRadio().getGenero().equals(genero)) {
			this.radio = this.next.radio;
			this.next = this.next.next;
		} else {
			this.next.remover(genero);
		}
	}
}

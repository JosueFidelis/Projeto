package Radio;
import java.util.Random;
import Exceptions.*;
import Musica.Musica;


public class ListaMusicaRadio {
	private Musica musica;
	private String genero;
	private int i;
	private ListaMusicaRadio next;

	public void inserir (String genero,  Musica musica) {
		if (this.musica == null) {
			this.musica = musica;
			int i = this.i + 1;
			this.next = new ListaMusicaRadio(genero, i);			
		} else {
			this.next.inserir(genero, musica);
		}
	}

	public ListaMusicaRadio(String genero, int i) {
		this.musica = null;
		this.genero = genero;
		this.i = i;
		this.next = null;
	}

	public String getGenero() {
		return this.genero;
	}
	
	public Musica getMusica () {
		return this.musica;
	}
	
	public boolean equals(ListaMusicaRadio radio) {
		return radio.getGenero().equals(this.genero);
	}
	
	public boolean equalsS(String genero) {
		return genero.equals(this.genero);
	}
	
	public String tocar() throws NaoHaMusicasException {
		if (this.musica == null) {
			NaoHaMusicasException e = new NaoHaMusicasException();
			throw e;
		}
		Random gerador = new Random();
		int i = gerador.nextInt(Math.abs(ListaLength(0)));
		return buscar(i);
	}
	
	public String buscar (int i) {
		if (this.i == i) {
			return this.musica.getNome();
		} else {
			return next.buscar(i);
		}
	}
	
	public int ListaLength (int i) {
		if (this.musica != null) {
			return this.next.ListaLength(i + 1);
		} else {
			return i;
		}
	}
	
	public ListaMusicaRadio getNext() {
		return next;
	}
}
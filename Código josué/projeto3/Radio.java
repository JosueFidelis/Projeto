import java.util.Random;
public class Radio {
	private Musica musica;
	private String genero;
	private int i;
	private RepositorioMusicaLista globalL;
	private RepositorioMusicaArray globalA;
	private Radio next;


	public Radio(String genero, RepositorioMusicaArray global, int i) {
		this.musica = null;
		this.genero = genero;
		this.i = i;
		this.next = null;
		this.globalA = global;
	}

	public void inserirA(String genero, int i) {
		if (globalA.musicaP(i) != null) {
			this.musica = globalA.musicaP(i);
			this.next.inserirA(genero, i);
		}
	}

	public Radio(String genero, RepositorioMusicaLista global, int i) {
		this.musica = null;
		this.genero = genero;
		this.i = i;
		this.next = null;
		this.globalL = global;
	}

	public void inserirL(String genero, RepositorioMusicaLista globalL) {
		RepositorioMusicaLista rep = new RepositorioMusicaLista();
		rep = globalL.josue(genero, rep);
		if (rep.getMusica() != null) {
			this.musica = rep.getMusica();
			int i = this.i + 1;
			this.next = new Radio (genero, this.globalL.getNext(), i);
			this.next.inserirL(genero, rep.getNext());
		}
	}
	public String getGenero() {
		return this.genero;
	}
	
	public boolean equals(Radio radio) {
		return radio.getGenero().equals(this.next.getGenero());
	}
	
	public boolean equalsS(String genero) {
		return genero.equals(this.next.getGenero());
	}
	
	public String tocar() {
		Random gerador = new Random();
		int i = gerador.nextInt(Math.abs(ListaLength(0)));
		System.out.println(i);
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
			System.out.println(i);
			return i;
		}
	}
}
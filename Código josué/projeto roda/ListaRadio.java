import java.util.Random;
public class ListaRadio {
	private Musica musica;
	private String genero;
	private int i;
	private ListaRadio next;

	public void inserir (String genero,  Musica musica) {		
		this.musica = musica;
		int i = this.i + 1;
		this.next = new ListaRadio(genero, i);
	}

	public ListaRadio(String genero, int i) {
		this.musica = null;
		this.genero = genero;
		this.i = i;
		this.next = null;
	}

	public void inserirL(String genero, RepositorioMusicaLista globalL) {
		RepositorioMusicaLista rep = new RepositorioMusicaLista();
		rep = globalL.josue(genero, rep);
		if (rep.getMusica() != null) {
			this.musica = rep.getMusica();
			int i = this.i + 1;
			this.next = new ListaRadio (genero, i);
			this.next.inserirL(genero, rep.getNext());
		}
	}

	public String getGenero() {
		return this.genero;
	}
	
	public boolean equals(ListaRadio radio) {
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
	
	public ListaRadio getNext() {
		return next;
	}
}
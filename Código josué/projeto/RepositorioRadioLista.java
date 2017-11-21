package projeto;
public class RepositorioRadioLista {
	private Musica musica;
	private String genero;
	private RepositorioMusicaLista global;
	private RepositorioRadioLista next;
	public RepositorioRadioLista (String genero, RepositorioMusicaLista global) {
		this.musica = null;
		this.genero = genero;
		this.next = null;
		this.global = global;
	}
	public void inserir (String genero) {
		if (this.global.getNext().getMusica() != null) {
			if(global.getMusica().getGenero().equals(genero)) {
				this.musica = global.getMusica();
				this.next = new RepositorioRadioLista(genero, this.global.getNext());
				this.next.inserir(genero);
			} else {
				this.inserir2(genero);
			}
		} 
	}
	public void inserir2 (String genero) {
		if (this.global.getNext().getMusica() != null) {
			if(global.getMusica().getGenero().equals(genero)) {
				this.musica = global.getNext().getMusica();
				this.next = new RepositorioRadioLista(genero, this.global.getNext());
				this.next.inserir(genero);
			} else {
				this.inserir2(genero);
			}
		} 
	}
}
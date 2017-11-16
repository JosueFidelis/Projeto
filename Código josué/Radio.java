public class Radio {
	private Musica musica;
	private String genero;
	private RepositorioMusicaLista global;
	private Radio next;
	public Radio (String genero, RepositorioMusica global) {
		this.musica = null;
		this.genero = genero;
		this.next = null;
		this.global = global;
	}
	public void inserir (String genero) {
		if (this.global.getNext().getMusica != null) {
			if(global.getMusica.getGenero.equals(genero)) {
				this.musica = global.getMusica();
				this.next = new Radio(genero, this.global.getNext);
				this.next.inserir(genero);
			}
		}
	}
}

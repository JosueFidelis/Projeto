public class Radio {
	private Musica musica;
	private String genero;
	private RepositorioMusicaLista globalL;
	private RepositorioMusicaArray globalA [];
	private Radio next;
	public String getGenero() {
		return this.genero;
	}
	public Radio (String genero, repositorioMusicaArray global) {
		this.musica = null;
		this.genero = genero;
		this.next = null;
		this.globalA = global;
	}
	public void inserirA (String genero, int i) {
		this.musica = globalA[i];
		if (globalA [i + 1] != null) {
			this.next.inserirA(genero, i);			
		}
	}
	public Radio (String genero, RepositorioMusicaLista global) {
		this.musica = null;
		this.genero = genero;
		this.next = null;
		this.globalL = global;
	}
	public void inserirL3 (String genero, RepositorioMusicaLista globalL) {
		if (globalL.josue(genero, globalL).getMusica() != null) {
			this.musica = globalL.josue(genero, globalL).getMusica();
			this.next.inserirL3(genero, globalL);
		}
	}
	public void inserirL (String genero) {
		if (this.globalL.getMusica() != null) {
			if(globalL.getMusica().getGenero().equals(genero)) {
				this.musica = globalL.getMusica();
				this.next = new Radio(genero, this.globalL.getNext());
				this.next.inserirL(genero);
			} else {
				this.inserirL2(genero);
			}
		} 
	}
	public void inserirL2 (String genero) {
		if (this.globalL.getNext().getMusica() != null) {
			if(globalL.getMusica().getGenero().equals(genero)) {
				this.musica = globalL.getNext().getMusica();
				this.next = new Radio(genero, this.globalL.getNext());
				this.next.inserirL(genero);
			} else {
				this.inserirL2(genero);
			}
		} 
	}
}
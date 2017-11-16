package nope;

public class Musica {
	private String nome;
	private String artista;
	private String genero;
	private int duracao;

	public Musica(String nome, String artista, String genero) {
		this.nome = nome;
		this.artista = artista;
		this.genero = genero;
	}

	public String getNome() {
		return this.nome;
	}

	public int getDuracao() {
		return duracao;
	}

	public String getArtista() {
		return this.artista;
	}

	public String getGenero() {
		return this.genero;
	}

	public boolean equals(Musica musica) {
		return ((musica.getNome().equals(this.nome)) && (musica.getDuracao() == this.duracao)
				&& (musica.getArtista().equals(this.artista)) && (musica.getGenero().equals(this.genero)));
	}

	
}
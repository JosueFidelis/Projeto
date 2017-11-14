package nope;

public class Musica {
	private String nome;
	private String autor;
	private String genero;

	public Musica(String nome, String autor, String genero) {
		this.nome = nome;
		this.autor = autor;
		this.genero = genero;
	}

	public String getNome_Musica() {
		return this.nome;
	}

	public String getAutor_Musica() {
		return this.autor;
	}

	public String getGenero_Musica() {
		return this.genero;
	}

}
package Artista;

public class Artista {
private String nome;
private String album;
private String fas;
public Artista(String a, String b, String d ) {
	this.nome=a;
	this.album=b;
	this.fas=d;
}
public String getNome() {
	return this.nome;
}
public String getAlbum() {
	return this.album;
}
public String getFas() {
	return this.fas;
}
public boolean Igual(Artista x) {
	return x.getNome().equals(this.getNome());
}
	
	
}
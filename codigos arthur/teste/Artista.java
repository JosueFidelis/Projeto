
public class Artista {
private String nome;
private Album album;
private Musicas musicas;
private String f�s;
public Artista(String a, Album b, Musicas c, String d ) {
	this.nome=a;
	this.album=b;
	this.musicas=c;
	this.f�s=d;
}
public String getNome() {
	return this.nome;
}
public boolean Igual(Artista x) {
	return x.getNome().equals(this.getNome());
}
	
	
}
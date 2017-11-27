package repositorio;
import Artista.Artista;
import Exceptions.ANEException;

public class RepositroioArtistasArray {
	private Artista[] artistas;
	private int index;

	public RepositroioArtistasArray() {
		artistas = new Artista[1000];
		index = 0;
	}

public String Adicionar(Artista artista) {
		this.artistas[index]=artista;
	    index++;
	    return "Artista "+ artista.getNome()+" adicionado.";
}
public String remover(String artista) throws ANEException {
	boolean achado = false;	
	for (int i = 0; i<1000;i ++) {
		if( artistas[i].getNome().equals(artista)) {
		achado =true;
		}
	}
	if(!achado) {
		ANEException e;
		e = new ANEException(artista);
		return e.getMessage();
	}else {
		return "artista removido com sucesso";
	}
}

}
package repositorio;

import Artista.Artista;
import Exceptions.AJCException;
import Exceptions.ANEException;

public class RepositorioArtistasLista implements RepositorioArtistas {
	private Artista artista;
	private RepositorioArtistasLista proximo;

	public RepositorioArtistasLista() {
		this.artista = null;
		this.proximo = null;
	}

	public void inserir(Artista artista) throws AJCException {
		if (this.artista == null) {
			this.artista = artista;
			this.proximo = new RepositorioArtistasLista();

		} else {
			if (this.artista.getNome().equals(artista.getNome())) {
				AJCException e;
				e = new AJCException(artista.getNome());
				throw e;
			} else {
					this.proximo.inserir(artista);
			}	
		}
	}

	public void remover(String artista) throws ANEException {
		if (this.artista != null) {
			if (this.artista.equals(artista)) {
				this.artista = this.proximo.artista;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(artista);
			}
		} else {
			System.out.println("não existe");
			ANEException e;
			e = new ANEException(artista);
			e.getMessage();
		}
	}

	public String buscar(String artista) throws ANEException {
		if (this.artista != null) {
			if (this.artista.getNome().equals(artista)) {
				return "Artista encontrado";
			} else {
				return proximo.buscar(artista);
			}
		} else {
			ANEException e;
			e = new ANEException(artista);
			throw e;
		}

	}
	public String Atualizar (Artista artista)throws ANEException{
		if(this.artista !=null) {
			if(this.artista==artista) {
				this.artista=artista;
				return "Atualizção concluída";
			}else {
				return this.proximo.Atualizar(artista);
			}
		}else {
			ANEException e;
			e=new ANEException (artista.getNome());
			return e.getMessage();
		}
	}

	/*public boolean findArtista(Artista artista) {
		if (this.artista != null) {
			System.out.println("TESTADO");
			if (this.artista.Igual(artista)) {
				return false;
			} else {
				return this.proximo.findArtista(artista);
			}
		} else {
			return true;
		}
	}*/
	}

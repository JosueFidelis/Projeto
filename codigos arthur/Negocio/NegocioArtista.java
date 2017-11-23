package Negocio;
import Exceptions.ANEException;
import Exceptions.AJCException;
import Artista.Artista;
import Artista.RepositorioArtistas;
import Artista.RepositorioArtistasLista;
import Artista.RepositorioArtistasArray;

public class NegocioArtista {
       private RepositorioArtistas list;
       
       public NegocioArtista(boolean islist){
    	   if(islist=true)
    		   list=new RepositorioArtistasLista();
    	   else
    		   list = new RepositorioArtistasArray();
       }
       
       public String buscarArtista(String nome)throws ANEException{
    	   return list.buscar(nome);
       }
       public void inserirArtista(String nome, String b,String c)throws AJCException{
    	   Artista a = new Artista(nome,b,c);
    	   list.inserir(a);
       }
       public void removerArtista(String nome )throws ANEException{
    	   	list.remover(nome);
       }
       public void atualizarArtista(String nome,String b, String c)throws ANEException{
    	   Artista a = new Artista(nome, b,c);
    	   list.Atualizar(a);
       }
}

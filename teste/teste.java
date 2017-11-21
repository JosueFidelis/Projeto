import java.util.Scanner;
public class teste {

	public void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String x;
		x=in.nextLine();
		while (!x.equals("fim")) {
			x=in.nextLine();
			RepositorioArtistasLista A = new RepositorioArtistasLista();
			if(x.equals("adicionar artista")) {
			String n = in.nextLine();
			Album b= new Album (0);
			Musicas c=new Musicas(0);
			String d=in.nextLine();
		    Artista a = new Artista(n,b,c,d);
		    boolean j =A.findArtista(a);
		    try {
		    	A.inserirArtista(a,j);
		    }catch(AJCException e) {
		    	e.getMessage();
		    }
		    
			}
		}
		
	}

}

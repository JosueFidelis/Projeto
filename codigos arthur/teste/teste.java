import java.util.Scanner;
public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String x;
		x=in.nextLine();
		RepositorioArtistasLista A = new RepositorioArtistasLista();
		while (!x.equals("fim")) {
			System.out.println("digitar comando");
			x=in.nextLine();
			if(x.equals("add")) {
				System.out.println("nome do artista");
			String n = in.nextLine();
			System.out.println("numero de fãs");
			Album b= new Album (0);
			Musicas c=new Musicas(0);
			String d=in.nextLine();
			System.out.println("novo artista variavel");
		    Artista a = new Artista(n,b,c,d);
		    System.out.println("criado");
		   
		    try {
		    	A.inserirArtista(a);
		    	System.out.println("inserido");
		    }catch(AJCException e) {
		    	System.out.println(e.getMessage());
		    }
		    A.print();
		    
			}
		}
		
		
	}

}

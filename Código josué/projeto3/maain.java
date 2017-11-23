import java.util.Scanner;
public class maain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Musica musica = new Musica ("bohemia", "queen", "rock");
		Musica musica1 = new Musica ("sdds", "dsad", "rock");
		RepositorioMusicaLista rep = new RepositorioMusicaLista ();
		rep.inserir(musica);
		rep.inserir(musica1);
		Radio radio = new Radio ("rock", rep, 0);
		radio.inserirL("rock", rep);
		System.out.println(radio.tocar());
	}
}

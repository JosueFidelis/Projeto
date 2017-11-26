import java.util.Scanner;
public class maain {
	public static void main(String[] args) {
		boolean a = true;
		NegócioRadio r = new NegócioRadio(a);
		// TODO Auto-generated method stub
		Musica musica = new Musica ("bohemia", "queen", "rock");
		Musica musica1 = new Musica ("sdds", "dsad", "rock");
		RepositorioMusicaLista rep = new RepositorioMusicaLista ();
		rep.inserir(musica);
		rep.inserir(musica1);
		Radio radio = new Radio ("rock", 0);
		radio = r.josue(a, "rock", rep, radio);
		try {
			radio = r.buscar("rock");			
		} catch (RadioNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}		
		//radio.inserirL("rock", rep);
		System.out.println(radio.tocar());
	}
}

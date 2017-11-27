import Exceptions.*;
import Negócio.NegócioRadio;
import Repositorios.RepositorioMusicaArray;

import java.util.Scanner;

import Classebasica.Musica;
import Classebasica.Radio;
public class maain {
	public static void main(String[] args) {
		boolean a = false;
		NegócioRadio r = new NegócioRadio(a);
		// TODO Auto-generated method stub
		Musica musica = new Musica ("bohemia", "queen", "rock", 1);
		Musica musica1 = new Musica ("sdds", "dsad", "rock", 1);
		RepositorioMusicaArray rep = new RepositorioMusicaArray ();
		rep.inserir(musica);
		rep.inserir(musica1);
		Radio radio = new Radio ("rock", 0);
		try {
			radio = r.josue("rock", rep, radio);			
		} catch (NaoHaGeneroException e) {
			System.out.println(e.getMessage());
		}
		try {
			radio = r.buscar("rock");			
		} catch (RadioNaoEncontradaException e) {
			System.out.println(e.getMessage());
		} 		
		//radio.inserirL("rock", rep);
		System.out.println(radio.tocar());
	}
}

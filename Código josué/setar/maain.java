import Exceptions.*;
import Negocio.*;
import Radio.*;
import Repositorios.*;

import java.util.Scanner;
public class maain {
	public static void main(String[] args) {
		boolean a = true;
		NegócioRadio radio = new NegócioRadio(a, "rock");
		// TODO Auto-generated method stub
		Musica musica = new Musica ("bohemia", "queen", "rock", 1);
		Musica musica1 = new Musica ("sdds", "dsad", "rock", 1);
		NegocioMusica rep = new NegocioMusica (a);
		rep.inserir(musica);
		rep.inserir(musica1);
		try {
			radio.setRadio(radio.criar("rock", rep.getRep(), 0));
			radio.inserir(radio.getRadio());
		} catch (NaoHaGeneroException e) {
			System.out.println(e.getMessage());
		}
		try {
			radio.buscar("rock");			
		} catch (RadioNaoEncontradaException e) {
			System.out.println(e.getMessage());
		} 		
		//radio.inserirL("rock", rep);
		try {
			System.out.println(radio.tocar());			
		} catch (NaoHaMusicasException e) {
			System.out.println(e.getMessage());
		}
	}
}

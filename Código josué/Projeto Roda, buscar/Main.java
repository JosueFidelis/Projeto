package Main;

import java.util.Scanner;

import Exceptions.NaoEncontradaException;
import nopee.Musica;
import nopee.RepositorioMusicaLista;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int alfa = 1;
		RepositorioMusicaLista lista = new RepositorioMusicaLista();
		while (alfa == 1) {
			
			System.out.println("\nQue operação deseja realizar?");
			System.out.println("1-Cadastrar Musica");
			System.out.println("2-Remover Musica ");
			System.out.println("3-Reproduzir Musica");
			System.out.println("4-Buscar Musica");

			int x = in.nextInt();
			in.nextLine();
			if (x != 1 && x != 2 && x != 3 && x != 4) {
				System.out.println("Comando Inválido");
			} else {
				
				System.out.println("Insira o nome da Musica");
				String a = in.nextLine();
				System.out.println("Insira o autor da Musica");
				String b = in.nextLine();
				System.out.println("Insira o gênero da Musica");
				String c = in.nextLine();
				System.out.println("Insira o tempo de duração da Musica(em segundos)");
				int d = in.nextInt();
				in.nextLine();
				Musica musica = new Musica(a, b, c, d);
				
				if (x == 1) {
					lista.inserir(musica);
				} else if (x == 2) {
					try {
						lista.remover(musica);
					} catch (NaoEncontradaException e) {
						System.out.println(e.getMessage());
					}
				} else if (x == 3) {
					try {
						lista.tocar(musica);
					} catch (NaoEncontradaException e) {
						System.out.println(e.getMessage());
					}
				} else if (x == 4) {
					try {
						lista.buscar(musica);
					} catch (NaoEncontradaException e) {
						System.out.println(e.getMessage());
					}
				}

			}
		}
		in.close();
	}
}
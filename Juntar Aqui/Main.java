import ISpotifai.Spotify;
import java.util.Scanner;

import Exceptions.PlaylistNaoEncontradaException;
public class Main {
	static Spotify spotify = new Spotify(true);
	public static Scanner in = new Scanner(System.in); 
	public static void main(String[] args) {
		Start();

	}
	public static void Start()
	{
		System.out.println("Oque deseja fazer agora ?\n1-Criar Playlist\n2-Remover Playlist\n3-Buscar Playlist");
		String x = in.nextLine();
		switch(x.charAt(0))
		{
		case '1':
			Criar();
			break;
		case '2':
			Remover();
			break;
		case '3':
			Buscar();
			break;
		default:
			System.out.println("Comando inválido");
			Start();
				
		}
	}
	public static void Criar()
	{
		System.out.println("Digite o nome da playlist que quer criar");
		String name = in.nextLine();
		System.out.println("A conta é premium(1) ou gratuita(2)?");
		String x = in.nextLine();
		switch(x.charAt(0)) {
		case '1':
			spotify.criarPlaylist(name, true);
			System.out.println("Playlist Criada!");
			Start();
			break;
		case'2':
			spotify.criarPlaylist(name, false);
			System.out.println("Playlist Criada!");
			Start();
			break;
			default:
				System.out.println("comando inválido");
				Start();
		}
	}
	public static void Remover()
	{
		System.out.println("Digite o nome da playlist que quer remover");
		String name = in.nextLine();
		try{spotify.removerPlaylist(name);}
		catch(PlaylistNaoEncontradaException e){
			System.out.println(e.getMessage());
		}
		Start();
	}
	public static void Buscar()
	{
		System.out.println("Digite o nome da playlist que quer buscar");
		String name = in.nextLine();
		try{System.out.println(spotify.buscarPlaylist(name).listar());}
		catch(PlaylistNaoEncontradaException e){
			System.out.println(e.getMessage());
		}
		Start();
	}
	
}

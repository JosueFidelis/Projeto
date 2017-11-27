import ISpotifai.Spotify;

import java.util.Scanner;

import Exceptions.*;

public class Main {
	static Spotify spotify = new Spotify(true);
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Start();

	}

	public static void Start() {
		System.out.println(
				"Oque deseja fazer agora ?\n1-Gerenciar Playlists\n2-Gerenciar Contas\n3-Gerenciar Artistas\n4-Gerenciar Musicas\n5-Gerenciar Radio");
		String x = in.nextLine();
		switch (x.charAt(0)) {
		case '1':
			Playlists();
			break;
		case '2':
			Contas();
			break;
		case '3':
			Artistas();
			break;
		case '4':
			Musicas();
			break;
		case '5':
			Radio();
			break;
		default:
			System.out.println("Comando inválido");
			Start();

		}
	}

	public static void CriarPlaylist() {
		System.out.println("Digite o nome da playlist que quer criar");
		String name = in.nextLine();
		System.out.println("A conta é premium(1) ou gratuita(2)?");
		String x = in.nextLine();
		switch (x.charAt(0)) {
		case '1':
			spotify.criarPlaylist(name, true);
			System.out.println("Playlist Criada!");
			Start();
			break;
		case '2':
			spotify.criarPlaylist(name, false);
			System.out.println("Playlist Criada!");
			Start();
			break;
		default:
			System.out.println("comando inválido");
			Start();
		}
	}

	public static void RemoverPlaylist() {
		System.out.println("Digite o nome da playlist que quer remover");
		String name = in.nextLine();
		try {
			spotify.removerPlaylist(name);
		} catch (PlaylistNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
		Start();
	}

	public static void BuscarPlaylist() {
		System.out.println("Digite o nome da playlist que quer buscar");
		String name = in.nextLine();
		try {
			System.out.println(spotify.buscarPlaylist(name).listar());
		} catch (PlaylistNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
		Start();
	}

	public static void CriarArtista() {
		System.out.println("Qual nome do artista que deseja inserir?");
		String name = in.nextLine();
		System.out.println("Qual nome dos albuns do artista que deseja inserir?");
		String albuns = in.nextLine();
		System.out.println("Qual o numero de fãs do artista que deseja inserir?");
		String f = in.nextLine();
		try {
			spotify.criarArtista(name, albuns, f);
		} catch (AJCException e) {
			System.out.println(e.getMessage());
		}
		Start();

	}

	public static void RemoverArtista() {
		System.out.println("Qual nome do artista que deseja remover?");
		String name = in.nextLine();
		try {
			spotify.removerArtista(name);
		} catch (ANEException e) {
			System.out.println(e.getMessage());
		}
		Start();
	}

	public static void buscarArtista() {
		System.out.println("Qual nome do artista que deseja buscar?");
		String name = in.nextLine();
		try {
			System.out.println(spotify.buscarArtista(name));
		} catch (ANEException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void atualizarArtista() {
		System.out.println("Qual nome do artista que deseja atualizar?");
		String name = in.nextLine();
		System.out.println("Qual nome dos albuns do artista que deseja atualizar?");
		String albuns = in.nextLine();
		System.out.println("Qual o numero de fãs do artista que deseja atualizar?");
		String f = in.nextLine();
		try {
			spotify.atualizarArtista(name, albuns, f);
		} catch (ANEException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void tocarRadio()
	{
		System.out.print("Digite o gênero da radio que quer tocar");
		String gender = in.nextLine();
		try{System.out.println(spotify.buscarRadio(gender).tocar());
		
		}catch(RadioNaoEncontradaException e) {
			System.out.println(e.getMessage());			
		} catch(NaoHaMusicasException e)
		{
			System.out.println(e.getMessage()); 
		}
		Start();
	}
	public static void criarRadio () {
		System.out.print("Digite o gênero da radio que quer criar");
		String genero = in.nextLine();
		try {
			int i = 0;
			spotify.criarRadio(genero, i);
		} catch (NaoHaGeneroException e) {
			System.out.println(e.getMessage());
		} Start();
	}
	public static void removerRadio () {
		System.out.print("Digite o gênero da radio que quer remover");
		String genero = in.nextLine();
		try {
			spotify.removerRadio(genero);
		} catch (RadioNaoEncontradaException e) {
			System.out.println(e.getMessage());
		} Start();
	}
	 
	
	

	public static void criarConta() {
		System.out.println("Digite o seu nome de usuario.");
		String login = in.nextLine();
		System.out.println("Digite o numero do seu cartao");
		String nc = in.nextLine();
		System.out.println(spotify.inserirConta(login, nc));
		Start();
	}

	public static void removerConta() {
		System.out.println("Qual o login da conta que voce quer excluir?");
		String login = in.nextLine();
		try {
			System.out.println(spotify.removerConta(login));
		} catch (ErouException e) {
			System.out.println(e.getMessage());
		}
		Start();
	}

	public static void procurarConta() {
		System.out.println("Digite o nome da conta que deseja procurar");
		String login = in.nextLine();
		try {
			System.out.println(spotify.procurarConta(login));
		} catch (ErouException e) {
			System.out.println(e.getMessage());
		}
		Start();
	}

	public static void seguirAlguem() {

		System.out.println("Digite o nome da sua conta e da conta que voce deseja seguir");
		String login1 = in.nextLine();
		String login2 = in.nextLine();
		try {
			System.out.println(spotify.seguir(login1, login2));
		} catch (ErouException e) {
			System.out.println(e.getMessage());
		} catch (ComandoInvalidoException d) {
			System.out.println(d.getMessage());
		}
		Start();
	}

	public static void deixarDeSeguirAlguem() {
		System.out.println("Digite o nome da sua conta e da conta que deseja deixar de seguir");
		String login1 = in.nextLine();
		String login2 = in.nextLine();
		try {
			spotify.deixarDeSeguir(login1, login2);
		} catch (ErouException e) {
			System.out.println(e.getMessage());
		} catch (ComandoInvalidoException d) {
			System.out.println(d.getMessage());
		}
		Start();
	}

	public static void trocarPlano() {
		System.out.println("Digite o nome do sua conta");
		String login = in.nextLine();
		try {
			System.out.println(spotify.trocarPlano(login));
		} catch (ErouException e) {
			System.out.println(e.getMessage());
		}
		Start();
	}

	public static void cheat() {
		System.out.println("Digite o nome da sua conta e o comando secreto");
		String login = in.nextLine();
		String comando = in.nextLine();
		try {
			spotify.cheatDePlano1(login, comando);
		} catch (ErouException e) {
			System.out.println(e.getMessage());
		} catch (ComandoInvalidoException d) {
			System.out.println(d.getMessage());
			Start();
		}

		System.out.println("Digite o segundo comando secreto");
		comando = in.nextLine();
		try {
			spotify.cheatDePlano2(login, comando);
		} catch (ErouException e) {
			System.out.println(e.getMessage());
		} catch (ComandoInvalidoException d) {
			System.out.println(d.getMessage());
			Start();
		}

		System.out.println("Digite o terceiro comando secreto");
		comando = in.nextLine();
		try {
			spotify.cheatDePlano3(login, comando);
		} catch (ErouException e) {
			System.out.println(e.getMessage());
		} catch (ComandoInvalidoException d) {
			System.out.println(d.getMessage());
			Start();
		}

		System.out.println("Digite o quarto comando secreto");
		comando = in.nextLine();
		try {
			spotify.cheatDePlano3(login, comando);
		} catch (ErouException e) {
			System.out.println(e.getMessage());
		} catch (ComandoInvalidoException d) {
			System.out.println(d.getMessage());
			Start();
		}

		System.out.println("Digite o quinto comando secreto");
		comando = in.nextLine();
		try {
			spotify.cheatDePlano3(login, comando);
		} catch (ErouException e) {
			System.out.println(e.getMessage());
		} catch (ComandoInvalidoException d) {
			System.out.println(d.getMessage());
			Start();
		}

		try {
			spotify.promover(login, "5 estrelas");

		} catch (ErouException e) {
			System.out.println(e.getMessage());
		} catch (ComandoInvalidoException d) {
			System.out.println(d.getMessage());
		}
		Start();

	}

	public static void inserirMusica() {
		System.out.println("Digite o nome da musica");
		String nome = in.nextLine();
		System.out.println("Digite o autor da musica");
		String artista = in.nextLine();
		System.out.println("Digite o gênero da musica");
		String genero = in.nextLine();
		System.out.println("Digite a duracao da musica");
		int duracao = in.nextInt();
		in.nextLine();
		spotify.inserir(nome, genero, artista, duracao);
		Start();
	}

	public static void removerMusica() {
		System.out.println("Digite o nome da musica");
		String nome = in.nextLine();
		System.out.println("Digite o autor da musica");
		String artista = in.nextLine();
		System.out.println("Digite o gênero da musica");
		String genero = in.nextLine();
		System.out.println("Digite a duracao da musica");
		int duracao = in.nextInt();
		in.nextLine();
		try {
			spotify.remover(nome, genero, artista, duracao);
		} catch (NaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
		Start();
	}

	public static void tocarMusica() {
		System.out.println("Digite o nome da musica");
		String nome = in.nextLine();
		System.out.println("Digite o autor da musica");
		String artista = in.nextLine();
		System.out.println("Digite o gênero da musica");
		String genero = in.nextLine();
		System.out.println("Digite a duracao da musica");
		int duracao = in.nextInt();
		in.nextLine();
		try {
			System.out.println(spotify.tocar(nome, genero, artista, duracao));
		} catch (NaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
		Start();
	}

	public static void buscarMusica() {
		System.out.println("Digite o nome da musica");
		String nome = in.nextLine();
		System.out.println("Digite o autor da musica");
		String artista = in.nextLine();
		System.out.println("Digite o gênero da musica");
		String genero = in.nextLine();
		System.out.println("Digite a duracao da musica");
		int duracao = in.nextInt();
		in.nextLine();
		try {
			spotify.buscar(nome, genero, artista, duracao);
		} catch (NaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
		Start();
	}

	public static void Playlists() {
		System.out.println("Oque deseja fazer agora ?\n1-Criar Playlists\n2-Remover Playlist\n3-Buscar Playlist");
		String x = in.nextLine();
		switch (x.charAt(0)) {
		case '1':
			CriarPlaylist();
			break;
		case '2':
			RemoverPlaylist();
			break;
		case '3':
			BuscarPlaylist();
			break;
		default:
			System.out.println("Comando inválido");
			Start();

		}
	}

	public static void Contas() {
		System.out.println(
				"Oque deseja fazer agora ?\n1-Criar uma conta Musica\n2-Remover uma conta Musica\n3-Procurar uma Conta\n4- Seguir alguem\n5-Deixar de seguir alguem\n"
				+ "6-Trocar de plano\n7-Usar o cheat ");
		String x = in.nextLine();
		switch (x.charAt(0)) {
		case '1':
			criarConta();
			break;
		case '2':
			removerConta();
			break;
		case '3':
			procurarConta();
			break;
		case '4':
			seguirAlguem();
			break;
		case '5':
			deixarDeSeguirAlguem();
			break;
		case '6':
			trocarPlano();
			break;
		case '7':
			cheat();
			break;
		default:
			System.out.println("Comando inválido");
			Start();
		}
	}

	public static void Artistas() {
		System.out.println(
				"Oque deseja fazer agora ?\n1-Inserir Artista\n2-Remover Artista\n3-Buscar Artista\n4-Atualizar Artista");
		String x = in.nextLine();
		switch (x.charAt(0)) {
		case '1':
			CriarArtista();
			break;
		case '2':
			RemoverArtista();
			break;
		case '3':
			buscarArtista();
			break;
		case '4':
			atualizarArtista();
			break;
		default:
			System.out.println("Comando inválido");
			Start();

		}
	}

	public static void Musicas() {
		System.out.println(
				"Oque deseja fazer agora ?\n1-Inserir Musica\n2-Remover Musica\n3-Buscar Musica\n4-Tocar uma Musica");
		String x = in.nextLine();
		switch (x.charAt(0)) {
		case '1':
			inserirMusica();
			break;
		case '2':
			removerMusica();
			break;
		case '3':
			buscarMusica();
			break;
		case '4':
			tocarMusica();
			break;
		default:
			System.out.println("Comando inválido");
			Start();

		}

	}
	
	public static void Radio() {
		System.out.println("Oque deseja fazer agora ?\n1-Criar Radio\n2-Remover Radio\n3-Tocar Radio");
		String x = in.nextLine();
		switch (x.charAt(0)) {
		case '1':
			tocarRadio();
			break;
		case '2':
			removerRadio();
			break;
		case '3':
			criarRadio();
			break;
		default:
			System.out.println("Comando inválido");
			Start();

		}
	}
}

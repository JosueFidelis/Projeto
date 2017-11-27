import ISpotifai.Spotify;

import java.util.Scanner;

import Exceptions.AJCException;
import Exceptions.ANEException;
import Exceptions.ErouException;
import Exceptions.PlaylistNaoEncontradaException;
import Exceptions.ComandoInvalidoException;
public class Main {
	static Spotify spotify = new Spotify(true);
	public static Scanner in = new Scanner(System.in); 
	public static void main(String[] args) {
		Start();

	}
	public static void Start()
	{
		System.out.println("Oque deseja fazer agora ?\n1-Gerenciar Playlists\n2-Gerenciar Contas\n3-Gerenciar Artistas");
		String x = in.nextLine();
		switch(x.charAt(0))
		{
		case '1':
			Playlists();
			break;
		case '2':
			Contas();
			break;
		case '3':
			Artistas();
			break;
		default:
			System.out.println("Comando inválido");
			Start();
				
		}
	}
	public static void CriarPlaylist() 
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
	public static void RemoverPlaylist()
	{
		System.out.println("Digite o nome da playlist que quer remover");
		String name = in.nextLine();
		try{spotify.removerPlaylist(name);}
		catch(PlaylistNaoEncontradaException e){
			System.out.println(e.getMessage());
		}
		Start();
	}
	public static void BuscarPlaylist()
	{
		System.out.println("Digite o nome da playlist que quer buscar");
		String name = in.nextLine();
		try{System.out.println(spotify.buscarPlaylist(name).listar());}
		catch(PlaylistNaoEncontradaException e){
			System.out.println(e.getMessage());
		}
		Start();
	}
	
	public static void CriarArtista(){
		System.out.println("Qual nome do artista que deseja inserir?");
		String name = in.nextLine();
		System.out.println("Qual nome dos albuns do artista que deseja inserir?");
		String albuns = in.nextLine();
		System.out.println("Qual o numero de fãs do artista que deseja inserir?");
		String f = in.nextLine();
		try{spotify.criarArtista(name, albuns, f);
		}catch(AJCException e) {
			System.out.println(e.getMessage());
		}
		Start();
		
	}
	public static void RemoverArtista() {
		System.out.println("Qual nome do artista que deseja remover?");
		String name = in.nextLine();
		try {spotify.removerArtista(name);
		}catch(ANEException e)
		{
			System.out.println(e.getMessage());
		}
		Start();
	}
	public static void buscarArtista() {
		System.out.println("Qual nome do artista que deseja buscar?");
		String name = in.nextLine();
		try {System.out.println(spotify.buscarArtista(name));
		}catch(ANEException e)
		{
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
		try{spotify.atualizarArtista(name, albuns, f);
		}catch(ANEException e) {
			System.out.println(e.getMessage());
		}
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
		try {System.out.println(spotify.removerConta(login));
		}catch(ErouException e) {
			System.out.println(e.getMessage());
		}
		Start();
	}
	public static void procurarConta() {
		System.out.println("Digite o nome da conta que deseja procurar");
		String login = in.nextLine();
		try {System.out.println(spotify.procurarConta(login));
		}catch(ErouException e) {
			System.out.println(e.getMessage());
		}
		Start();
	}
	public static void seguirAlguem() {

		System.out.println("Digite o nome da sua conta e da conta que voce deseja seguir");
		String login1 = in.nextLine();
		String login2 = in.nextLine();
		try {System.out.println(spotify.seguir(login1, login2));
		}catch(ErouException e) {
			System.out.println(e.getMessage());
		}catch(ComandoInvalidoException d) {
			System.out.println(d.getMessage());
		}
		Start();
	}
	public static void deixarDeSeguirAlguem() {
		System.out.println("Digite o nome da sua conta e da conta que deseja deixar de seguir");
		String login1 = in.nextLine();
		String login2 = in.nextLine();
		try {spotify.deixarDeSeguir(login1, login2);
		}catch (ErouException e) {
			System.out.println(e.getMessage());
		}catch (ComandoInvalidoException d) {
			System.out.println(d.getMessage());
		}
		Start();
	}
	public static void trocarPlano() {
		System.out.println("Digite o nome do sua conta");
		String login = in.nextLine();
		try{System.out.println(spotify.trocarPlano(login));
		}catch (ErouException e) {
			System.out.println(e.getMessage());
		}
		Start();
	}
	public static void cheat() {
		System.out.println("Digite o nome da sua conta e o comando secreto");
		String login = in.nextLine();
		String comando = in.nextLine();
		try {spotify.cheatDePlano1(login, comando);
		}catch(ErouException e) {
			System.out.println(e.getMessage());
		}catch(ComandoInvalidoException d) {
			System.out.println(d.getMessage());
			Start();
		}
		
		System.out.println("Digite o segundo comando secreto");
		comando = in.nextLine();
		try {spotify.cheatDePlano2(login, comando);
		}catch(ErouException e) {
			System.out.println(e.getMessage());
		}catch(ComandoInvalidoException d) {
			System.out.println(d.getMessage());
			Start();
		}
		
		System.out.println("Digite o terceiro comando secreto");
		comando = in.nextLine();
		try {spotify.cheatDePlano3(login, comando);
		}catch(ErouException e) {
			System.out.println(e.getMessage());
		}catch(ComandoInvalidoException d) {
			System.out.println(d.getMessage());
			Start();
		}
		
		System.out.println("Digite o quarto comando secreto");
		comando = in.nextLine();
		try {spotify.cheatDePlano3(login, comando);
		}catch(ErouException e) {
			System.out.println(e.getMessage());
		}catch(ComandoInvalidoException d) {
			System.out.println(d.getMessage());
			Start();
		}
		
		System.out.println("Digite o quinto comando secreto");
		comando = in.nextLine();
		try {spotify.cheatDePlano3(login, comando);
		}catch(ErouException e) {
			System.out.println(e.getMessage());
		}catch(ComandoInvalidoException d) {
			System.out.println(d.getMessage());
			Start();
		}
		
		try {spotify.promover(login, "5 estrelas");
			
		}catch(ErouException e) {
			System.out.println(e.getMessage());
		}catch(ComandoInvalidoException d) {
			System.out.println(d.getMessage());
		}
		Start();
		
	}
	
	
	
	
	public static void Playlists() {
		System.out.println("Oque deseja fazer agora ?\n1-Criar Playlists\n2-Remover Playlist\n3-Buscar Playlist");
		String x = in.nextLine();
		switch(x.charAt(0))
		{
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
		
	}
	public static void Artistas() {
		System.out.println("Oque deseja fazer agora ?\n1-Inserir Artista\n2-Remover Artista\n3-Buscar Artista\n4-Atualizar Artista");
		String x = in.nextLine();
		switch(x.charAt(0))
		{
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

}

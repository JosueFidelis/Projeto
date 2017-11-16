
public abstract class Playlist {
	private String nome;
	public Playlist(String nome)
	{
		this.nome = nome;
	}
	public abstract String adicionar(Musica musica);
	public abstract String remover(String musica) throws MusicaNaoEncontradaException;
	public String getNome()
	{
		return this.nome;
	}
}

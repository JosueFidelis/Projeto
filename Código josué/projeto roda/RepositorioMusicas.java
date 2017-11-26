public interface RepositorioMusicas {
	public void inserir(Musica musica);

	public void remover(Musica musica);

	public void tocar(Musica musica);

	public void buscar(Musica musica);

	public RepositorioMusicaLista getNext();

	public RepositorioMusicaLista josue(String genero, RepositorioMusicas albiderg);
}
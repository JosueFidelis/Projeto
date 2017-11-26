public interface RepositorioRadio {
		public void inserir (Radio radio);
		public Radio buscar (String genero) throws RadioNaoEncontradaException;
		public void remover (String genero);
		public void update (String genero);
}

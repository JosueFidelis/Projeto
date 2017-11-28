package repositorio;
import Exceptions.*;
import Radio.Radio;

public interface RepositorioRadio {
		public void inserir (Radio radio);
		public Radio buscar (String genero) throws RadioNaoEncontradaException;
		public void remover (String genero) throws RadioNaoEncontradaException;
		public String tocarRadio (String genero) throws NaoHaMusicasException, RadioNaoEncontradaException;
}

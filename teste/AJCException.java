
public class AJCException extends Exception{
public AJCException(String artista) {
	super("Artista "+ artista +" já cadastrado.");
}
}

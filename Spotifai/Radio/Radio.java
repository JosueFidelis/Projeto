package Radio;
import Exceptions.*;

public class Radio {
	private String genero;
	private ListaMusicaRadio radio;
	public ListaMusicaRadio getRadio () {
		return radio;
	}
	public Radio (String genero, int i) {
		this.genero = genero;
		this.radio = new ListaMusicaRadio(genero, i);
	}
	public String tocar () throws NaoHaMusicasException {
		return radio.tocar();
	}
	public void setRadio (ListaMusicaRadio radio) {
		this.radio = radio;
	}
	public void setGenero (String genero) {
		this.genero = genero;
	}
	public ListaMusicaRadio getNext() {
		return radio.getNext();
	}
}

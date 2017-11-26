public class Radio {
	private String genero;
	private ListaRadio radio;
	public ListaRadio getRadio () {
		return radio;
	}
	public Radio (String genero, int i) {
		this.genero = genero;
		this.radio = new ListaRadio(genero, i);
	}
	public String tocar () {
		return radio.tocar();
	}
	public ListaRadio getNext() {
		return radio.getNext();
	}
}

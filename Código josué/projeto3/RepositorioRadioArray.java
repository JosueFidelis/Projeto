
public class RepositorioRadioArray implements RepositorioRadio {
	private Radio [] radio;
	public RepositorioRadioArray () {
		radio = new Radio [99];
		radio [0] = null;
	}
	public void duplicar () {
		Radio [] NovoArray = new Radio [2 * this.radio.length];  
		for (int i = 0; i < 2 * radio.length; i ++) {
			NovoArray [i] = this.radio [i];
		}
	}
	public void trocar (int i) {
		for (; i < this.radio.length - 1; i ++) {
			this.radio[i] = this.radio [i + 1];
		}
	}
	public void inserir (Radio radio) {
		int o = 0;
		for (int i = 0; i < this.radio.length; i ++) {
			if (this.radio [i] == null) {
				this.radio[i] = radio;
				o = i;
			}
		}
		if (o >= this.radio.length - 2) {
			duplicar();
		}
	}
	public void remover (String str) {
		for (int i = 0; i < this.radio.length; i ++) {
			if (radio[i].getGenero().equals(str)) {
				trocar(i);
			}
		}
	}
	public Radio buscar (String genero) {
		for (int i = 0; )
	}
}

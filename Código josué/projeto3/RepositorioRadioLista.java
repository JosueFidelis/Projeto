
public class RepositorioRadioLista implements RepositorioRadio {
		private Radio radio;
		private RepositorioRadioLista next;
		public RepositorioRadioLista () {
			this.radio = null;
			this.next = null;
		}
		public void inserir (Radio radio1) {
			if (this.radio == null) {
				this.radio = radio1;
				this.next = new RepositorioRadioLista ();
			} else {
				this.next.inserir(radio1);
			}
		}
		public Radio buscar (String genero) {
			if (this.radio.equalsS(genero)) {
				return this.radio;
			} else {
				return this.next.buscar(genero);
			}
		}
}

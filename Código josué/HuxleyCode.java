import java.util.Scanner;
public class HuxleyCode {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		String x;
		Musica valor;
		Lista lista = new Lista();
		boolean v= true;
		while (in.hasNext() && v) {
			x = in.nextLine();
			if (x.equals("Recarga feita")) {
				v = false;
			} else {
				valor = new Musica(x);
				lista.inserir(valor);
			}
		}
		v = true;
		while (in.hasNext() && v) {
			x = in.nextLine();
			if (x.equals("Fim da simulacao")) {
				v = false;
			} else {
				valor = new Musica (x);
				x = lista.Flecha(valor);
				System.out.println(x);
			}
		}
		System.out.print("Flechas que sobraram: ");
		while (lista.isNull()) {
			System.out.printf(lista.getValor()+" ");
			lista = lista.getLista();
		}
		in.close();
	}
}
class Musica {
	private String x;
	private Genero genero;
	public Musica (String x) {
		this.x = x;
	}
	public String getValor() {
		return x;
	}
	public void setValor(String x) {
		this.x = x;
	}
	public boolean equals(Musica valor) {
		return valor.getValor().equals(this.x);
	}
}
class Lista {
	private Musica valor;
	private Lista list;
	public String getGenero () {
		return "s"
	}
	public void Lista() { 
		this.valor = null;
		this.list = null;
	}
	public String getValor() {
		return this.valor.getValor();
	}
	public Lista getLista() {
		return this.list;
	}
	public void inserir (Musica genero) {
		if (this.genero == genero) {
			this.musica = musica;
			this.list = new Lista();
		} else {
			this.list.inserir(valor);
		}
	}
	public boolean isNull () {
		if (this.valor == null) {
			return false;
		} else {
			return true;
		}
	}
	public String Flecha (Musica valor) {
		if (this.valor != null) {
			if (this.valor.equals(valor)) {
				this.valor = this.list.valor;
				this.list = this.list.list;
				return "Flecha disparada";
			} else {
				return this.list.Flecha(valor);
			}
		} else {
			return "Flecha nao encontrada";
		}
	}
}
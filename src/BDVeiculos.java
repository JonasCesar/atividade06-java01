
public class BDVeiculos {
	
	private static Passeio listaPasseio[]; 
	private static Carga listaCarga[];
	
	public BDVeiculos() {
		listaPasseio = new Passeio[5];
		listaCarga = new Carga[5];
	}

	public static Passeio[] getListaPasseio() {
		return listaPasseio;
	}

	public static Carga[] getListaCarga() {
		return listaCarga;
	}

	public static void setListaPasseio(Passeio[] listaPasseio) {
		BDVeiculos.listaPasseio = listaPasseio;
	}

	public static void setListaCarga(Carga[] listaCarga) {
		BDVeiculos.listaCarga = listaCarga;
	}
	
}

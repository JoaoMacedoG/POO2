package modelo;
import java.io.Serializable;
import java.util.ArrayList;
import interfaces.ISecao;
import interfaces.IZonaEleitoral;

public class Secao implements ISecao, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numero;
	private ZonaEleitoral zona;
	private ArrayList<Eleitor> eleitores;
	private Urna urna;
	

	public Secao(int numero, ZonaEleitoral zona) {
		this.setNumero(numero);
		this.zona = zona;
		this.eleitores = new ArrayList<Eleitor>();
		this.urna= urna;
	}

	public Urna getUrna() {
		return urna;
	}

	public void setUrna(Urna urna) {
		this.urna = urna;
	}

	public void insereEleitor(Eleitor eleitor) {
		if (!this.eleitores.contains(eleitor))
			this.eleitores.add(eleitor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Secao other = (Secao) obj;
		if (numero != other.numero)
			return false;
		if (zona == null) {
			if (other.zona != null)
				return false;
		} else if (!zona.equals(other.zona))
			return false;
		return true;
	}

	public int getNumeroSecao() {
		return numero;
	}

	public Eleitor getEleitor(int titulo) {

		for (int cont = 0; cont < this.eleitores.size(); cont++) {
			Eleitor eleitor = this.eleitores.get(cont);
			if (eleitor.getTitulo() == titulo) {
				return eleitor;
			}
		}
		return null;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public IZonaEleitoral getZona() {
		// TODO Auto-generated method stub
		return null;
	}
}

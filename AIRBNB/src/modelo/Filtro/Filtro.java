package modelo.Filtro;

import java.io.Serializable;

public class Filtro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer numeroBanheiros, numeroQuartos, numeroCamas;
	private double precoMinimo, precoMaximo;
	private String cidade;

	public Filtro(String cidade, double precoMinimo, double precoMaximo, Integer numeroBanheiros, Integer numeroQuartos,
			Integer numeroCamas) {

		this.numeroBanheiros = numeroBanheiros;
		this.numeroCamas = numeroCamas;
		this.numeroQuartos = numeroQuartos;
		this.precoMaximo = precoMaximo;
		this.precoMinimo = precoMinimo;
		this.cidade = cidade;

	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public double getPrecoMinimo() {
		return precoMinimo;
	}

	public void setPrecoMinimo(double precoMinimo) {
		this.precoMinimo = precoMinimo;
	}

	public void setPrecoMaximo(double precoMaximo) {
		this.precoMaximo = precoMaximo;
	}

	public void setPrecoMinimo(int precoMinimo) {
		this.precoMinimo = precoMinimo;
	}

	public double getPrecoMaximo() {
		return precoMaximo;
	}

	public void setPrecoMaximo(int precoMaximo) {
		this.precoMaximo = precoMaximo;
	}

	public Integer getNumeroBanheiros() {
		return numeroBanheiros;
	}

	public void setNumeroBanheiros(int numeroBanheiros) {
		this.numeroBanheiros = numeroBanheiros;
	}

	public Integer getNumeroQuartos() {
		return numeroQuartos;
	}

	public void setNumeroQuartos(int numeroQuartos) {
		this.numeroQuartos = numeroQuartos;
	}

	public Integer getNumeroCamas() {
		return numeroCamas;
	}

	public void setNumeroCamas(int numeroCamas) {
		this.numeroCamas = numeroCamas;
	}

}

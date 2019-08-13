package modelo;

import java.util.ArrayList;
import java.io.Serializable;

import interfaces.IZonaEleitoral;

public class ZonaEleitoral implements IZonaEleitoral, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numero;
	private String localizacao;
	private ArrayList<Secao> secoes;
	private int numeroSecao;

	public ZonaEleitoral(int numero, String localizacao) {
		this.setNumero(numero);
		this.setLocalizacao(localizacao);
		this.secoes = new ArrayList<Secao>();
		this.numeroSecao = 0;
	}

	public Secao criaNovaSecao() {
		this.numeroSecao++;
		Secao secao = new Secao(this.numeroSecao, this);
		this.secoes.add(secao);
		return secao;
	}

	public String getLocalizacao() {
		return this.localizacao;
	}

	public int getNumeroSecao() {
		return numeroSecao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public int getNumeroZona() {
		return this.numero;
	}

	public ArrayList<Secao> getSecoesDeUmaZona() {
		return secoes;
	}

	public int getNumeroSecoes() {
		int numeroDeSecoes = 0;
		for (int cont = 0; cont < this.secoes.size(); cont++) {
			Secao secao = this.secoes.get(cont);
			if (secao != null) {
				numeroDeSecoes++;
			}
		}

		return numeroDeSecoes;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZonaEleitoral other = (ZonaEleitoral) obj;
		if (numeroSecao != other.numeroSecao)
			return false;
		if (secoes == null) {
			if (other.secoes != null)
				return false;
		} else if (!secoes.equals(other.secoes))
			return false;
		return true;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Secao getSecao(int numeroSecao) {
		for (int cont = 0; cont < this.secoes.size(); cont++) {
			Secao secao = this.secoes.get(cont);
			if (secao.getNumeroSecao() == numeroSecao) {
				return secao;
			}
		}
		return null;
	}

}

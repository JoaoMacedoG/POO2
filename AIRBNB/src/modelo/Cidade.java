package modelo;

import java.io.Serializable;

import interfaces.ICidade;

public class Cidade implements ICidade, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeCidade;

	public Cidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (nomeCidade == null) {
			if (other.nomeCidade != null)
				return false;
		} else if (!nomeCidade.equals(other.nomeCidade))
			return false;
		return true;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}



}

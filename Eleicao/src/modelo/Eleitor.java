package modelo;

import java.io.Serializable;

public class Eleitor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cpf;
	private String nome;
	private int titulo;
	private Secao secao;
	private String endereco;
	private String municipio;
	private ZonaEleitoral zona;


	public void setZona(ZonaEleitoral zona) {
		this.zona = zona;
	}



	public int getCpf() {
		return cpf;
	}



	public void setCpf(int cpf) {
		this.cpf = cpf;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getTitulo() {
		return titulo;
	}



	public void setTitulo(int titulo) {
		this.titulo = titulo;
	}



	public ZonaEleitoral getZona() {
		return zona;
	}



	public Eleitor(int cpf, String nome, int titulo ){
		this.cpf = cpf;
		this.nome =  nome;
		this.titulo = titulo;

	}

	public Secao getSecao() {
		return secao;
	}
	public void setSecao(Secao secao){
		this.secao = secao;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco){
		this.endereco = endereco;

	}

	public String getMunicipio() {
		return municipio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + titulo;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eleitor other = (Eleitor) obj;
		if (titulo != other.titulo)
			return false;
		return true;
	}



	public void setMunicipio(String municipio){
		this.municipio =  municipio;
	}

}

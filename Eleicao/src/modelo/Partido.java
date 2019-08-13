package modelo;

import java.util.ArrayList;
import java.io.Serializable;

public class Partido implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sigla;
	private String nomeDoPartido;
	private Candidato prefeito;
	private ArrayList<Candidato> candidatosVereadores;
	

	public Partido( String sigla, String nomeDoPartido){
		this.sigla = sigla;
		this.nomeDoPartido =  nomeDoPartido;
		this.candidatosVereadores =  new ArrayList<Candidato>();
		this.prefeito = prefeito;
		
		
	}
	
	public void insereVereadores(Candidato candidato){
		if(!this.candidatosVereadores.contains(candidato))
				this.candidatosVereadores.add(candidato);
	}
	
	public Candidato getVereador(int numeroParaVotar){
		for(int cont=0; cont<this.candidatosVereadores.size(); cont++){
			Candidato candidatoVereador = this.candidatosVereadores.get(cont);
			if(candidatoVereador.getNumeroCandidatoAserVotado() == numeroParaVotar){
				return candidatoVereador;
		
			}
	}
		return null;
}

	
	public int numeroCandidatosVereadores(){
		return this.candidatosVereadores.size();
	}
	public Candidato getPrefeito() {
		return prefeito;
	}

	public void setPrefeito(Candidato prefeito) {
		this.prefeito = prefeito;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNomeDoPartido() {
		return nomeDoPartido;
	}

	public void setNomeDoPartido(String nomeDoPartido) {
		this.nomeDoPartido = nomeDoPartido;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		if (candidatosVereadores == null) {
			if (other.candidatosVereadores != null)
				return false;
		} else if (!candidatosVereadores.equals(other.candidatosVereadores))
			return false;
		if (nomeDoPartido == null) {
			if (other.nomeDoPartido != null)
				return false;
		} else if (!nomeDoPartido.equals(other.nomeDoPartido))
			return false;
		if (prefeito == null) {
			if (other.prefeito != null)
				return false;
		} else if (!prefeito.equals(other.prefeito))
			return false;
		return true;
	}
}
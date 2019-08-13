package modelo;
import java.io.Serializable;
public class Candidato implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Partido partido;
	private Eleitor eleitor;
	private int numeroCandidatoAserVotado;
	private int numeroDeVotosGanhos;
	
	
	public void setNumeroDeVotosGanhos(int numeroDeVotosGanhos) {
		this.numeroDeVotosGanhos = numeroDeVotosGanhos;
	}


	public Candidato(Eleitor eleitor, Partido partido, int numeroParaVotar){
		this.numeroCandidatoAserVotado = numeroParaVotar;
		this.eleitor =  eleitor;
		this.partido =  partido;
		this.numeroDeVotosGanhos = 0;
	}


	public int getNumeroDeVotosGanhos() {
		return numeroDeVotosGanhos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partido == null) ? 0 : partido.hashCode());
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
		Candidato other = (Candidato) obj;
		if (partido == null) {
			if (other.partido != null)
				return false;
		} else if (!partido.equals(other.partido))
			return false;
		return true;
	}


	public Partido getPartido() {
		return partido;
	}
	
	public void canditadoGanhouVoto(){
		numeroDeVotosGanhos++;
	}


	public void setPartido(Partido partido) {
		this.partido = partido;
	}


	public int getNumeroCandidatoAserVotado() {
		return numeroCandidatoAserVotado;
	}


	public void setNumeroCandidatoAserVotado(int numeroCandidatoAserVotado) {
		this.numeroCandidatoAserVotado = numeroCandidatoAserVotado;
	}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return ""+numeroCandidatoAserVotado;
}
}

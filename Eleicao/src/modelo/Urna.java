package modelo;

import java.util.ArrayList;

import excecoes.ExcecaoEleicaoAberta;
import excecoes.ExcecaoEleicaoFechada;
import excecoes.ExcecaoEleitorJaVotou;
import interfaces.EstadoEleicao;
import java.io.Serializable;
public class Urna implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int totalVotos;
	private Secao secao;
	private ZonaEleitoral zona;
	private Partido partido;
	private ArrayList<Eleitor> eleitoresQueJaVotaram;
	private EstadoEleicao estado;
	
	
	
	public Urna (ZonaEleitoral zona, Secao secao){
		this.secao= secao;
		this.zona= zona;
		this.totalVotos= 0;
		this.estado =  new UrnaCadastrada(this);
	}
	
	public EstadoEleicao getEstado() {
		return estado;
	}
	public void abreUrna() throws ExcecaoEleicaoAberta{
		this.estado.abreEleicaoUrna();
	}
	
	public void fechaUrna() throws ExcecaoEleicaoFechada  {
		this.estado.urnaFechada();
	}

	public void setEstado(EstadoEleicao estado) {
		this.estado = estado;
	}

	public void aumentaTotalVotos(){
	
		this.totalVotos++;
	}
	
	public Partido getPartido() {
		return partido;
	}

	public void setTotalVotos(int totalVotos) {
		this.totalVotos = totalVotos;
	}

	public int getTotalVotos() {
		return totalVotos;
	}
	public Secao getSecao() {
		return this.secao;
	}
	public ZonaEleitoral getZona() {
		return this.zona;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Urna other = (Urna) obj;
		if (secao == null) {
			if (other.secao != null)
				return false;
		} else if (!secao.equals(other.secao))
			return false;
		if (zona == null) {
			if (other.zona != null)
				return false;
		} else if (!zona.equals(other.zona))
			return false;
		return true;
	}

}

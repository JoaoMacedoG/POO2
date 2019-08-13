package modelo;

import java.io.Serializable;

import excecoes.ImovelNaoExiste;
import interfaces.IImovel;

public abstract class Imovel implements IImovel, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer notaDoImovel;
	private Integer numeroBanheiros;
	private Integer numeroQuartos;
	private Integer numeroCamas;
	private double preco;
	private String nomeImovel;
	private Cidade cidade;
	private Integer numeroAvaliacoes;
	private Integer notaTotal;
	

	public Imovel(Cidade cidade, String nomeImovel, Integer numeroDeBanheiros, Integer numeroCamas,
			Integer numeroQuartos, double preco, Integer numeroAvaliacoes,Integer notaDoImovel) {
		this.numeroBanheiros = numeroDeBanheiros;
		this.numeroCamas = numeroCamas;
		this.numeroQuartos = numeroQuartos;
		this.preco = preco;
		this.nomeImovel = nomeImovel;
		this.cidade = cidade;
		this.numeroAvaliacoes = numeroAvaliacoes;
		this.notaDoImovel =  0;
		this.setNotaTotal(0);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imovel other = (Imovel) obj;
		if (nomeImovel == null) {
			if (other.nomeImovel != null)
				return false;
		} else if (!nomeImovel.equals(other.nomeImovel))
			return false;
		return true;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public Integer getNumeroAvaliacoes() {
		return numeroAvaliacoes;
	}

	public void setNumeroAvaliacoes(Integer numeroAvaliacoes) {
		this.numeroAvaliacoes = numeroAvaliacoes;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getNomeImovel() {
		return nomeImovel;
	}

	public void setNomeImovel(String nomeImovel) {
		this.nomeImovel = nomeImovel;
	}

	public Integer getNotaDoImovel() {
		return notaDoImovel;
	}

	public void setNotaDoImovel(Integer notaDoImovel) {
		this.notaDoImovel = notaDoImovel;
	}

	public Integer getNumeroBanheiros() {
		return numeroBanheiros;
	}

	public void setNumeroBanheiros(Integer numeroBanheiros) {
		this.numeroBanheiros = numeroBanheiros;
	}

	public Integer getNumeroQuartos() {
		return numeroQuartos;
	}

	public void setNumeroQuartos(Integer numeroQuartos) {
		this.numeroQuartos = numeroQuartos;
	}

	public Integer getNumeroCamas() {
		return numeroCamas;
	}

	public void setNumeroCamas(Integer numeroCamas) {
		this.numeroCamas = numeroCamas;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	private void aumentaAvaliacoesImovel() {
		Integer avaliacoes = getNumeroAvaliacoes() + 1;
		setNumeroAvaliacoes(avaliacoes);
	}

	@Override
	public void avaliarImovel( Integer avaliar) throws ImovelNaoExiste {
		notaTotal = notaTotal + avaliar;
		Integer notaTemporaria = notaTotal;
		aumentaAvaliacoesImovel();
		Integer media = notaTemporaria / (getNumeroAvaliacoes());
		setNotaDoImovel(media);
	}

	public Integer getNotaTotal() {
		return notaTotal;
	}

	public void setNotaTotal(Integer notaTotal) {
		this.notaTotal = notaTotal;
	}

}

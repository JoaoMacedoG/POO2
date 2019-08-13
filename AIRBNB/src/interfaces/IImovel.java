package interfaces;

import excecoes.ImovelNaoExiste;
import modelo.Cidade;

public interface IImovel {
	public Cidade getCidade();
	public void setNumeroAvaliacoes(Integer numeroAvaliacoes);
	public Integer getNumeroAvaliacoes();
	public void setCidade(Cidade cidade);
	public String getNomeImovel();
	public void setNomeImovel(String nomeImovel);
	public Integer getNotaDoImovel();
	public void setNotaDoImovel(Integer notaDoImovel);
	public Integer getNumeroBanheiros();
	public void setNumeroBanheiros(Integer numeroBanheiros);
	public Integer getNumeroQuartos();
	public void setNumeroQuartos(Integer numeroQuartos);
	public Integer getNumeroCamas();
	public void setNumeroCamas(Integer numeroCamas);
	public double getPreco();
	public void setPreco(double preco);
	void avaliarImovel( Integer avaliar) throws ImovelNaoExiste;
}

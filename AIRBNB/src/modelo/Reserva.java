package modelo;

import java.io.Serializable;
import java.util.Random;

public class Reserva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer dataDeInicio, dataDeSaida, mes, idReserva;
	private Cidade cidade;
	private Pessoa pessoa;
	private Imovel imovelEscolhido;

	public Reserva(Integer dataDeInicio, Integer dataDeSaida, Integer mes, Imovel imovelEscolhido, Cidade cidade,
			Pessoa pessoa) {
		this.pessoa = pessoa;
		this.dataDeInicio = dataDeInicio;
		this.dataDeSaida = dataDeSaida;
		this.imovelEscolhido = imovelEscolhido;
		this.cidade = cidade;
		this.mes = mes;
		this.idReserva = randomId();

	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public Integer getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(Integer dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public Integer getDataDeSaida() {
		return dataDeSaida;
	}

	public void setDataDeSaida(Integer dataDeSaida) {
		this.dataDeSaida = dataDeSaida;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Imovel getImovelEscolhido() {
		return imovelEscolhido;
	}

	public void setImovelEscolhido(Imovel imovelEscolhido) {
		this.imovelEscolhido = imovelEscolhido;
	}

	public Integer randomId() {
		Random r = new Random();
		return r.nextInt(1000);
	}

}

package modelo;

import excecoes.ExcecaoEleicaoAberta;
import java.io.Serializable;
import excecoes.ExcecaoEleicaoFechada;
import excecoes.ExcecaoUrnaCadastrada;
import interfaces.EstadoEleicao;

public class UrnaCadastrada implements EstadoEleicao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Urna urna;

	public UrnaCadastrada(Urna urna) {
		this.urna= urna;
	}
	@Override
	public void abreEleicaoUrna() {
		urna.setEstado(new EleicaoAberta(urna));
	}
	@Override
	public void urnaCadastrada() throws ExcecaoUrnaCadastrada {
		throw new ExcecaoUrnaCadastrada();

	}
	@Override
	public void urnaFechada() throws ExcecaoEleicaoFechada{
		throw new ExcecaoEleicaoFechada();
	}



	
}

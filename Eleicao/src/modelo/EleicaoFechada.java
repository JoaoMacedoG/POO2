package modelo;

import java.io.Serializable;

import excecoes.ExcecaoEleicaoAberta;
import excecoes.ExcecaoEleicaoFechada;
import excecoes.ExcecaoUrnaCadastrada;
import interfaces.EstadoEleicao;

public class EleicaoFechada implements EstadoEleicao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Urna urna;
	
	public EleicaoFechada(Urna urna){
		this.urna =  urna;
	}
	
	@Override
	public void abreEleicaoUrna() throws ExcecaoEleicaoAberta {
		throw new ExcecaoEleicaoAberta();
	}
	@Override
	public void urnaCadastrada()  {
		urna.setEstado(new UrnaCadastrada(urna));

	}
	@Override
	public void urnaFechada() throws ExcecaoEleicaoFechada{
		throw new ExcecaoEleicaoFechada();
	}


}



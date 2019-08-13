package modelo;

import excecoes.ExcecaoEleicaoAberta;
import excecoes.ExcecaoEleicaoFechada;
import excecoes.ExcecaoUrnaCadastrada;
import interfaces.EstadoEleicao;
import java.io.Serializable;

	public class EleicaoAberta implements EstadoEleicao, Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Urna urna;
		
		public EleicaoAberta(Urna urna){
			this.urna =  urna;
		}
		
		@Override
		public void abreEleicaoUrna() throws ExcecaoEleicaoAberta {
			throw new ExcecaoEleicaoAberta();
		}
		@Override
		public void urnaCadastrada() throws ExcecaoUrnaCadastrada {
			throw new ExcecaoUrnaCadastrada();

		}
		@Override
		public void urnaFechada() throws ExcecaoEleicaoFechada{
			urna.setEstado(new EleicaoFechada(urna));
		}

	
	}



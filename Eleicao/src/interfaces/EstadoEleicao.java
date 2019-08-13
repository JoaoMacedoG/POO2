package interfaces;

import excecoes.ExcecaoEleicaoAberta;
import excecoes.ExcecaoEleicaoFechada;

public interface EstadoEleicao  {

	
		public void urnaFechada() throws ExcecaoEleicaoFechada;

		public void urnaCadastrada() throws excecoes.ExcecaoUrnaCadastrada;

		public void abreEleicaoUrna() throws ExcecaoEleicaoAberta;
		
	}



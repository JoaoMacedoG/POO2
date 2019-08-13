package testes;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import excecoes.ExcecaoEleitorExistente;
import excecoes.ExcecaoPartidoExistente;
import excecoes.ExcecaoPrefeitoExistente;
import excecoes.ExcecaoVereadorExistente;
import excecoes.ExcecaoZonaEleitoralExistente;
import excecoes.ExcecaoZonaNaoExistente;
import modelo.FachadaCartorioEleitoral;
import modelo.Secao;

public class TestePartidos {
private FachadaCartorioEleitoral cartorio;
private Secao secao;
	
	@Before
	public void configurar(){
		cartorio = new FachadaCartorioEleitoral();
		
		
	}
	
	@Test
	public void cadastroDePartido() throws  ExcecaoPartidoExistente  {
		try{
		
			
			cartorio.cadastraPartido("ab", "abc");
			cartorio.getPartido("abc");
			assertEquals (1,cartorio.numeroDePartidos());
			
			
		}
		catch(ExcecaoPartidoExistente excecao){
			
			}
	}
	
	

}





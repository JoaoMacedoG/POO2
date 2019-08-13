package testes;
import org.junit.*;

import excecoes.ExcecaoZonaEleitoralExistente;
import excecoes.ExcecaoZonaNaoExistente;

import static org.junit.Assert.*;
import modelo.FachadaCartorioEleitoral;
import modelo.Secao;
import modelo.ZonaEleitoral;


public class TesteSecaoEleitoral {
	
	private FachadaCartorioEleitoral cartorio;
	
	@Before
	public void configurar(){
		cartorio = new FachadaCartorioEleitoral();
		
	}
	
	@Test
	public void cadastroDeSecaoEleitoral() throws ExcecaoZonaEleitoralExistente {
		try{
		
		cartorio.cadastraZonaEleitoral(101, "Estreito");
		assertEquals (1,cartorio.numeroDeZonasEleitorais());
		
		cartorio.cadastraSecaoEleitoral(101);
		assertEquals (1,cartorio.numeroDeSecoesEleitorais());
		}
		
		catch(ExcecaoZonaNaoExistente excecao){
			assertEquals (1, cartorio.numeroDeSecoesEleitorais());
			
		
	}
	}
	
	

}

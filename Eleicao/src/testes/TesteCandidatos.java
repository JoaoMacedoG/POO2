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
import modelo.Partido;
import modelo.Secao;
import modelo.ZonaEleitoral;

public class TesteCandidatos {
private FachadaCartorioEleitoral cartorio;
private Secao secao;
private Partido partido;
	
	@Before
	public void configurar(){
		cartorio = new FachadaCartorioEleitoral();
		
		
	}
	
	@Test
	public void cadastroDeVereador() throws ExcecaoVereadorExistente, ExcecaoZonaEleitoralExistente, ExcecaoZonaNaoExistente, ExcecaoEleitorExistente, ExcecaoPartidoExistente  {
		try{
		
			cartorio.cadastraZonaEleitoral(7, "sao");
			cartorio.cadastraSecaoEleitoral(7);				
			cartorio.cadastraEleitor( "Joao",123,456,7,1,"Sao Jose","Bela Vista");
			secao = new Secao(1,(ZonaEleitoral) cartorio.getZona(7));
			partido = new Partido("ab", "abc");
			cartorio.cadastraCandidatoVereador(secao.getEleitor(456), partido, 1);
			assertEquals (cartorio.getVereador(1, partido),partido.getVereador(1));
			
		}
		catch(ExcecaoVereadorExistente excecao){
			
			
		
	}
	}
	
	
	@Test
	public void cadastroDePrefeito() throws  ExcecaoZonaEleitoralExistente, ExcecaoZonaNaoExistente, ExcecaoEleitorExistente, ExcecaoPartidoExistente  {
		try{
		
			cartorio.cadastraZonaEleitoral(7, "sao");
			cartorio.cadastraSecaoEleitoral(7);				
			cartorio.cadastraEleitor( "Joao",123,456,7,1,"Sao Jose","Bela Vista");
			secao = new Secao(1,(ZonaEleitoral) cartorio.getZona(7));
			partido = new Partido("ab", "abc");
			cartorio.cadastraPrefeito(secao.getEleitor(456), partido, 1);
			partido.getPrefeito();
			
		}
		catch(ExcecaoPrefeitoExistente excecao){
			
			
		
	}
	}
	

}




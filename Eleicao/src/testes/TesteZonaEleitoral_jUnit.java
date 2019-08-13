package testes;

import org.junit.*;


import excecoes.ExcecaoZonaEleitoralExistente;

import static org.junit.Assert.*;


import modelo.FachadaCartorioEleitoral;
import modelo.ZonaEleitoral;



public class TesteZonaEleitoral_jUnit {

	private FachadaCartorioEleitoral cartorio;
	
	@Before
	public void configurar(){
		cartorio = new FachadaCartorioEleitoral();
	}
	
	
	@Test
	public void cadastraZona101DuasVezes() {
		try{
		
		cartorio.cadastraZonaEleitoral(101, "Estreito");
		assertEquals (1,cartorio.numeroDeZonasEleitorais());
		
		cartorio.cadastraZonaEleitoral(101, "Estreito");
		
		fail();
		}
		
		catch(ExcecaoZonaEleitoralExistente excecao){
			assertEquals (1, cartorio.numeroDeZonasEleitorais());
		
		
	}
	}

	/**@Test
	public void cadastraZona101e102() {
		
		
		cartorio.cadastraZonaEleitoral(101, "Estreito");
		cartorio.cadastraZonaEleitoral(102, "Centro");
		assertEquals (2,cartorio.numeroDeZonasEleitorais());
		ZonaEleitoral zona = cartorio.getZona(101);
		assertEquals (101, zona.getNumero());
		
		ZonaEleitoral zona102 = cartorio.getZona(102);
		assertEquals (102, zona102.getNumero());
	}

**/
	
		
		
	}
		



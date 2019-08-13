package testes;

	import org.junit.*;

import excecoes.ExcecaoEleitorExistente;
import excecoes.ExcecaoZonaEleitoralExistente;
import excecoes.ExcecaoZonaNaoExistente;

import static org.junit.Assert.*;


	import modelo.FachadaCartorioEleitoral;
	import modelo.ZonaEleitoral;



	 public class TesteEleitores  {

		private FachadaCartorioEleitoral cartorio;
		
		@Before
		public void configurar(){
			cartorio = new FachadaCartorioEleitoral();
		}
		
		
		@Test
		public void cadastraEleitor() throws ExcecaoZonaEleitoralExistente, ExcecaoZonaNaoExistente {
			try{
			
			cartorio.cadastraZonaEleitoral(7, "sao");
			cartorio.cadastraSecaoEleitoral(7);
				
			cartorio.cadastraEleitor( "Joao",123,456,7,1,"Sao Jose","Bela Vista");
			assertEquals (1,cartorio.numeroDeEleitores());
			
			
			
			
			}
			catch(ExcecaoEleitorExistente excecao){
				
			}
		}
			
			@Test
			public void cadastraEleitorEmZonaInexistente() throws ExcecaoZonaEleitoralExistente, ExcecaoZonaNaoExistente {
				try{
					cartorio.cadastraEleitor( "Joao",123,456,7,1,"Sao Jose","Bela Vista");
					fail();		
				}	
				catch(Exception excecao){
					assertEquals (0,cartorio.numeroDeEleitores());	
			}
		}
			
			
			@Test
			public void cadastraMesmoEleitor2vezes() throws ExcecaoZonaEleitoralExistente, ExcecaoZonaNaoExistente {
				try{
				
				cartorio.cadastraZonaEleitoral(7, "sao");
				cartorio.cadastraSecaoEleitoral(7);
					
				cartorio.cadastraEleitor( "Joao",123,456,7,1,"Sao Jose","Bela Vista");
				assertEquals (1,cartorio.numeroDeEleitores());	
				
				cartorio.cadastraEleitor( "Joao",123,456,7,1,"Sao Jose","Bela Vista");
				fail();
				
				
				
				}
				catch(ExcecaoEleitorExistente excecao){
					assertEquals (1,cartorio.numeroDeEleitores());	
				}
			}
	
		
			@Test
			public void cadastraMaisEleitores() throws ExcecaoZonaEleitoralExistente, ExcecaoZonaNaoExistente {
				try{
				
				cartorio.cadastraZonaEleitoral(7, "sao");
				cartorio.cadastraSecaoEleitoral(7);
					
				cartorio.cadastraEleitor( "Joao",123,456,7,1,"Sao Jose","Bela Vista");
				cartorio.cadastraEleitor( "vitor",123,456,7,1,"Sao Jose","Bela Vista");	
				cartorio.cadastraEleitor( "macedo",123,456,7,1,"Sao Jose","Bela Vista");
				assertEquals (3,cartorio.numeroDeEleitores());	
				
				
				
				}
				catch(ExcecaoEleitorExistente excecao){
					assertEquals (1,cartorio.numeroDeEleitores());	
				}
			}
	
			
		}
			






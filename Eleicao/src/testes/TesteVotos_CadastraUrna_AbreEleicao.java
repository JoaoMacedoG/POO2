/**
 * 
 */
package testes;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import excecoes.ExcecaoEleicaoAberta;
import excecoes.ExcecaoEleicaoFechada;
import excecoes.ExcecaoEleitorExistente;
import excecoes.ExcecaoEleitorJaVotou;
import excecoes.ExcecaoPartidoExistente;
import excecoes.ExcecaoPrefeitoExistente;
import excecoes.ExcecaoUrnaExistente;
import excecoes.ExcecaoVereadorExistente;
import excecoes.ExcecaoZonaEleitoralExistente;
import excecoes.ExcecaoZonaNaoExistente;
import modelo.FachadaCartorioEleitoral;
import modelo.Partido;
import modelo.Secao;
import modelo.Urna;
import modelo.ZonaEleitoral;


public class TesteVotos_CadastraUrna_AbreEleicao {
	private FachadaCartorioEleitoral cartorio;
	private Secao secao;
	private Partido partido;
	private ZonaEleitoral zona;
	private Urna urna;
	
	@Before
	public void configurar(){
		cartorio = new FachadaCartorioEleitoral();
		
	}
	@Test
	public void votacao() throws ExcecaoZonaEleitoralExistente, ExcecaoZonaNaoExistente, ExcecaoEleitorExistente, ExcecaoPartidoExistente, ExcecaoPrefeitoExistente, ExcecaoUrnaExistente, ExcecaoEleitorJaVotou, ExcecaoEleicaoFechada, ExcecaoEleicaoAberta {
		
		cartorio.cadastraZonaEleitoral(7, "sao");
		cartorio.cadastraSecaoEleitoral(7);
	    cartorio.cadastraEleitor( "Joao",123,456,7,1,"Sao Jose","Bela Vista");
	    cartorio.cadastraPartido("ab", "abc");
		cartorio.cadastraPrefeito(cartorio.getEleitor(456), cartorio.getPartido("abc"), 1);
		cartorio.cadastrarUrna(cartorio.getZonas().get(0).getNumeroZona(), cartorio.getSecoes().get(0).getNumeroSecao());
		cartorio.abreEleicao();
		cartorio.insereVotoPrefeito(cartorio.getPartido("abc").getPrefeito(),  cartorio.getEleitor(456), cartorio.getPartido("abc"), 
		cartorio.getUrna(cartorio.getZonas().get(0).getNumeroZona(), cartorio.getSecoes().get(0).getNumeroSecao()), cartorio.getPartido("abc").getPrefeito().getNumeroCandidatoAserVotado());
		assertEquals(1,cartorio.getTotalVotos(cartorio.getUrna(cartorio.getZonas().get(0).getNumeroZona(), cartorio.getSecoes().get(0).getNumeroSecao())));
		assertEquals(1,cartorio.getNumeroVotosGanhosCandidato(cartorio.getPrefeito(cartorio.getPartido("abc"))));
	}
	
	@Test
	public void votaca2o() throws ExcecaoZonaEleitoralExistente, ExcecaoZonaNaoExistente, ExcecaoEleitorExistente, ExcecaoPartidoExistente, ExcecaoPrefeitoExistente, ExcecaoUrnaExistente, ExcecaoEleitorJaVotou, ExcecaoEleicaoFechada, ExcecaoEleicaoAberta {
		
		cartorio.cadastraZonaEleitoral(7, "sao");
		cartorio.cadastraSecaoEleitoral(7);
	    cartorio.cadastraEleitor( "Joao",123,456,7,1,"Sao Jose","Bela Vista");
	    cartorio.cadastraPartido("ab", "abc");
		cartorio.cadastraPrefeito(cartorio.getEleitor(456), cartorio.getPartido("abc"), 1);
		cartorio.cadastrarUrna(cartorio.getZonas().get(0).getNumeroZona(), cartorio.getSecoes().get(0).getNumeroSecao());
		cartorio.abreEleicao();
		cartorio.getEleitoresQueJaVotaram().add(cartorio.getEleitor(456));
		assertEquals(cartorio.getEleitor(456),cartorio.getEleitorJaVotouEmPrefeito(456));
	}
	
	@Test
	public void votacaoPrefeitosMaior() throws ExcecaoZonaEleitoralExistente, ExcecaoZonaNaoExistente, ExcecaoEleitorExistente, ExcecaoEleitorExistente, ExcecaoPartidoExistente, ExcecaoPrefeitoExistente, ExcecaoUrnaExistente, ExcecaoEleitorJaVotou, ExcecaoEleicaoFechada, ExcecaoEleicaoAberta{
	cartorio.cadastraZonaEleitoral(7, "sao");
	cartorio.cadastraSecaoEleitoral(7);
    cartorio.cadastraEleitor( "Joao",123,456,7,1,"Sao Jose","Bela Vista");
    cartorio.cadastraPartido("ab", "abc");
	cartorio.cadastraPrefeito(cartorio.getEleitor(456), cartorio.getPartido("abc"), 1);
	cartorio.cadastrarUrna(cartorio.getZonas().get(0).getNumeroZona(), cartorio.getSecoes().get(0).getNumeroSecao());
	cartorio.abreEleicao();
	cartorio.insereVotoPrefeito(cartorio.getPartido("abc").getPrefeito(),  cartorio.getEleitor(456), cartorio.getPartido("abc"), 
	cartorio.getUrna(cartorio.getZonas().get(0).getNumeroZona(), cartorio.getSecoes().get(0).getNumeroSecao()), cartorio.getPartido("abc").getPrefeito().getNumeroCandidatoAserVotado());
	assertEquals(1,cartorio.numeroTotalDeCandidatosPrefeitosVotados());
	assertEquals(cartorio.maiorVotoPrefeito(),cartorio.getPrefeito(cartorio.getPartido("abc")));
	
}
	
	@Test
	public void votoVereador() throws ExcecaoZonaEleitoralExistente, ExcecaoZonaNaoExistente, ExcecaoEleitorExistente, ExcecaoEleitorExistente, ExcecaoPartidoExistente, ExcecaoPrefeitoExistente, ExcecaoUrnaExistente, ExcecaoEleitorJaVotou, ExcecaoEleicaoFechada, ExcecaoEleicaoAberta, ExcecaoVereadorExistente{
	cartorio.cadastraZonaEleitoral(7, "sao");
	cartorio.cadastraSecaoEleitoral(7);
    cartorio.cadastraEleitor( "Joao",123,456,7,1,"Sao Jose","Bela Vista");
    cartorio.cadastraPartido("ab", "abc");
	cartorio.cadastraCandidatoVereador(cartorio.getEleitor(456), cartorio.getPartido("abc"), 1);
	cartorio.cadastrarUrna(cartorio.getZonas().get(0).getNumeroZona(), cartorio.getSecoes().get(0).getNumeroSecao());
	cartorio.abreEleicao();
	cartorio.insereVotoVereador(cartorio.getPartido("abc").getVereador(1),  cartorio.getEleitor(456), cartorio.getPartido("abc"), 
	cartorio.getUrna(cartorio.getZonas().get(0).getNumeroZona(), cartorio.getSecoes().get(0).getNumeroSecao()), cartorio.getPartido("abc").getVereador(1).getNumeroCandidatoAserVotado());
	assertEquals(1,cartorio.numeroTotalDeCandidatosVereadoresVotados());
	assertEquals(cartorio.maiorVotoVereador(),cartorio.getVereador(1, cartorio.getPartido("abc")));	
}
	@Test
	public void ordenaArry() throws ExcecaoZonaEleitoralExistente, ExcecaoZonaNaoExistente, ExcecaoEleitorExistente, ExcecaoEleitorExistente, ExcecaoPartidoExistente, ExcecaoPrefeitoExistente, ExcecaoUrnaExistente, ExcecaoEleitorJaVotou, ExcecaoEleicaoFechada, ExcecaoEleicaoAberta{
		cartorio.cadastraZonaEleitoral(7, "sao");
		cartorio.cadastraSecaoEleitoral(7);
	    cartorio.cadastraEleitor( "Joao",123,456,7,1,"Sao Jose","Bela Vista");
	    cartorio.cadastraEleitor( "jv",1234,4567,7,1,"Sao Jose","Bela Vista");
	    cartorio.cadastraEleitor( "j",12345,45678,7,1,"Sao Jose","Bela Vista");
	    cartorio.cadastraPartido("ab", "abc");
	    cartorio.cadastraPartido("abcd", "abcde");
		cartorio.cadastraPrefeito(cartorio.getEleitor(456), cartorio.getPartido("abc"), 1);
		cartorio.cadastraPrefeito(cartorio.getEleitor(4567), cartorio.getPartido("abcde"), 2);
		cartorio.cadastrarUrna(cartorio.getZonas().get(0).getNumeroZona(), cartorio.getSecoes().get(0).getNumeroSecao());
		cartorio.abreEleicao();
		cartorio.insereVotoPrefeito(cartorio.getPartido("abc").getPrefeito(),  cartorio.getEleitor(456), cartorio.getPartido("abc"), 
		 cartorio.getUrna(cartorio.getZonas().get(0).getNumeroZona(), cartorio.getSecoes().get(0).getNumeroSecao()), cartorio.getPartido("abc").getPrefeito().getNumeroCandidatoAserVotado());
		cartorio.insereVotoPrefeito(cartorio.getPartido("abc").getPrefeito(),  cartorio.getEleitor(45678), cartorio.getPartido("abc"), 
				 cartorio.getUrna(cartorio.getZonas().get(0).getNumeroZona(), cartorio.getSecoes().get(0).getNumeroSecao()), cartorio.getPartido("abc").getPrefeito().getNumeroCandidatoAserVotado());
		cartorio.insereVotoPrefeito(cartorio.getPartido("abcde").getPrefeito(),  cartorio.getEleitor(4567), cartorio.getPartido("abcde"), 
				 cartorio.getUrna(cartorio.getZonas().get(0).getNumeroZona(), cartorio.getSecoes().get(0).getNumeroSecao()), cartorio.getPartido("abcde").getPrefeito().getNumeroCandidatoAserVotado());
		cartorio.ordenaPorVotosPrefeito();
		//System.out.println(Arrays.toString());
	}
	
}

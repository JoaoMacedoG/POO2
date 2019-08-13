package testes;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import excecoes.ImovelNaoExiste;
import modelo.FachadaAIRBNB;

public class TesteAvaliaImovel {


	private FachadaAIRBNB projeto;

	@Before
	public void configura() throws FileNotFoundException {

		projeto = FachadaAIRBNB.getInstance() ;

	}

	@Test
	public void avaliarImovel() throws ImovelNaoExiste {

		projeto.getImovel("ap1").avaliarImovel( 10);
		
		Integer i =10;
		assertEquals(i, projeto.getImovel("ap1").getNotaDoImovel());

		
	}

}

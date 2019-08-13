package testes;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import excecoes.ExcecaoCidadeExistente;
import excecoes.ExcecaoImovelExistente;
import modelo.FachadaAIRBNB;

public class TesteCadastra {

	private FachadaAIRBNB projeto;

	@Before
	public void configura() throws FileNotFoundException {

		projeto = FachadaAIRBNB.getInstance() ;

	}

	@Test
	public void cadastraImovel() throws ExcecaoImovelExistente, ExcecaoCidadeExistente {

		projeto.cadastraCasa("aa", "a", 1, 1, 1, 1.00, "a");
		assertEquals(4, projeto.tamanhoListCidades());
		assertEquals(4, projeto.tamanhoListTodosImoveis());
	}

}

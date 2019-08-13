package testes;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import modelo.FachadaAIRBNB;

public class TesteCriador {

	private FachadaAIRBNB projeto;

	@Before
	public void configura() throws FileNotFoundException {

		projeto =  FachadaAIRBNB.getInstance() ;;

	}

	@Test
	public void test() {
		assertEquals(3, projeto.tamanhoListCidades());
		assertEquals(3, projeto.tamanhoListTodosImoveis());

	}

}

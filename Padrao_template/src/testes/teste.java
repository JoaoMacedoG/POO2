package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import modelo.Funcionario;
import modelo.FuncionarioHomem;




public class teste {
	private FuncionarioHomem homem;

	@Before
	public void configura() {
	
		
		
	}
	
	
	
	@Test
	public void test() {
		homem= new FuncionarioHomem("joao", 55, 30, 62);
		assertEquals(2.0,homem.calculaSalarioDeAposentadoria(),0.04);
		
		
		;
	}

}

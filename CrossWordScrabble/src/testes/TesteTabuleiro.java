package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelo.Letra;
import modelo.Tabuleiro;

public class TesteTabuleiro {
	
	Tabuleiro tabuleiroJogo;
	Letra letras;
	
	@Before
	public void configura(){
		tabuleiroJogo= Tabuleiro.getInstance(15, 15);
		
	}

	@Test
	public void test() {
		assertEquals(15,tabuleiroJogo.numeroLinhas());
		assertEquals(15,tabuleiroJogo.numeroColunas());
		
	}
	
	@Test
	public void testeInsereLetra(){
		Letra A = new Letra('A',2);
		tabuleiroJogo.insereLetraNoTabuleiro(1, 1, A);
		assertEquals(A,tabuleiroJogo.retornaLetra(1, 1));
	}

}

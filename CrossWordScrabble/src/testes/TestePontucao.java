package testes;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import modelo.Crossword;
import modelo.Letra;

public class TestePontucao {
	
	private Crossword jogo;
	private Letra letra;
	@Before 
	public void configura() throws FileNotFoundException{
		jogo = new Crossword();
	}

	@Test
	public void test() {
		Letra A =  new Letra('A', 7);
		Letra O = new Letra('O', 7);
	    List<Letra> letrasParaPontuar;
	    letrasParaPontuar =Arrays.asList(A,O);
	    jogo.somarPontos(letrasParaPontuar);
	    assertEquals(14,jogo.pontuacao());

	}
	@Test
	public void test2() {
		
	   System.out.println(jogo.getDicionario());

	}

}

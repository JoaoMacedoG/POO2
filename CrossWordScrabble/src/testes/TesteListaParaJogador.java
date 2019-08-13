package testes;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import modelo.Crossword;
import modelo.Letra;
import modelo.Tabuleiro;

public class TesteListaParaJogador {

	Crossword jogo;
	Letra letras;
	
	@Before
	public void configura() throws FileNotFoundException{
		jogo= new Crossword();
	}
	
	@Test
	public void test() {
		jogo.letrasDisponiveis(1);
		assertEquals(jogo.getLetrasDisponiveis(), jogo.getLetrasDisponiveis());
	
	}
	
	@Test
	public void checarSeLetraExisteNaLista(){
		Letra A =  new Letra('A', 7);
		jogo.letrasDisponiveis(1);
		jogo.checarSeLetraExisteNasLetrasDisponiveis(A);
		assertEquals(true,jogo.checarSeLetraExisteNasLetrasDisponiveis(A));
	}
	
	@Test
	public void letraDigitadaEmLista(){
		Letra A =  new Letra('A', 7);
		jogo.letrasDisponiveis(1);
		jogo.transformaPalvraDigitadaEmList("A");
	    List<Letra> letras;
	    letras =Arrays.asList(A);
		assertEquals(letras,jogo.transformaPalvraDigitadaEmList("A"));
		
	}
}

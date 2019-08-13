package testes;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;

import modelo.Crossword;
import modelo.Letra;
import modelo.Tabuleiro;
import modelo.Estrategias.FabricaMostraListaDeLetrasParaJogador.TipoEstrategia;

import org.junit.Test;

public class TesteAdicionarPalavras {
	private Crossword jogo;
	private Letra letra;
	@Before 
	public void configura() throws FileNotFoundException{
		
		jogo = new Crossword( );
		
		
	}

	@Test
	public void test() throws Exception {
		jogo.letrasDisponiveis(1);
		List<Letra> letrasJogdador1;
		Letra A =  new Letra('A', 7);
		Letra B =  new Letra('B', 7);
		Letra C=  new Letra('C', 7);
	    letrasJogdador1 =Arrays.asList(A,B,C);
	    jogo.adicionarPalavra(letrasJogdador1,1, 1, 1, 3, 1);
	    jogo.adicionarPalavra(letrasJogdador1,2, 1, 3, 1, 2);
		assertEquals(A,jogo.retornaTabuleiro().retornaLetra(1, 1));
		assertEquals(B,jogo.retornaTabuleiro().retornaLetra(1, 2));
		System.out.println(jogo.retornaTabuleiro().retornaGrade());
	}
		@Test
		public void test3() throws Exception {
			jogo.letrasDisponiveis(1);
			List<Letra> letrasJogdador1;
			Letra A =  new Letra('A', 7);
			Letra B =  new Letra('B', 7);
			Letra C =  new Letra('C', 7);
			Letra D =  new Letra('D', 7);
		    letrasJogdador1 =Arrays.asList(A,B,C,D);
			jogo.adicionarPalavra(letrasJogdador1,1, 1, 4, 1, 2);
			System.out.println(jogo.retornaTabuleiro().retornaGrade());
	
		
		
	}
	@Test
	public void test1() throws Exception {
		Letra A =  new Letra('A', 7);
		Letra O = new Letra('O', 7);
	    List<Letra> letrasParaRetirar;
	    jogo.letrasDisponiveis(1);
	    letrasParaRetirar =Arrays.asList(A,O);
	    jogo.tirarLetraDaSequenciaDoUsuario(letrasParaRetirar);
	    assertEquals(28,jogo.getLetrasDisponiveis().size());
}
}
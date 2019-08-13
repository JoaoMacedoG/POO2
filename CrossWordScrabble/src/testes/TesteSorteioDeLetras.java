package testes;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import modelo.Letra;
import modelo.Estrategias.FabricaMostraListaDeLetrasParaJogador;
import modelo.Estrategias.FabricaMostraListaDeLetrasParaJogador.TipoEstrategia;

public class TesteSorteioDeLetras {

	FabricaMostraListaDeLetrasParaJogador sorteio;

	@Before
	public void configura() {
		sorteio = new FabricaMostraListaDeLetrasParaJogador();
	}

	@Test
	public void test() {
		List<Letra>  lista = sorteio.criaEstrategia(TipoEstrategia.JogoFacil).mostraListaDeLetrasParaJogador();
		
		System.out.println(lista);
	}
}

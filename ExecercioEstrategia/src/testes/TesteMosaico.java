package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interfaces.EstrategiaImprimeMosaico;
import modelo.Circulo;
import modelo.EstrategiaImprimeFrenteParaTras;
import modelo.EstrategiaImprimeTrasParaFrente;
import modelo.FabricaEstrategiasImprimeMosaico;
import modelo.FabricaEstrategiasImprimeMosaico.TipoEstrategia;
import modelo.Mosaico;
import modelo.Quadrado;
import modelo.Triangulo;

public class TesteMosaico {
	private Mosaico mosaico;
	private EstrategiaImprimeMosaico estrategia;
	private FabricaEstrategiasImprimeMosaico fabrica;
	
	

	@Before
	public void configura() {
		mosaico = new Mosaico();
		fabrica = FabricaEstrategiasImprimeMosaico.getInstance();
	}

	@Test
	public void testeMosaicoComDoisTriangulos(){
		mosaico.insereFiguraGoemetrica(new Triangulo(2,2));
		mosaico.insereFiguraGoemetrica(new Triangulo(3,3));
		assertEquals(6.5, mosaico.calculeArea(),0);
		fabrica.criaEstrategia(TipoEstrategia.FrenteParaTras).imprimeMosaico(mosaico);
		
		//System.out.println(mosaico);;
	}
	@Test
	public void testeMosaicoComDoisTriangulosEUmQuadrado(){
		mosaico.insereFiguraGoemetrica(new Triangulo(2,2));
		mosaico.insereFiguraGoemetrica(new Triangulo(3,3));
		mosaico.insereFiguraGoemetrica(new Quadrado(2));
		assertEquals(10.5, mosaico.calculeArea(),0);
		fabrica.criaEstrategia(TipoEstrategia.TrasParaFrente).imprimeMosaico(mosaico);
		
	}
	
	@Test
	public void testeMosaicoComDoisTriangulosEUmQuadradoEUmCirculo(){
		mosaico.insereFiguraGoemetrica(new Triangulo(2,2));
		mosaico.insereFiguraGoemetrica(new Triangulo(3,3));
		mosaico.insereFiguraGoemetrica(new Quadrado(2));
		mosaico.insereFiguraGoemetrica(new Circulo (4));
		assertEquals(10.5 +(Math.PI*16), mosaico.calculeArea(),0);
		fabrica.criaEstrategia(TipoEstrategia.TrasParaFrente).imprimeMosaico(mosaico);
	}
}

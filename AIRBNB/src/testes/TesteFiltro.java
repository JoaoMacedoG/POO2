package testes;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import excecoes.ImovelNaoEncontrado;
import modelo.Casa;
import modelo.Cidade;
import modelo.FachadaAIRBNB;
import modelo.Imovel;
import modelo.Comparadores.FiltroPesquisa;
import modelo.Filtro.Filtro;

public class TesteFiltro {

	private FachadaAIRBNB projeto;
	private Filtro filtro;
	

	@Before
	public void configura() throws FileNotFoundException {
		projeto =  FachadaAIRBNB.getInstance() ;

	}

	@Test
	public void testaSeImoveisEncontradosSaoOsMesmoDaFachada() {
		filtro = new Filtro("Paris", 10.00, 20.00, 4, 1, 1);
		List<Imovel> imoveis = new ArrayList<Imovel>();
		imoveis = new FiltroPesquisa(projeto).filtrar(filtro);
		Cidade C1 = new Cidade("Paris");
		Casa im = new Casa(C1, "Casa1", 4, 1, 1, 10.00, 0, null,0);

		assertEquals(6, imoveis.size());
		assertEquals(imoveis.get(0).getNomeImovel(), im.getNomeImovel());
		assertEquals(imoveis.get(0).getCidade().getNomeCidade(), im.getCidade().getNomeCidade());
	}

	@Test
	public void test() throws ImovelNaoEncontrado {
		filtro = new Filtro("Paris", 10.00, 20.00, 4, 1, 1);
		List<Imovel> imoveis = new ArrayList<Imovel>();
		imoveis = projeto.pesquisarImovel(filtro);
		Cidade C1 = new Cidade("Paris");
		Casa im = new Casa(C1, "Casa1", 4, 1, 1, 10.00, 0, null,0);

		assertEquals(6, imoveis.size());
		assertEquals(imoveis.get(0).getNomeImovel(), im.getNomeImovel());
		assertEquals(imoveis.get(0).getCidade().getNomeCidade(), im.getCidade().getNomeCidade());
	}

}

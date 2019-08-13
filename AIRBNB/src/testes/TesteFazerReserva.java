package testes;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import excecoes.ExcecaoPessoaExistente;
import excecoes.ImovelJaReservado;
import excecoes.ImovelNaoExiste;
import modelo.FachadaAIRBNB;
import modelo.Reserva;
import modelo.Comparadores.ComparadorReserva;

public class TesteFazerReserva {

	private FachadaAIRBNB projeto;
	private ComparadorReserva comparador;

	@Before
	public void configura() throws FileNotFoundException {

		projeto =  FachadaAIRBNB.getInstance() ;
		comparador = new ComparadorReserva(projeto);

	}

	@Test
	public void reserva() throws ExcecaoPessoaExistente, ImovelNaoExiste, ImovelJaReservado {
		projeto.cadastraPessoa("jj", "masculino", 1);
		Reserva reserva = new Reserva(2, 5, 1, projeto.getImovel("ap"), projeto.getCidade("Paris"),
				projeto.getPessoa(1));

		projeto.reservarImovel(reserva);

		assertEquals(1, projeto.tamanhoListReservas());

	}

	@Test
	public void comparadorReserva() throws ExcecaoPessoaExistente, ImovelNaoExiste, ImovelJaReservado {
		projeto.cadastraPessoa("jj", "masculino", 1);
		projeto.cadastraPessoa("jj", "masculino", 2);
		Reserva reserva = new Reserva(2, 5, 1, projeto.getImovel("ap"), projeto.getCidade("Paris"),
				projeto.getPessoa(1));
		Reserva reserva2 = new Reserva(2, 5, 1, projeto.getImovel("ap"), projeto.getCidade("Paris"),
				projeto.getPessoa(2));
		projeto.reservarImovel(reserva);
		// projeto.reservarImovel(reserva2);

		assertEquals(true, comparador.checaSeReservado(reserva2));
		assertEquals(1, projeto.tamanhoListReservas());
	}


}

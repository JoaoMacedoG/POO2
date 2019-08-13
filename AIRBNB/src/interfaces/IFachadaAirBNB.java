package interfaces;

import java.util.List;

import excecoes.ImovelJaReservado;
import excecoes.ImovelNaoEncontrado;
import excecoes.ImovelNaoExiste;
import modelo.Imovel;
import modelo.Reserva;
import modelo.Filtro.Filtro;

public interface IFachadaAirBNB {
	
	public List<Imovel> pesquisarImovel(Filtro filtro) throws ImovelNaoEncontrado;
	
	
	public void reservarImovel(Reserva reserva ) throws ImovelNaoExiste, ImovelJaReservado;
	
}

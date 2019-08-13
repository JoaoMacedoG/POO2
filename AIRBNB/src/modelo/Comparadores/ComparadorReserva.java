package modelo.Comparadores;

import java.io.Serializable;

import modelo.FachadaAIRBNB;
import modelo.Reserva;

public class ComparadorReserva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FachadaAIRBNB fachada;

	public ComparadorReserva(FachadaAIRBNB fachada) {
		this.fachada = fachada;
	}

	public boolean checaSeReservado(Reserva reserva) {
		for (int cont = 0; cont < fachada.tamanhoListReservas(); cont++) {
			if (comparaIntervaloDataIgualoMaiorSaidaIgual(cont, reserva) == true
					|| comparaIntervaloDataInicioMenorSaidaMenor(cont, reserva) == true
					|| comparaIntervalosMaioresReserva(cont, reserva)		
					|| comparaReserva(cont, reserva) 
					) {
				return true;
			}

		}

		return false;
	}

	private boolean comparaIntervalosMaioresReserva(int cont, Reserva reserva) {
		if (fachada.getReservas().get(cont).getImovelEscolhido().getNomeImovel()
				.equals(reserva.getImovelEscolhido().getNomeImovel())
				&& fachada.getReservas().get(cont).getMes().equals(reserva.getMes())

				&& reserva.getDataDeInicio() <= fachada.getReservas().get(cont).getDataDeInicio()
				&& reserva.getDataDeSaida() >= fachada.getReservas().get(cont).getDataDeSaida())

		{
			return true;

		}
		return false;

	}
	
	private boolean comparaReserva(int cont, Reserva reserva) {
		if (fachada.getReservas().get(cont).getImovelEscolhido().getNomeImovel()
				.equals(reserva.getImovelEscolhido().getNomeImovel())
				&& fachada.getReservas().get(cont).getMes().equals(reserva.getMes())

				&& reserva.getDataDeInicio() >= fachada.getReservas().get(cont).getDataDeInicio()
				&& reserva.getDataDeSaida() >= fachada.getReservas().get(cont).getDataDeSaida())

		{
			return true;

		}
		return false;

	}

	private boolean comparaIntervaloDataInicioMenorSaidaMenor(int cont, Reserva reserva) {
		if (fachada.getReservas().get(cont).getImovelEscolhido().getNomeImovel()
				.equals(reserva.getImovelEscolhido().getNomeImovel())
				&& fachada.getReservas().get(cont).getMes().equals(reserva.getMes())
				&& reserva.getDataDeInicio() <= fachada.getReservas().get(cont).getDataDeInicio()
				&& reserva.getDataDeSaida() <= fachada.getReservas().get(cont).getDataDeSaida()

		) {
			return true;

		}
		return false;

	}

	private boolean comparaIntervaloDataIgualoMaiorSaidaIgual(int cont, Reserva reserva) {
		if (fachada.getReservas().get(cont).getImovelEscolhido().getNomeImovel()
				.equals(reserva.getImovelEscolhido().getNomeImovel())
				&& reserva.getMes().equals(fachada.getReservas().get(cont).getMes())
				&& reserva.getDataDeInicio() >= fachada.getReservas().get(cont).getDataDeInicio()
				&& reserva.getDataDeSaida() <= fachada.getReservas().get(cont).getDataDeSaida()) {
			return true;
		}
		return false;

	}

}
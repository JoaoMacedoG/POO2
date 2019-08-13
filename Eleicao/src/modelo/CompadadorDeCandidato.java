package modelo;

import java.io.Serializable;
import java.util.Comparator;

public class CompadadorDeCandidato implements Comparator<Candidato>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int compare(Candidato arg0, Candidato arg1) {
		return Integer.compare(arg0.getNumeroDeVotosGanhos(), arg1.getNumeroCandidatoAserVotado());
	}

}

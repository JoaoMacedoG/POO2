package modelo.Criador;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import modelo.Cidade;

public  class CriadorDeCidades  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CriadorDeCidades() {
	}

	public List<Cidade> criaListCidades() {
		List<Cidade> listDeCidades;
		Cidade C1 = new Cidade("Paris");
		Cidade C2 = new Cidade("Londres");
		Cidade C3 = new Cidade("Rio de Janeiro");
		listDeCidades = Arrays.asList(C1, C2, C3);
		return listDeCidades;
	}
}

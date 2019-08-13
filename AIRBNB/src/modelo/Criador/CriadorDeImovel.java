package modelo.Criador;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Cidade;

public  class CriadorDeImovel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CriadorDeImovel() {

	}

	public List<Casa> criaCasas() {
		List<Casa> listDeImoveis;

		Cidade C1 = new Cidade("Paris");
		Casa C4 = new Casa(C1, "Casa1", 4, 1, 1, 10.00, 0,"Sim",0);
		Casa C2 = new Casa(C1, "Casa2", 4, 1, 1, 10.00, 0,"Sim",0);
		Casa C3 = new Casa(C1, "Casa3", 4, 1, 1, 10.00, 0,"Sim",0);
		listDeImoveis = Arrays.asList(C4, C2, C3);
		return listDeImoveis;
	}
	
	public List<Apartamento> criaApartamentos() {
		List<Apartamento> listDeImoveis;

		Cidade C1 = new Cidade("Paris");
		Apartamento C4 = new Apartamento(C1, "ap1", 4, 1, 1, 10.00, 0, "1º",0);
		Apartamento C2 = new Apartamento(C1, "ap2", 4, 1, 1, 10.00,0, "2º",0);
		Apartamento C3 = new Apartamento(C1, "ap3", 4, 1, 1, 10.00, 0 , "3º",0);
		listDeImoveis = Arrays.asList(C4, C2, C3);
		return listDeImoveis;
	}
}

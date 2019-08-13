package modelo;

import java.io.Serializable;

public class Apartamento extends Imovel implements Serializable {

	private static final long serialVersionUID = 1L;
	private	String andar;	
	
	public Apartamento(Cidade cidade, String nomeImovel, Integer numeroDeBanheiros, Integer numeroCamas,
			Integer numeroQuartos, double preco, Integer numeroAvaliacoes, String andar,Integer notaDoImovel ) {
		super(cidade, nomeImovel, numeroDeBanheiros, numeroCamas, numeroQuartos, preco, numeroAvaliacoes, notaDoImovel);
		
		this.setAndar(andar);
	}

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}



}

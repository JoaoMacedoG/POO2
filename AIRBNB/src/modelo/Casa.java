package modelo;

import java.io.Serializable;

public class Casa extends Imovel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String jardim;
	
	public Casa(Cidade cidade, String nomeImovel, Integer numeroDeBanheiros, Integer numeroCamas, Integer numeroQuartos,
			double preco, Integer numeroAvaliacoes, String jardim,Integer notaDoImovel) {
		super(cidade, nomeImovel, numeroDeBanheiros, numeroCamas, numeroQuartos, preco, numeroAvaliacoes, notaDoImovel);
		this.jardim = jardim;
		
	}

	public String getJardim() {
		return jardim;
	}

	public void setJardim(String jardim) {
		this.jardim = jardim;
	}
	

}

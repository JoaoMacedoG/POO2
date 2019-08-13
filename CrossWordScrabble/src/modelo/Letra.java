package modelo;

import interfaces.iLetra;

public class Letra implements iLetra{

	private int valorLetra;
	private Character caracter;
	
	public Letra(Character caracter, int valorLetra){
		this.valorLetra= valorLetra;
		this.caracter = caracter;
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Letra other = (Letra) obj;
		if (caracter == null) {
			if (other.caracter != null)
				return false;
		} else if (!caracter.equals(other.caracter))
			return false;
		return true;
	}


	
	
	

	@Override
	public int getValorLetra() {
		// TODO Auto-generated method stub
		return valorLetra;
	}


	@Override
	public Character getCaracter() {
		// TODO Auto-generated method stub
		return caracter ;
	}


	public String toString(){
		return String.format("%s",caracter);
	}
	

}

package modelo.construtorLetrasDoAlfabeto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modelo.Letra;

public abstract class ConstrutorDeLetrasDoAlfabeto {
	
	
	  
	public ConstrutorDeLetrasDoAlfabeto(){
	
		
	}
		
	public List<Letra> retornaConsoantesFaceis(){
		 List<Letra> consoantesFaceis;
		Letra B = new Letra('B', 7);
		 Letra N = new Letra('N', 7);
		 Letra M = new Letra('M', 7);
		 Letra P = new Letra('P', 7);
		 Letra C = new Letra('C', 7);
		 Letra D = new Letra('D', 7);
		 Letra F = new Letra('F', 7);
		 Letra G = new Letra('G', 7);
		 Letra H = new Letra('H', 7);
		 Letra J = new Letra('J', 7);
		 Letra L = new Letra('L', 7);
		 Letra R = new Letra('R', 7);
		 Letra S = new Letra('S', 7);
		 Letra T = new Letra('T', 7);
		 Letra V = new Letra('V', 7);
		
		 consoantesFaceis=Arrays.asList(B,C,D,F,G,H,J,L,M,N,P,R,S,T,V);
		 return consoantesFaceis;
		
	}
	
	public List<Letra> retornaConsoantesDificeis(){
		 List<Letra> consoantesDificeis;
		Letra K = new Letra('K', 7);
		 Letra Q = new Letra('Q', 7);
		 Letra W = new Letra('W', 7);
		 Letra X = new Letra('X', 7);
		 Letra Y = new Letra('Y', 7);
		 Letra Z = new Letra('Z', 7);
		
		 consoantesDificeis=Arrays.asList(K,Q,W,X,Y,Z);
		 return consoantesDificeis;
			}
	
	public List<Letra> retornaVogais(){
		 List<Letra> vogais;
		Letra A = new Letra('A', 7);
		 Letra E = new Letra('E', 7);
		 Letra I = new Letra('I', 7);
		 Letra O = new Letra('O', 7);
		 Letra U = new Letra('U', 7);
		 vogais=Arrays.asList(A,A,E,I,O,O,U,U,U);
		 return vogais;
			}



	@Override
	public String toString() {
		return "ConstrutorDeLetrasDoAlfabeto [retornaConsoantesFaceis()=" + retornaConsoantesFaceis()
				+ ", retornaConsoantesDificeis()=" + retornaConsoantesDificeis() + ", retornaVogais()="
				+ retornaVogais() + ", toString()=" + super.toString() + "]";
	}
	

	}

	


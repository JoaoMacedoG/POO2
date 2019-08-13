package modelo;

import interfaces.EstrategiaImprimeMosaico;

public class EstrategiaImprimeFrenteParaTras implements EstrategiaImprimeMosaico {
	
	public void imprimeMosaico(Mosaico mosaico){
		System.out.println("Frente");
		int tamanho =  mosaico.quantidadeFiguras();
		for ( int pos=0; pos<tamanho; pos++){
			System.out.println(mosaico.retornaFiguraDaPosicao(pos));
		}
	}

}

package modelo;

import interfaces.EstrategiaImprimeMosaico;

public class EstrategiaImprimeTrasParaFrente implements EstrategiaImprimeMosaico {
	
	public void imprimeMosaico(Mosaico mosaico){
		System.out.println("Tras");
		int tamanho =  mosaico.quantidadeFiguras();
		for ( int pos=tamanho-1; pos>=0; pos--){
			System.out.println(mosaico.retornaFiguraDaPosicao(pos));
		}
	}

}

package interfaces;

import modelo.Letra;

public interface iTabuleiroLetras {
	public Letra retornaLetra(int linha, int coluna);
	public int numeroLinhas();
	public int numeroColunas();

}

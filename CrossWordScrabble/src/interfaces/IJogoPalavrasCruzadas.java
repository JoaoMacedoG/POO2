package interfaces;

import java.util.List;

import modelo.Grade;
import modelo.Letra;
import modelo.Tabuleiro;

public interface IJogoPalavrasCruzadas {
	
	public void adicionarPalavra (List<Letra> listaLetras, int linhaInicial, int colunaInicial, int linhaFinal, int colunaFinal, int direcao)
	throws Exception;
	public void letrasDisponiveis(int tipo);
	public int pontuacao();
	public void pararJogoDesisto();
	public void acabarJogoSeListaDeLetrasDaPessoaAcabar();
	public Tabuleiro retornaTabuleiro();
	
}
	
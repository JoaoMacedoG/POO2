package modelo;
import java.util.Random;
import java.util.Scanner;

import excecoes.ExcecaoPalavraInexistente;
import interfaces.iLetra;
import modelo.Estrategias.FabricaMostraListaDeLetrasParaJogador;
import modelo.Estrategias.FabricaMostraListaDeLetrasParaJogador.TipoEstrategia;
import interfaces.IJogoPalavrasCruzadas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Crossword implements IJogoPalavrasCruzadas {

	private Tabuleiro tabuleiro;
	private FabricaMostraListaDeLetrasParaJogador sorteioDeLetras;
	private List<Letra> letrasDisponiveis;
	private int pontuacao;
	private boolean terminarJogo;
	private List<String> dicionario;
	
	
	public Crossword()  {
		this.sorteioDeLetras= new FabricaMostraListaDeLetrasParaJogador();
		this.letrasDisponiveis = letrasDisponiveis;
		this.terminarJogo = false;
		this.tabuleiro = Tabuleiro.getInstance(9,5);
		try {
			this.dicionario = dicionarioEmList();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}	
	@Override
	public int pontuacao() {
		return this.pontuacao;	
		}
	
	public void somarPontos(List<Letra> letrasParaPontuar) {
		for(Letra letra: letrasParaPontuar){
			 this.pontuacao = this.pontuacao + letra.getValorLetra();
		}
	}
	public void subtrairPontos(List<Letra> letrasParaPontuar) {
		for(Letra letra: letrasParaPontuar){
			 this.pontuacao = this.pontuacao - letra.getValorLetra();
		}
	}
		
	@Override
	public Tabuleiro retornaTabuleiro() {
		 return this.tabuleiro;
			}

	@Override
	public void letrasDisponiveis(int tipo) {
		 this.letrasDisponiveis =  sorteioDeLetras.criaEstrategia(sorteioDeLetras.setTipoDeJogoEscolhido(tipo)).mostraListaDeLetrasParaJogador();
				}
	
	@Override
	public void adicionarPalavra(List<Letra> listaLetras, int linhaInicial, int colunaInicial, int linhaFinal,
			int colunaFinal, int direcao) throws Exception {
		if( direcao== 1){
			adicionaNaDirecaoHorizontal(listaLetras, linhaInicial, colunaInicial, colunaFinal);
				
		}
		else{
			adicionaNaDirecaoVertical(listaLetras,linhaInicial, linhaFinal,colunaInicial);
		}
		
		somarPontos(listaLetras);
		
			
	}
	
	private void adicionaNaDirecaoHorizontal(List<Letra> listaLetras, int linha, int colunaInicial,
			int colunaFinal){
		
		for( int i = 0; i<colunaFinal;i++){
			if(posicaoOcupada(linha, colunaInicial+i)==false){
			tabuleiro.insereLetraNoTabuleiro(linha, colunaInicial+i, listaLetras.get(i));}
			else{
				tabuleiro.insereLetraNoTabuleiro(linha, colunaInicial+i+1, listaLetras.get(i));
				}			
			};
			tirarLetraDaSequenciaDoUsuario(listaLetras);
			
		}
	private void adicionaNaDirecaoVertical(List<Letra> listaLetras,int linhaInicial, int linhaFinal, int coluna){
		for( int i = 0; i<linhaFinal;i++){
			if(posicaoOcupada(linhaInicial+i, coluna)==false){
			tabuleiro.insereLetraNoTabuleiro(linhaInicial+i, coluna, listaLetras.get(i));}
			else{
				tabuleiro.insereLetraNoTabuleiro(linhaInicial+i+1, coluna, listaLetras.get(i));
				}
					};
			tirarLetraDaSequenciaDoUsuario(listaLetras);
		}	
	

	private boolean posicaoOcupada(int linha, int coluna){
		boolean posicaoOcupada = false;
		if(tabuleiro.retornaGrade().retorna(linha, coluna)!= null){
			posicaoOcupada= true;
		}
		return posicaoOcupada;
			
	}
	
	public void pararJogoDesisto() {
		encerrarJogo();

	}
	
	public List<Letra> getLetrasDisponiveis() {
		return letrasDisponiveis;
	}
	
	public void tirarLetraDaSequenciaDoUsuario(List<Letra> letrasParaRetirar) {
		for(int i = 0; i<letrasParaRetirar.size(); i++){
			if(letrasDisponiveis.contains(letrasParaRetirar.get(i))){
				letrasDisponiveis.remove(i);
			}
		}
	}

	public void acabarJogoSeListaDeLetrasDaPessoaAcabar(){
		if(letrasDisponiveis == null)
			encerrarJogo();
	}
	
	public boolean checarSeJogadaValida(String palavraDesejada)throws ExcecaoPalavraInexistente{
			if(dicionario.contains(palavraDesejada)){
		return true;
		} else{
			return false;
		}
	
		}
		
	public void encerrarJogo(){
		this.terminarJogo= true;
	}


	public List<Letra> transformaPalvraDigitadaEmList(String palavraDigitada) {
		char[] letraDaPalavra = palavraDigitada.toCharArray();
		List<Letra> palavraDigitadaEmLista = new ArrayList<Letra>();
		for (int conti = 0; conti < palavraDigitada.length(); conti++)
			palavraDigitadaEmLista.add(new Letra((Character) letraDaPalavra[conti], 7));

		for (int conti = 0; conti < palavraDigitadaEmLista.size(); conti++) {
			if ((checarSeLetraExisteNasLetrasDisponiveis(palavraDigitadaEmLista.get(conti)))== false) {
				return null;
			}
		}
		return palavraDigitadaEmLista;
	
	}
		public boolean checarSeLetraExisteNasLetrasDisponiveis(Letra letra) {
			for (int conti = 0; conti < letrasDisponiveis.size(); conti++) {
				if (letrasDisponiveis.get(conti).getCaracter().equals(letra.getCaracter())){
					return true;
				}
			}
			return false;
		}
		
		public List<String> dicionarioEmList() throws FileNotFoundException{
			Scanner scanner = new Scanner(new File("resources/dicionario.txt"));
			List<String> dicionarioCriado = new ArrayList<String>();
			while(scanner.hasNextLine()){
				dicionarioCriado.add(scanner.nextLine());
			}
			scanner.close();
			return dicionarioCriado;
		}
		
		public List<String> getDicionario() {
			return dicionario;
		}
}

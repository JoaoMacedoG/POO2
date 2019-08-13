package modelo;

import interfaces.iTabuleiroLetras;

public class Tabuleiro implements iTabuleiroLetras {

	 private Grade tabuleiro;
	 private static Tabuleiro singleton;
	
	public Tabuleiro(int numeroLinhas,int numeroColunas){
		this.tabuleiro = new Grade(numeroLinhas,numeroColunas);
	
	}
	

    public static Tabuleiro getInstance(int linha, int  coluna) {
	if (singleton == null)
	    singleton = new Tabuleiro(linha, coluna);
	return singleton;
    }
    
	@Override
	public Letra retornaLetra(int linha, int coluna) {
		return (Letra) this.tabuleiro.retorna(linha, coluna);
		
	}

	@Override
	public int numeroLinhas() {
		return this.tabuleiro.retornaNumLinhas();
	}

	@Override
	public int numeroColunas() {
		return this.tabuleiro.retornaNumColunas(); 
	}
	
	public Grade retornaGrade(){
		return this.tabuleiro;
	}
	
	public void insereLetraNoTabuleiro(int linha, int coluna, Letra elemento) {
		tabuleiro.insere(linha, coluna, elemento);
		}
	
	
	}



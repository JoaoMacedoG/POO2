package modelo;

public class FuncionarioHomem extends Funcionario {

	public FuncionarioHomem(String nome, int idade, int tempoDeContribuicao, int valorDeContribuicao) {
		super(nome, idade, tempoDeContribuicao, valorDeContribuicao);
		// TODO Auto-generated constructor stub
	}

	public  Double tempoDevidoFuncionario(){
		int tempoRestante= 35 - this.getTempoDeContribuicao();
		int idadeMinima = 60 - this.getIdade();
		return tempoRestante+idadeMinima *1.1;
	};
	
	

}

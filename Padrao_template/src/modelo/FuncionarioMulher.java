package modelo;

public class FuncionarioMulher extends Funcionario {

	public FuncionarioMulher(String nome, int idade, int tempoDeContribuicao, int valorDeContribuicao) {
		super(nome, idade, tempoDeContribuicao, valorDeContribuicao);
		// TODO Auto-generated constructor stub
	}

	public  Double tempoDevidoFuncionario(){
		int tempoRestante= 30 - this.getTempoDeContribuicao();
		int idadeMinima = 55 - this.getIdade();
		return tempoRestante+idadeMinima *1.00;
	};
}

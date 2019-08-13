package modelo;

public abstract class Funcionario {
	
	public static int indiceDeAposentadoria = 1;
	
	private String nome;
	private int idade; 
	private int tempoDeContribuicao;
	private int valorDeContribuicao;
	
	
	public Funcionario(String nome, int idade, int tempoDeContribuicao, int valorDeContribuicao){
		this.idade= idade;
		this.nome= nome;
		this.tempoDeContribuicao = tempoDeContribuicao;
		this.valorDeContribuicao= valorDeContribuicao;
	}
	
	public void mudaIdade(int aumentaIdade){
		this.idade=this.idade+ aumentaIdade;
	}
	public int getTempoDeContribuicao(){
		return this.tempoDeContribuicao;
	}
	
	public int getIdade() {
		return idade;
	}

	public int getValorDeContribuicao(){
		return this.valorDeContribuicao;
	}

	public void mudaTempoDeContribuicao(int aumentaTempoDeContribuicao){
		this.tempoDeContribuicao= this.tempoDeContribuicao+ aumentaTempoDeContribuicao;
		
	}
	
	public void mudaValorDeContribuicao(int aumentaTempoDeContribuicao){
		this.valorDeContribuicao=this.valorDeContribuicao+ aumentaTempoDeContribuicao;
	}
	
	public abstract Double tempoDevidoFuncionario();

	
	public final double calculaSalarioDeAposentadoria(){
		double salarioAposentadoria = getValorDeContribuicao()/(20+ tempoDevidoFuncionario())*indiceDeAposentadoria;
		
		return salarioAposentadoria;
		
	}
}

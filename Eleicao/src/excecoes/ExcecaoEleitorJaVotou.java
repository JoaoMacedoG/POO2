package excecoes;

public class ExcecaoEleitorJaVotou extends Exception {
private static final long serialVersionUID =1L;
	
	
	public ExcecaoEleitorJaVotou(){
		super();
	}

	public ExcecaoEleitorJaVotou(String msg){
		super("Eleitor ja votou");
	}


}

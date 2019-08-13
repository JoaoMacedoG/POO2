package excecoes;

public class ExcecaoEleicaoFechada extends Exception{
	private static final long serialVersionUID =  1L;

	
	public ExcecaoEleicaoFechada(){
		super();
	}

	public ExcecaoEleicaoFechada(String msg){
		super(msg);
	}

}

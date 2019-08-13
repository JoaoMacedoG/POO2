package excecoes;

public class ExcecaoPessoaExistente  extends Exception{
	private static final long serialVersionUID =  1L;

	
	public ExcecaoPessoaExistente(){
		super();
	}

	public ExcecaoPessoaExistente(String msg){
		super(msg);
	}

}

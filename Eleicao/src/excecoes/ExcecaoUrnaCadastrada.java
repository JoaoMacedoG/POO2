package excecoes;

public class ExcecaoUrnaCadastrada extends Exception{
	private static final long serialVersionUID =  1L;

	
	public ExcecaoUrnaCadastrada(){
		super();
	}

	public ExcecaoUrnaCadastrada(String msg){
		super(msg);
	}


}

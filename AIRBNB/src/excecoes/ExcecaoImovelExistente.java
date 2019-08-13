package excecoes;

public class ExcecaoImovelExistente extends Exception {
	
	private static final long serialVersionUID =  1L;

	
	public ExcecaoImovelExistente(){
		super();
	}

	public ExcecaoImovelExistente(String msg){
		super(msg);
	}

}

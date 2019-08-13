package excecoes;

public class ExcecaoEleitorExistente extends Exception {
	
	private static final long serialVersionUID =1L;
	
	
	public ExcecaoEleitorExistente(){
		super();
	}

	public ExcecaoEleitorExistente(String msg){
		super(msg);
	}

}

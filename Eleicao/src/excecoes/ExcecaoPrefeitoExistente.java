package excecoes;

public class ExcecaoPrefeitoExistente extends Exception {
	
	private static final long serialVersionUID =1L;
	
	
	public ExcecaoPrefeitoExistente(){
		super();
	}

	public ExcecaoPrefeitoExistente(String msg){
		super(msg);
	}
}

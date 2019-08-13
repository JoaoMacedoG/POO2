package excecoes;

public class ExcecaoPartidoExistente extends Exception {
	
	private static final long serialVersionUID =1L;
	
	
	public ExcecaoPartidoExistente(){
		super();
	}

	public ExcecaoPartidoExistente(String msg){
		super(msg);
	}

}
package excecoes;

public class ExcecaoUrnaExistente extends Exception {
private static final long serialVersionUID =1L;
	
	
	public ExcecaoUrnaExistente(){
		super();
	}

	public ExcecaoUrnaExistente(String msg){
		super("urna existente");
	}
}




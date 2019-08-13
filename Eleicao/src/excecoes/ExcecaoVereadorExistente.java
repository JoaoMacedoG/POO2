package excecoes;

public class ExcecaoVereadorExistente extends Exception {
	
	private static final long serialVersionUID =1L;
	
	
	public ExcecaoVereadorExistente(){
		super();
	}

	public ExcecaoVereadorExistente(String msg){
		super(msg);
	}
}

package excecoes;

public class ExcecaoCidadeExistente extends Exception {

	private static final long serialVersionUID = 1L;

	public ExcecaoCidadeExistente(){
		super();
	}

	public ExcecaoCidadeExistente(String msg){
		super(msg);
	}

}

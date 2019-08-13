package excecoes;

public class ImovelNaoEncontrado extends Exception {
	
private static final long serialVersionUID =  1L;

	
	public ImovelNaoEncontrado(){
		super();
	}

	public ImovelNaoEncontrado(String msg){
		super(msg);
	}

}



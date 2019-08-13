package excecoes;

public class ImovelNaoExiste  extends Exception{
	private static final long serialVersionUID =  1L;

	
	public ImovelNaoExiste(){
		super();
	}

	public ImovelNaoExiste(String msg){
		super(msg);
	}

}

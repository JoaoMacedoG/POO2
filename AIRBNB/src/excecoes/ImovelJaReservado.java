package excecoes;

public class ImovelJaReservado extends Exception {
	
private static final long serialVersionUID =  1L;

	
	public ImovelJaReservado(){
		super();
	}

	public ImovelJaReservado(String msg){
		super(msg);
	}

}

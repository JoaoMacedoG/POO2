package excecoes;

public class ReservaNaoExistente extends Exception {
private static final long serialVersionUID =  1L;

	
	public ReservaNaoExistente(){
		super();
	}

	public ReservaNaoExistente(String msg){
		super(msg);
	}

}

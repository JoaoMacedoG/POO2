package excecoes;

public class ExcecaoPalavraInexistente extends Exception {
	
		private static final long serialVersionUID =  1L;

		
		public ExcecaoPalavraInexistente(){
			super();
		}

		public ExcecaoPalavraInexistente(String msg){
			super("Palavra n�o existe no dicionario");
		}


}

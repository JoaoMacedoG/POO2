package excecoes;

public class ExcecaoPalavraInexistente extends Exception {
	
		private static final long serialVersionUID =  1L;

		
		public ExcecaoPalavraInexistente(){
			super();
		}

		public ExcecaoPalavraInexistente(String msg){
			super("Palavra não existe no dicionario");
		}


}

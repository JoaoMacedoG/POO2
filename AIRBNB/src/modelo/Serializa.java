package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void salvaFachada(FachadaAIRBNB fachada, String nomeDoArquivo) throws IOException {
		try {
			FileOutputStream arquivo = new FileOutputStream(nomeDoArquivo);
			ObjectOutputStream stream = new ObjectOutputStream(arquivo);
			stream.writeObject(fachada);
			arquivo.close();
		} catch (FileNotFoundException e) {
		}
	}

	@SuppressWarnings("finally")
	public FachadaAIRBNB carregaFachada(String nomeArquivo) throws IOException, Exception {
		FachadaAIRBNB fachada = null;
		try {
			FileInputStream arquivo = new FileInputStream(nomeArquivo);
			ObjectInputStream stream = new ObjectInputStream(arquivo);
			fachada = (FachadaAIRBNB) stream.readObject();
			stream.close();
			return fachada;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			return fachada;
		}
	}

}
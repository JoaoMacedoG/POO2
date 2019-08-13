package modelo.Comparadores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modelo.FachadaAIRBNB;
import modelo.Imovel;
import modelo.Filtro.Filtro;

public class FiltroPesquisa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FachadaAIRBNB fachada;

	public FiltroPesquisa(FachadaAIRBNB fachada) {
		this.fachada = fachada;
	}

	public List<Imovel> filtrar(Filtro filtro) {

		List<Imovel> imoveisFiltrados = new ArrayList<Imovel>();

		for (int i = 0; i < fachada.tamanhoListTodosImoveis(); i++) {
			if (fachada.getTodosImoveis().get(i).getNumeroBanheiros().equals(filtro.getNumeroBanheiros())
					&& fachada.getTodosImoveis().get(i).getNumeroCamas().equals(filtro.getNumeroCamas())
					&& fachada.getTodosImoveis().get(i).getNumeroQuartos().equals(filtro.getNumeroQuartos())
					&& fachada.getTodosImoveis().get(i).getCidade().getNomeCidade().equals(filtro.getCidade())
					&& filtro.getPrecoMinimo() <= fachada.getTodosImoveis().get(i).getPreco()
					&& filtro.getPrecoMaximo() >= fachada.getTodosImoveis().get(i).getPreco()) {

				imoveisFiltrados.add(fachada.getTodosImoveis().get(i));
			}
			;

			;
		}
		return imoveisFiltrados;

	}

}

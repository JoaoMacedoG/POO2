package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import visao.FormularioPesquisaImovel;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excecoes.ImovelNaoEncontrado;
import modelo.FachadaAIRBNB;
import modelo.Imovel;
import modelo.Filtro.Filtro;

public class TratadorBotaoPesquisaImovel implements ActionListener {
	private FachadaAIRBNB fachada;
	JTextField texPrecoMinimo, texPrecoMaximo, texNumeroCamas, texNumeroBanheiros, texCidade, texNumeroQuartos;
	FormularioPesquisaImovel formularioPesquisaImovel;

	public TratadorBotaoPesquisaImovel(JTextField texPrecoMinimo, JTextField texPrecoMaximo, JTextField texNumeroCamas,
			JTextField texNumeroBanheiros, JTextField texNumeroQuartos, JTextField texCidade,
			FormularioPesquisaImovel formularioPesquisaImovel, FachadaAIRBNB fachada) {
		this.fachada = fachada;
		this.formularioPesquisaImovel = formularioPesquisaImovel;
		this.texPrecoMinimo = texPrecoMinimo;
		this.texNumeroBanheiros = texNumeroBanheiros;
		this.texPrecoMaximo = texPrecoMaximo;
		this.texNumeroCamas = texNumeroCamas;
		this.texNumeroQuartos = texNumeroQuartos;
		this.texCidade = texCidade;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Boolean limpaFormulario = true;
		List<Imovel> imoveisFiltrados = new ArrayList<Imovel>();
		Filtro filtro = new Filtro(texCidade.getText(), Double.parseDouble(texPrecoMinimo.getText()),
				Double.parseDouble(texPrecoMaximo.getText()), Integer.parseInt(texNumeroBanheiros.getText()),
				Integer.parseInt(texNumeroQuartos.getText()), Integer.parseInt(texNumeroCamas.getText()));

		try {
			imoveisFiltrados = fachada.pesquisarImovel(filtro);
			
		} catch (ImovelNaoEncontrado e) {
			JOptionPane.showMessageDialog(null, "Erro, imovel nao encontrado");
			
		}
		new TabelaImoveisFiltrados(imoveisFiltrados);
		if (limpaFormulario) {
			limpaDados();
		}

		this.formularioPesquisaImovel.dispose();

	}

	private void limpaDados() {
		texCidade.setText("");
		texPrecoMinimo.setText("");
		texPrecoMaximo.setText("");
		texNumeroQuartos.setText("");
		texNumeroBanheiros.setText("");
		texNumeroCamas.setText("");

	}

}

package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import excecoes.ExcecaoCidadeExistente;
import excecoes.ExcecaoImovelExistente;
import modelo.FachadaAIRBNB;

public class TratadorBotaoCadastraImovel implements ActionListener {

	private FachadaAIRBNB fachada;
	JTextField nomeCidade, nomeImovel, numBanheiros, numQuartos, numCamas, numPreco, numAvaliacoes;
	FormularioCadastroImoveis formulario;

	public TratadorBotaoCadastraImovel(JTextField nomeCidade, JTextField nomeImovel, JTextField numBanheiros,
			JTextField numQuartos, JTextField numCamas, JTextField numPreco, FormularioCadastroImoveis formulario,
			FachadaAIRBNB fachada) {

		this.fachada = fachada;
		this.formulario = formulario;
		this.numPreco = numPreco;
		this.numCamas = numCamas;
		this.numQuartos = numQuartos;
		this.numBanheiros = numBanheiros;
		this.nomeImovel = nomeImovel;
		this.nomeCidade = nomeCidade;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Boolean limpaFormulario = true;

		try {
			fachada.cadastraImovel(nomeCidade.getText(), nomeImovel.getText(), Integer.parseInt(numBanheiros.getText()),
					Integer.parseInt(numCamas.getText()), Integer.parseInt(numQuartos.getText()),
					Double.parseDouble(numPreco.getText()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcecaoImovelExistente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcecaoCidadeExistente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (limpaFormulario) {
			limpaDados();
		}
		this.formulario.dispose();
	}

	private void limpaDados() {
		numPreco.setText("");
		nomeCidade.setText("");
		nomeImovel.setText("");
		numBanheiros.setText("");
		numQuartos.setText("");
		numCamas.setText("");

	}

}

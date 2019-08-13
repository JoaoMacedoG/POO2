package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excecoes.ExcecaoCidadeExistente;
import excecoes.ExcecaoImovelExistente;
import modelo.FachadaAIRBNB;

public class TratadorBotaoCadastraCasa implements ActionListener {

	private FachadaAIRBNB fachada;
	JTextField nomeCidade, nomeImovel, temJardim, numBanheiros, numQuartos, numCamas, numPreco, numAvaliacoes;
	FormularioCadastroCasa formulario;

	public TratadorBotaoCadastraCasa(JTextField nomeCidade, JTextField nomeImovel, JTextField numBanheiros,
			JTextField numQuartos, JTextField numCamas, JTextField numPreco, JTextField temJardim,
			FormularioCadastroCasa formulario, FachadaAIRBNB fachada) {

		this.fachada = fachada;
		this.formulario = formulario;
		this.numPreco = numPreco;
		this.numCamas = numCamas;
		this.numQuartos = numQuartos;
		this.numBanheiros = numBanheiros;
		this.nomeImovel = nomeImovel;
		this.nomeCidade = nomeCidade;
		this.temJardim = temJardim;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Boolean limpaFormulario = true;

		try {
			fachada.cadastraCasa(nomeCidade.getText(), nomeImovel.getText(), Integer.parseInt(numBanheiros.getText()),
					Integer.parseInt(numCamas.getText()), Integer.parseInt(numQuartos.getText()),
					Double.parseDouble(numPreco.getText()), temJardim.getText());
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (ExcecaoImovelExistente e) {
			JOptionPane.showMessageDialog(null,"Este imovel ja existe");
			e.printStackTrace();
		} catch (ExcecaoCidadeExistente e) {

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
		temJardim.setText("");
	}

}

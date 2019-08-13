package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excecoes.ExcecaoCidadeExistente;
import excecoes.ExcecaoImovelExistente;
import modelo.FachadaAIRBNB;

public class TratadorBotaoCadastraApartamento implements ActionListener {

	private FachadaAIRBNB fachada;
	JTextField nomeCidade, nomeImovel, andar, numBanheiros, numQuartos, numCamas, numPreco, numAvaliacoes;
	FormularioCadastroApartamento formulario;

	public TratadorBotaoCadastraApartamento(JTextField nomeCidade, JTextField nomeImovel, JTextField numBanheiros,
			JTextField numQuartos, JTextField numCamas, JTextField numPreco, JTextField andar,
			FormularioCadastroApartamento formulario, FachadaAIRBNB fachada) {

		this.fachada = fachada;
		this.formulario = formulario;
		this.numPreco = numPreco;
		this.numCamas = numCamas;
		this.numQuartos = numQuartos;
		this.numBanheiros = numBanheiros;
		this.nomeImovel = nomeImovel;
		this.nomeCidade = nomeCidade;
		this.andar = andar;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Boolean limpaFormulario = true;

		try {
			fachada.cadastraApartamento(nomeCidade.getText(), nomeImovel.getText(),
					Integer.parseInt(numBanheiros.getText()), Integer.parseInt(numCamas.getText()),
					Integer.parseInt(numQuartos.getText()), Double.parseDouble(numPreco.getText()), andar.getText());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcecaoImovelExistente e) {
			JOptionPane.showMessageDialog(null, "Este imovel ja existe");
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
		andar.setText("");
	}

}

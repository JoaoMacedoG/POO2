package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excecoes.ImovelNaoExiste;
import modelo.FachadaAIRBNB;

public class TratadorBotaoAvaliarImovel implements ActionListener {

	private FachadaAIRBNB fachada;
	JTextField nomeImovel, notaImovel;
	BotaoAvaliarImovel formulario;

	public TratadorBotaoAvaliarImovel(JTextField nomeImovel, JTextField notaImovel, BotaoAvaliarImovel formulario,
			FachadaAIRBNB fachada) {
		this.fachada = fachada;
		this.nomeImovel = nomeImovel;
		this.notaImovel = notaImovel;
		this.formulario = formulario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Boolean limpaFormulario = true;

		try {
			fachada.getImovel(nomeImovel.getText()).avaliarImovel(Integer.parseInt(notaImovel.getText()));
		} catch (NumberFormatException e1) {

			e1.printStackTrace();
		} catch (ImovelNaoExiste e1) {
			JOptionPane.showMessageDialog(null, "Imovel não existe");
			e1.printStackTrace();
		}
		if (limpaFormulario) {
			limpaDados();
		}
		this.formulario.dispose();
	}

	private void limpaDados() {
		nomeImovel.setText("");
		notaImovel.setText("");

	}
}

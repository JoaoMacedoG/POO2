package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import excecoes.ExcecaoPessoaExistente;
import modelo.FachadaAIRBNB;

public class TratadorBotaoOKCadastroPessoa implements ActionListener {

	JRadioButton radFem, radMasc;
	JTextField texNome, texCPF;
	FormularioCadastroPessoa formularioCadastroPessoa;
	private FachadaAIRBNB fachada;

	public TratadorBotaoOKCadastroPessoa(JRadioButton radFem, JRadioButton radMasc, JTextField texNome,
			JTextField texCPF, FormularioCadastroPessoa formularioCadastroPessoa, FachadaAIRBNB fachada) {
		this.fachada = fachada;
		this.radFem = radFem;
		this.radMasc = radMasc;
		this.texCPF = texCPF;
		this.texNome = texNome;
		this.formularioCadastroPessoa = formularioCadastroPessoa;

	}

	@Override
	public void actionPerformed(ActionEvent acesso) {
		String sexoPessoa = "";
		String frase = "";
		Boolean limpaFormulario = true;

		if (radFem.isSelected())
			sexoPessoa = "Feminino";
		if (radMasc.isSelected())
			sexoPessoa = "Masculino";

		frase = "Nome = '" + texNome.getText() + "'\n" + "Sexo = '" + sexoPessoa + "'\n" + "CPF  = '" + texCPF.getText()
				+ "'\n";
		try {
			fachada.cadastraPessoa(texNome.getText(), sexoPessoa, Integer.parseInt(texCPF.getText()));
			System.out.println(fachada.getPessoa(Integer.parseInt(texCPF.getText())).getCpf());
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (ExcecaoPessoaExistente e) {
			JOptionPane.showMessageDialog(null, "Esta pessoa já está cadastrada");
			e.printStackTrace();
		}

		JOptionPane.showMessageDialog(null, frase, "Atenção", 1);

		if (limpaFormulario) {
			limpaDados();
		}

		texNome.grabFocus();

		this.formularioCadastroPessoa.dispose();
	}

	private void limpaDados() {
		texNome.setText("");
		texCPF.setText("");
		radMasc.setSelected(true);

	}

}

package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import modelo.FachadaAIRBNB;

public class FormularioCadastroPessoa extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	// Variáveis
	private FachadaAIRBNB fachada;
	private JLabel lblNome, lblSex, lblCPF;
	private JTextField texNome, texCPF;
	private ButtonGroup gruSex;
	private JRadioButton radMasc, radFem;

	private JButton btnGrav;

	public FormularioCadastroPessoa(FachadaAIRBNB fachada) {
		setLayout(null);
		this.fachada = fachada;

		// Label Nome
		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 35, 100, 20);
		add(lblNome);

		// Text Nome
		texNome = new JTextField("");
		texNome.setBounds(10, 65, 300, 20);
		add(texNome);

		// Label Sexo
		lblSex = new JLabel("Sexo: ");
		lblSex.setBounds(10, 95, 100, 20);
		add(lblSex);

		// Radio Masculino
		radMasc = new JRadioButton("Masculino");
		radMasc.setBounds(10, 125, 120, 20);
		radMasc.setForeground(Color.BLUE);
		radMasc.setBackground(Color.WHITE);
		radMasc.setSelected(true);

		// Radio Feminino
		radFem = new JRadioButton("Feminino");
		radFem.setBounds(200, 125, 120, 20);
		radFem.setForeground(Color.BLUE);
		radFem.setBackground(Color.WHITE);

		// Grupo de Botões
		gruSex = new ButtonGroup();
		gruSex.add(radMasc);
		gruSex.add(radFem);
		add(radMasc);
		add(radFem);

		// Label CPF
		lblCPF = new JLabel("CPF: ");
		lblCPF.setBounds(10, 215, 100, 20);
		add(lblCPF);

		texCPF = new JTextField("");
		texCPF.setBounds(10, 245, 300, 20);
		add(texCPF);

		// Botão Ok
		btnGrav = new JButton("Ok");
		btnGrav.setBounds(110, 385, 120, 40);
		btnGrav.setMnemonic('O');
		btnGrav.setToolTipText("Ok...");
		btnGrav.setForeground(Color.RED);
		btnGrav.addActionListener(new TratadorBotaoOKCadastroPessoa(radFem, radMasc, texNome, texCPF, this, fachada));
		add(btnGrav);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FormularioCadastroPessoa ex = new FormularioCadastroPessoa(fachada);

		ex.getContentPane().setBackground(Color.WHITE);
		ex.setTitle("CADASTRO");
		ex.setResizable(false);
		ex.setSize(350, 480);
		ex.setVisible(true);
		ex.setLocationRelativeTo(null);
		dispose();
	}

}

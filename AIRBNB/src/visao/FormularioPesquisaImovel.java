package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;

import modelo.FachadaAIRBNB;

public class FormularioPesquisaImovel extends JFrame implements ActionListener {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	// Vari�veis

	private FachadaAIRBNB fachada;
	private JLabel lblPrecoMinimo, lblPrecoM�ximo, lblNumeroQuartos, lblNumeroBanheiros, lblNumeroCamas, lblCidade;
	private JTextField texPrecoMinimo, texNumeroPrecoM�ximo, texNumeroCamas, texNumeroBanheiros, texCidade,
			texNumeroQuartos;
	private JButton btnGrav;

	public FormularioPesquisaImovel(FachadaAIRBNB fachada) {
		this.fachada = fachada;
		setLayout(null);

		// Label Pre�o Minimo
		lblPrecoMinimo = new JLabel("Pre�o Minimo: ");
		lblPrecoMinimo.setBounds(10, 0, 100, 30);
		add(lblPrecoMinimo);

		// Text Pre�o Minimo
		texPrecoMinimo = new JTextField("");
		texPrecoMinimo.setBounds(10, 30, 300, 20);
		add(texPrecoMinimo);

		// Label Preco M�ximo
		lblPrecoM�ximo = new JLabel("Pre�o M�ximo: ");
		lblPrecoM�ximo.setBounds(10, 60, 100, 20);
		add(lblPrecoM�ximo);

		// Text Preco M�ximo
		texNumeroPrecoM�ximo = new JTextField("");
		texNumeroPrecoM�ximo.setBounds(10, 90, 300, 20);
		add(texNumeroPrecoM�ximo);

		// Label Banheiros
		lblNumeroBanheiros = new JLabel("Numero Quartos: ");
		lblNumeroBanheiros.setBounds(10, 120, 150, 30);
		add(lblNumeroBanheiros);

		// Text Banheiros
		texNumeroBanheiros = new JTextField("");
		texNumeroBanheiros.setBounds(10, 150, 300, 20);
		add(texNumeroBanheiros);

		// Label Quartos
		lblNumeroQuartos = new JLabel("Numero Banheiros: ");
		lblNumeroQuartos.setBounds(10, 180, 150, 30);
		add(lblNumeroQuartos);

		// Text Quartos
		texNumeroQuartos = new JTextField("");
		texNumeroQuartos.setBounds(10, 210, 300, 20);
		add(texNumeroQuartos);

		// Label Camas
		lblNumeroCamas = new JLabel("Numero Camas: ");
		lblNumeroCamas.setBounds(10, 240, 150, 30);
		add(lblNumeroCamas);

		// Text Camas
		texNumeroCamas = new JTextField("");
		texNumeroCamas.setBounds(10, 270, 300, 20);
		add(texNumeroCamas);

		// Label Cidade
		lblCidade = new JLabel("Cidade: ");
		lblCidade.setBounds(10, 300, 150, 30);
		add(lblCidade);

		// Text cidade
		texCidade = new JTextField();
		texCidade.setBounds(10, 330, 300, 20);
		add(texCidade);

		// Bot�o Ok
		btnGrav = new JButton("Ok");
		btnGrav.setBounds(110, 365, 120, 40);
		btnGrav.setMnemonic('O');
		btnGrav.setToolTipText("Ok...");
		btnGrav.setForeground(Color.RED);
		btnGrav.addActionListener(new TratadorBotaoPesquisaImovel(texPrecoMinimo, texNumeroPrecoM�ximo,
				texNumeroBanheiros, texNumeroQuartos, texNumeroCamas, texCidade, this, fachada));
		add(btnGrav);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FormularioPesquisaImovel ex = new FormularioPesquisaImovel(fachada);

		ex.getContentPane().setBackground(Color.WHITE);
		ex.setTitle("Pesquisa");
		ex.setResizable(false);
		ex.setSize(350, 480);
		ex.setVisible(true);
		ex.setLocationRelativeTo(null);
		dispose();
	}

}

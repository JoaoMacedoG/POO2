package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;

import modelo.FachadaAIRBNB;

public class FormularioReservarImovel extends JFrame implements ActionListener {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	// Variáveis

	private FachadaAIRBNB fachada;
	private JLabel dataDeEntrada, dataDeSaida, lblMes, lblImovel, lblCidade, lblCpf, lblCadastro;
	private JTextField numDataDeEntrada, numDataDeSaida, numMes, imovel, cidade, cpf;
	private JButton btnGrav, btnCadastro;

	public FormularioReservarImovel(FachadaAIRBNB fachada) {
		this.fachada = fachada;
		setLayout(null);

		// Data de Entrada
		dataDeEntrada = new JLabel("Data de Entrada: ");
		dataDeEntrada.setBounds(10, 0, 100, 30);
		add(dataDeEntrada);

		numDataDeEntrada = new JTextField("");
		numDataDeEntrada.setBounds(10, 30, 300, 20);
		add(numDataDeEntrada);

		// Data de Saida
		dataDeSaida = new JLabel("Data de Saida: ");
		dataDeSaida.setBounds(10, 60, 100, 20);
		add(dataDeSaida);

		numDataDeSaida = new JTextField("");
		numDataDeSaida.setBounds(10, 90, 300, 20);
		add(numDataDeSaida);

		// Mes
		lblMes = new JLabel("Mes: ");
		lblMes.setBounds(10, 180, 150, 30);
		add(lblMes);

		numMes = new JTextField("");
		numMes.setBounds(10, 210, 300, 20);
		add(numMes);

		// Imovel escolhido
		lblImovel = new JLabel("Imovel escolhido: ");
		lblImovel.setBounds(10, 120, 120, 30);
		add(lblImovel);

		imovel = new JTextField("");
		imovel.setBounds(10, 150, 300, 20);
		add(imovel);

		// Cidade
		lblCidade = new JLabel("Cidade do imovel: ");
		lblCidade.setBounds(10, 240, 150, 30);
		add(lblCidade);

		cidade = new JTextField("");
		cidade.setBounds(10, 270, 300, 20);
		add(cidade);

		// Cpf
		lblCpf = new JLabel("Digite seu CPF: ");
		lblCpf.setBounds(10, 300, 150, 30);
		add(lblCpf);

		// Text cidade
		cpf = new JTextField();
		cpf.setBounds(10, 330, 300, 20);
		add(cpf);

		// Botão Ok
		btnGrav = new JButton("Ok");
		btnGrav.setBounds(90, 365, 120, 40);
		btnGrav.setMnemonic('O');
		btnGrav.setToolTipText("Ok...");
		btnGrav.setForeground(Color.RED);
		btnGrav.addActionListener(new TratadorReservaImovel(numDataDeEntrada, numDataDeSaida, numMes, imovel, cidade,
				cpf, this, fachada));
		add(btnGrav);

		// lbl Cadastro
		lblCadastro = new JLabel("Não é cadastrado? ");
		lblCadastro.setBounds(220, 400, 120, 20);
		add(lblCadastro);
		// Botao Cadasttro
		btnCadastro = new JButton("Cadastre-se");
		btnCadastro.setBounds(220, 420, 120, 20);
		btnCadastro.addActionListener(new FormularioCadastroPessoa(fachada));
		add(btnCadastro);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FormularioReservarImovel ex = new FormularioReservarImovel(fachada);

		ex.getContentPane().setBackground(Color.WHITE);
		ex.setTitle("Reserve");
		ex.setResizable(false);
		ex.setSize(350, 480);
		ex.setVisible(true);
		ex.setLocationRelativeTo(null);
		dispose();
	}
}

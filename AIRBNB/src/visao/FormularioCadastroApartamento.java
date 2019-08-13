package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.FachadaAIRBNB;

public class FormularioCadastroApartamento extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private FachadaAIRBNB fachada;
	private JLabel lblNomeCidade, lblAndar, lblNomeImovel, lblNumBanheiros, lblNumQuartos, lblNumCamas, lblNumPreco;
	private JTextField nomeCidade, andar, nomeImovel, numBanheiros, numQuartos, numCamas, numPreco;

	private JButton btnGrav;

	public FormularioCadastroApartamento(FachadaAIRBNB fachada) {
		this.fachada = fachada;

		setLayout(null);
		// NomeCidade
		lblNomeCidade = new JLabel("Cidade do Imovel: ");
		lblNomeCidade.setBounds(10, 0, 150, 20);
		add(lblNomeCidade);

		nomeCidade = new JTextField("");
		nomeCidade.setBounds(10, 30, 300, 20);
		add(nomeCidade);

		// Nome Imovel
		lblNomeImovel = new JLabel("Nome do Imovel: ");
		lblNomeImovel.setBounds(10, 60, 150, 20);
		add(lblNomeImovel);

		nomeImovel = new JTextField("");
		nomeImovel.setBounds(10, 90, 300, 20);
		add(nomeImovel);

		// numBanheiros
		lblNumBanheiros = new JLabel("Numero de banheiros: ");
		lblNumBanheiros.setBounds(10, 120, 150, 20);
		add(lblNumBanheiros);

		numBanheiros = new JTextField("");
		numBanheiros.setBounds(10, 150, 300, 20);
		add(numBanheiros);

		// numQuartos
		lblNumQuartos = new JLabel("Numero de quartos ");
		lblNumQuartos.setBounds(10, 180, 150, 20);
		add(lblNumQuartos);

		numQuartos = new JTextField("");
		numQuartos.setBounds(10, 210, 300, 20);
		add(numQuartos);

		// numCamas
		lblNumCamas = new JLabel("Numero de camas: ");
		lblNumCamas.setBounds(10, 240, 150, 20);
		add(lblNumCamas);

		numCamas = new JTextField("");
		numCamas.setBounds(10, 270, 300, 20);
		add(numCamas);

		// numPreco
		lblNumPreco = new JLabel("Preço: ");
		lblNumPreco.setBounds(10, 300, 150, 20);
		add(lblNumPreco);

		numPreco = new JTextField("");
		numPreco.setBounds(10, 330, 300, 20);
		add(numPreco);

		// Andar
		lblAndar = new JLabel("Andar: ");
		lblAndar.setBounds(10, 360, 150, 20);
		add(lblAndar);

		andar = new JTextField("");
		andar.setBounds(10, 390, 300, 20);
		add(andar);

		// Botão Ok
		btnGrav = new JButton("Ok");
		btnGrav.setBounds(110, 415, 70, 20);
		btnGrav.setMnemonic('O');
		btnGrav.setToolTipText("Ok...");
		btnGrav.setForeground(Color.RED);
		btnGrav.addActionListener(new TratadorBotaoCadastraApartamento(nomeCidade, nomeImovel, numBanheiros, numQuartos,
				numCamas, numPreco, andar, this, fachada));
		add(btnGrav);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FormularioCadastroApartamento ex = new FormularioCadastroApartamento(fachada);

		ex.getContentPane().setBackground(Color.WHITE);
		ex.setTitle("CADASTRO");
		ex.setResizable(false);
		ex.setSize(350, 480);
		ex.setVisible(true);
		ex.setLocationRelativeTo(null);
		dispose();
	}

}

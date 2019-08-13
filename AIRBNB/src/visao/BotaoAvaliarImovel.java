package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.FachadaAIRBNB;

public class BotaoAvaliarImovel extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private FachadaAIRBNB fachada;
	private JLabel lblNomeImovel, lblNotaImovel;
	private JTextField nomeImovel, notaImovel;

	private JButton btnGrav;

	public BotaoAvaliarImovel(FachadaAIRBNB fachada) {
		this.fachada = fachada;

		setLayout(null);
		// NomeCidade
		lblNomeImovel = new JLabel("Nome do Imovel: ");
		lblNomeImovel.setBounds(10, 0, 150, 20);
		add(lblNomeImovel);

		nomeImovel = new JTextField("");
		nomeImovel.setBounds(10, 30, 100, 20);
		add(nomeImovel);

		// Nota Imovel
		lblNotaImovel = new JLabel("Nota: ");
		lblNotaImovel.setBounds(10, 60, 150, 20);
		add(lblNotaImovel);

		notaImovel = new JTextField("");
		notaImovel.setBounds(10, 90, 100, 20);
		add(notaImovel);

		// Botão Ok
		btnGrav = new JButton("Ok");
		btnGrav.setBounds(10, 120, 120, 40);
		btnGrav.setMnemonic('O');
		btnGrav.setToolTipText("Ok...");
		btnGrav.setForeground(Color.RED);
		btnGrav.addActionListener(new TratadorBotaoAvaliarImovel(nomeImovel, notaImovel, this, fachada));
		add(btnGrav);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BotaoAvaliarImovel ex = new BotaoAvaliarImovel(fachada);

		ex.getContentPane().setBackground(Color.WHITE);
		ex.setTitle("Avalie");
		ex.setResizable(false);
		ex.setSize(250, 300);
		ex.setVisible(true);
		ex.setLocationRelativeTo(null);
		dispose();
	}

}

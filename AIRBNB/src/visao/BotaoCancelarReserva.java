package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.FachadaAIRBNB;

public class BotaoCancelarReserva extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private FachadaAIRBNB fachada;
	private JLabel lblIdReserva;
	private JTextField idReserva;

	private JButton btnGrav;

	public BotaoCancelarReserva(FachadaAIRBNB fachada) {
		this.fachada = fachada;

		setLayout(null);
		// Id reserva
		lblIdReserva = new JLabel("Digite o seu cpf: ");
		lblIdReserva.setBounds(10, 0, 150, 20);
		add(lblIdReserva);

		idReserva = new JTextField("");
		idReserva.setBounds(10, 30, 100, 20);
		add(idReserva);

		// Botão Ok
		btnGrav = new JButton("Ok");
		btnGrav.setBounds(10, 70, 120, 40);
		btnGrav.setMnemonic('O');
		btnGrav.setToolTipText("Ok...");
		btnGrav.setForeground(Color.RED);
		btnGrav.addActionListener(new TratadorBotaoCancelarReserva(idReserva, this, fachada));
		add(btnGrav);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BotaoCancelarReserva ex = new BotaoCancelarReserva(fachada);

		ex.getContentPane().setBackground(Color.WHITE);
		ex.setTitle("Avalie");
		ex.setResizable(false);
		ex.setSize(250, 300);
		ex.setVisible(true);
		ex.setLocationRelativeTo(null);
		dispose();
	}

}

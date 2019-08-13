package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excecoes.ReservaNaoExistente;
import modelo.FachadaAIRBNB;

public class TratadorBotaoCancelarReserva implements ActionListener {

	private FachadaAIRBNB fachada;
	JTextField idReserva;
	BotaoCancelarReserva formulario;

	public TratadorBotaoCancelarReserva(JTextField nomeImovel, BotaoCancelarReserva formulario, FachadaAIRBNB fachada) {
		this.fachada = fachada;
		this.idReserva = nomeImovel;
		this.formulario = formulario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Boolean limpaFormulario = true;

		try {
			fachada.cancelarReserva(Integer.parseInt(idReserva.getText()));
		} catch (NumberFormatException e1) {
			
			
		} catch (ReservaNaoExistente e1) {
			JOptionPane.showMessageDialog(null, "reserva n existe");
		}

		if (limpaFormulario) {
			limpaDados();
		}
		this.formulario.dispose();
	}

	private void limpaDados() {
		idReserva.setText("");

	}
}

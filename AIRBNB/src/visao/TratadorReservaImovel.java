package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excecoes.ImovelJaReservado;
import excecoes.ImovelNaoExiste;
import modelo.FachadaAIRBNB;
import modelo.Reserva;

public class TratadorReservaImovel implements ActionListener {
	private FachadaAIRBNB fachada;
	JTextField numDataDeEntrada, numDataDeSaida, numMes, imovel, cidade, cpf;
	FormularioReservarImovel formulario;

	public TratadorReservaImovel(JTextField numDataDeEntrada, JTextField numDataDeSaida, JTextField numMes,
			JTextField imovel, JTextField cidade, JTextField cpf, FormularioReservarImovel formulario,
			FachadaAIRBNB fachada) {
		this.cidade = cidade;
		this.cpf = cpf;
		this.imovel = imovel;
		this.numMes = numMes;
		this.numDataDeSaida = numDataDeSaida;
		this.numDataDeEntrada = numDataDeEntrada;
		this.formulario = formulario;
		this.fachada = fachada;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Boolean limpaFormulario = true;
		Reserva reserva = new Reserva(Integer.parseInt(numDataDeEntrada.getText()),
				Integer.parseInt(numDataDeSaida.getText()), Integer.parseInt(numMes.getText()),
				fachada.getImovel(imovel.getText()), fachada.getCidade(cidade.getText()),
				fachada.getPessoa(Integer.parseInt(cpf.getText())));

		try {
			fachada.reservarImovel(reserva);
			JOptionPane.showMessageDialog(null,"Reserva feita");
					
		} catch (ImovelNaoExiste e1) {
			JOptionPane.showMessageDialog(null,"Este imovel não existe");
	
		} catch (ImovelJaReservado e1) {
			JOptionPane.showMessageDialog(null, "Imovel já reservado, tente outra data");
		
		}

		if (limpaFormulario) {
			limpaDados();
		}
		this.formulario.dispose();

	}

	private void limpaDados() {
		numDataDeSaida.setText("");
		numDataDeEntrada.setText("");
		numMes.setText("");
		imovel.setText("");
		cpf.setText("");
		cidade.setText("");

	}

}

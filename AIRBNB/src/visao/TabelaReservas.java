package visao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.FachadaAIRBNB;
import modelo.Reserva;

public class TabelaReservas extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FachadaAIRBNB fachada;

	public TabelaReservas(FachadaAIRBNB fachada) {
		this.fachada = fachada;
	}

	public JTable tabela() {

		JTable tabela = new JTable();

		List<Reserva> reservas = fachada.getReservas();
		String tabelaImoveis[][] = new String[reservas.size()][7];
		for (int conti = 0; conti < reservas.size(); conti++) {
			tabelaImoveis[conti][0] = reservas.get(conti).getCidade().getNomeCidade();
			tabelaImoveis[conti][1] = reservas.get(conti).getImovelEscolhido().getNomeImovel();
			tabelaImoveis[conti][2] = "" + reservas.get(conti).getMes();
			tabelaImoveis[conti][3] = "" + reservas.get(conti).getDataDeInicio();
			tabelaImoveis[conti][4] = "" + reservas.get(conti).getDataDeSaida();
			tabelaImoveis[conti][5] = reservas.get(conti).getPessoa().getNome();
			tabelaImoveis[conti][6] = "" + reservas.get(conti).getIdReserva();

		}
		tabela.setModel(new DefaultTableModel(tabelaImoveis, new String[] { "Cidade", "Imovel escolhido", "Mes",
				"Data de entrada", "Data de saída", "Nome da Pessoa", "Id da reserva" }));

		return tabela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame Jtabela = new JFrame("Tabela Reservas");
		Jtabela.setLayout(new BorderLayout());

		JScrollPane scrollPane = new JScrollPane();

		Jtabela.getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(tabela());
		Jtabela.setSize(900, 400);
		Jtabela.setVisible(true);
		Jtabela.setLocationRelativeTo(null);

	}

}

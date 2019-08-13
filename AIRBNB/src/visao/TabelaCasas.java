package visao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Casa;
import modelo.FachadaAIRBNB;

public class TabelaCasas extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private FachadaAIRBNB fachada;

	public TabelaCasas(FachadaAIRBNB fachada) {
		this.fachada = fachada;
	}

	public JTable tabela() {

		JTable tabela = new JTable();

		List<Casa> casas = fachada.getCasas();
		String tabelaImoveis[][] = new String[casas.size()][9];
		for (int conti = 0; conti < casas.size(); conti++) {
			tabelaImoveis[conti][0] = casas.get(conti).getNomeImovel();
			tabelaImoveis[conti][1] = casas.get(conti).getCidade().getNomeCidade();
			tabelaImoveis[conti][2] = "" + casas.get(conti).getNumeroBanheiros();
			tabelaImoveis[conti][3] = "" + casas.get(conti).getNumeroCamas();
			tabelaImoveis[conti][4] = "" + casas.get(conti).getNumeroQuartos();
			tabelaImoveis[conti][5] = "" + casas.get(conti).getPreco();
			tabelaImoveis[conti][6] = "" + casas.get(conti).getNotaDoImovel();
			tabelaImoveis[conti][7] = "" + casas.get(conti).getNumeroAvaliacoes();
			tabelaImoveis[conti][8] = "" + casas.get(conti).getJardim();
		}
		tabela.setModel(new DefaultTableModel(tabelaImoveis, new String[] { "Nome do imovel", "Cidade", "Banheiros",
				"Camas", "Quartos", "Preço", "Nota do imovel", "Numero Avaliaçoes", "Jardim" }));

		return tabela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame Jtabela = new JFrame("Tabela Casas");
		Jtabela.setLayout(new BorderLayout());

		JScrollPane scrollPane = new JScrollPane();

		Jtabela.getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(tabela());
		Jtabela.setSize(900, 400);
		Jtabela.setVisible(true);
		Jtabela.setLocationRelativeTo(null);

	}

}

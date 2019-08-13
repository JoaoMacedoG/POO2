
package visao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Apartamento;
import modelo.FachadaAIRBNB;

public class TabelaApartamentos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private FachadaAIRBNB fachada;

	public TabelaApartamentos(FachadaAIRBNB fachada) {
		this.fachada = fachada;
	}

	public JTable tabela() {

		JTable tabela = new JTable();

		List<Apartamento> apartamentos = fachada.getApartamentos();
		String tabelaImoveis[][] = new String[apartamentos.size()][9];
		for (int conti = 0; conti < apartamentos.size(); conti++) {
			tabelaImoveis[conti][0] = apartamentos.get(conti).getNomeImovel();
			tabelaImoveis[conti][1] = apartamentos.get(conti).getCidade().getNomeCidade();
			tabelaImoveis[conti][2] = "" + apartamentos.get(conti).getNumeroBanheiros();
			tabelaImoveis[conti][3] = "" + apartamentos.get(conti).getNumeroCamas();
			tabelaImoveis[conti][4] = "" + apartamentos.get(conti).getNumeroQuartos();
			tabelaImoveis[conti][5] = "" + apartamentos.get(conti).getPreco();
			tabelaImoveis[conti][6] = "" + apartamentos.get(conti).getNotaDoImovel();
			tabelaImoveis[conti][7] = "" + apartamentos.get(conti).getNumeroAvaliacoes();
			tabelaImoveis[conti][8] = apartamentos.get(conti).getAndar();
		}
		tabela.setModel(new DefaultTableModel(tabelaImoveis, new String[] { "Nome do imovel", "Cidade", "Banheiros",
				"Camas", "Quartos", "Preço", "Nota do imovel", "Numero Avaliaçoes", "Andar" }));

		return tabela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame Jtabela = new JFrame("Tabela Apartamentos");
		Jtabela.setLayout(new BorderLayout());

		JScrollPane scrollPane = new JScrollPane();

		Jtabela.getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(tabela());
		Jtabela.setSize(900, 400);
		Jtabela.setVisible(true);
		Jtabela.setLocationRelativeTo(null);

	}

}

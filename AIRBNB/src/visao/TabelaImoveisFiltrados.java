package visao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Imovel;

public class TabelaImoveisFiltrados extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Imovel> imoveisFiltrados;
	JScrollPane scrollPane;

	public TabelaImoveisFiltrados(List<Imovel> imoveisFiltrados) {
		this.imoveisFiltrados = imoveisFiltrados;
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		tabela();
		setSize(900, 400);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void tabela() {

		JTable tabela = new JTable();

		String tabelaImoveis[][] = new String[imoveisFiltrados.size()][8];
		for (int conti = 0; conti < imoveisFiltrados.size(); conti++) {
			tabelaImoveis[conti][0] = imoveisFiltrados.get(conti).getNomeImovel();
			tabelaImoveis[conti][1] = imoveisFiltrados.get(conti).getCidade().getNomeCidade();
			tabelaImoveis[conti][2] = "" + imoveisFiltrados.get(conti).getNumeroBanheiros();
			tabelaImoveis[conti][3] = "" + imoveisFiltrados.get(conti).getNumeroCamas();
			tabelaImoveis[conti][4] = "" + imoveisFiltrados.get(conti).getNumeroQuartos();
			tabelaImoveis[conti][5] = "" + imoveisFiltrados.get(conti).getPreco();
			tabelaImoveis[conti][6] = "" + imoveisFiltrados.get(conti).getNotaDoImovel();
			tabelaImoveis[conti][7] = "" + imoveisFiltrados.get(conti).getNumeroAvaliacoes();
		}
		tabela.setModel(new DefaultTableModel(tabelaImoveis, new String[] { "Nome do imovel", "Cidade", "Banheiros",
				"Camas", "Quartos", "Preço", "Nota do imovel", "Numero Avaliaçoes" }));

		scrollPane.setViewportView(tabela);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}

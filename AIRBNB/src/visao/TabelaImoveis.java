package visao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.FachadaAIRBNB;
import modelo.Imovel;

public class TabelaImoveis extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FachadaAIRBNB fachada;

	public TabelaImoveis(FachadaAIRBNB fachada) {
		this.fachada = fachada;
	}

	public JTable tabela() {

		JTable tabela = new JTable();

		List<Imovel> imoveis = fachada.getTodosImoveis();
		String tabelaImoveis[][] = new String[imoveis.size()][8];
		for (int conti = 0; conti < imoveis.size(); conti++) {
			tabelaImoveis[conti][0] = imoveis.get(conti).getNomeImovel();
			tabelaImoveis[conti][1] = imoveis.get(conti).getCidade().getNomeCidade();
			tabelaImoveis[conti][2] = "" + imoveis.get(conti).getNumeroBanheiros();
			tabelaImoveis[conti][3] = "" + imoveis.get(conti).getNumeroCamas();
			tabelaImoveis[conti][4] = "" + imoveis.get(conti).getNumeroQuartos();
			tabelaImoveis[conti][5] = "" + imoveis.get(conti).getPreco();
			tabelaImoveis[conti][6] = "" + imoveis.get(conti).getNotaDoImovel();
			tabelaImoveis[conti][7] = "" + imoveis.get(conti).getNumeroAvaliacoes();
		}
		tabela.setModel(new DefaultTableModel(tabelaImoveis, new String[] { "Nome do imovel", "Cidade", "Banheiros",
				"Camas", "Quartos", "Preço", "Nota do imovel", "Numero Avaliaçoes" }));

		return tabela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame Jtabela = new JFrame("Tabela Imoveis");
		Jtabela.setLayout(new BorderLayout());

		JButton avaliarImovel = new JButton("Avaliar Imovel");

		Jtabela.add(avaliarImovel, BorderLayout.SOUTH);
		avaliarImovel.addActionListener(new BotaoAvaliarImovel(fachada));

		JScrollPane scrollPane = new JScrollPane();

		Jtabela.getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(tabela());
		Jtabela.setSize(900, 400);
		Jtabela.setVisible(true);
		Jtabela.setLocationRelativeTo(null);

	}

}

package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import modelo.FachadaAIRBNB;
import modelo.Serializa;

public class GUI {
	private static final String nomeArquivo = "resources/arquivossss";
	private static FachadaAIRBNB fachada;
	private static Serializa serializa;
	static JFrame formulario;

	public static void main(String[] args) throws IOException, Exception {

		serializa = new Serializa();
		
		try {
			fachada = serializa.carregaFachada(nomeArquivo);
			JFrame.setDefaultLookAndFeelDecorated(true);
					
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (fachada == null) {
			fachada = FachadaAIRBNB.getInstance();
		}

		new GUI();

	}

	public GUI() {

		criaGUI();
	}

	public static JMenuBar criaMenu() {

		JMenuBar barraMenu;
		JMenu menu;
		JMenuItem menuItemCadastra, menuItemVerTabela, menuItem;
		JMenu submenu;

		barraMenu = new JMenuBar();

		menu = new JMenu("Imoveis");

		barraMenu.add(menu);

		submenu = new JMenu("Ver imoveis");
		menuItemVerTabela = new JMenuItem("Todos Imoveis");
		submenu.add(menuItemVerTabela);
		menuItemVerTabela.addActionListener(new TabelaImoveis(fachada));

		menu.add(submenu);

		menuItemVerTabela = new JMenuItem("Casas");
		submenu.add(menuItemVerTabela);
		menuItemVerTabela.addActionListener(new TabelaCasas(fachada));

		menu.add(submenu);

		menuItemVerTabela = new JMenuItem("Apartamentos");
		submenu.add(menuItemVerTabela);
		menuItemVerTabela.addActionListener(new TabelaApartamentos(fachada));

		menu.add(submenu);

		menu.addSeparator();

		submenu = new JMenu("Cadastra Imovel");
		menuItemCadastra = new JMenuItem("Casa");
		submenu.add(menuItemCadastra);
		menuItemCadastra.addActionListener(new FormularioCadastroCasa(fachada));

		menu.add(submenu);

		menuItemCadastra = new JMenuItem("Apartamento");
		submenu.add(menuItemCadastra);
		menuItemCadastra.addActionListener(new FormularioCadastroApartamento(fachada));

		menu.add(submenu);

		menu.addSeparator();

		menuItemCadastra = new JMenuItem("Pesquisa Imovel");
		menuItemCadastra.addActionListener(new FormularioPesquisaImovel(fachada));

		menu.add(menuItemCadastra);

		menu.addSeparator();

		submenu = new JMenu("Reservas");

		menuItemCadastra = new JMenuItem("Reservar Imovel");
		submenu.add(menuItemCadastra);
		menuItemCadastra.addActionListener(new FormularioReservarImovel(fachada));

		menu.add(submenu);

		menuItemCadastra = new JMenuItem("Cancelar Reserva");
		submenu.add(menuItemCadastra);
		menuItemCadastra.addActionListener(new BotaoCancelarReserva(fachada));

		menuItemCadastra = new JMenuItem("Ver reservas");
		submenu.add(menuItemCadastra);
		menuItemCadastra.addActionListener(new TabelaReservas(fachada));

		menu.addSeparator();
		menuItemCadastra = new JMenuItem("Avaliar Imovel");
		menuItemCadastra.addActionListener(new BotaoAvaliarImovel(fachada));

		menu.add(menuItemCadastra);

		menu = new JMenu("Cadastro");
		barraMenu.add(menu);

		menuItem = new JMenuItem("Cadastre-se");
		menuItem.addActionListener(new FormularioCadastroPessoa(fachada));

		menu.add(menuItem);

		menu = new JMenu("Sair");
		menuItem = new JMenuItem("Sair");
		menu.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					serializa.salvaFachada(fachada, nomeArquivo);
					formulario.dispose();
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		});

		barraMenu.add(menu);

		return barraMenu;

	}

	// Cria GUI
	public void criaGUI() {
		// Cria formulario e suas propriedades

		formulario = new JFrame("AIR BNB");
		formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		formulario.setJMenuBar(criaMenu());

		// Adiciona propriedades ao formulario
		formulario.setSize(600, 300);
		formulario.setVisible(true);
		formulario.setLocationRelativeTo(null);

	}

}

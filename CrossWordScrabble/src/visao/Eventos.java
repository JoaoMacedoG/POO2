package visao;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excecoes.ExcecaoPalavraInexistente;
import modelo.Crossword;
import modelo.Letra;
import modelo.Tabuleiro;
import modelo.Estrategias.EstrategiaJogoDificil;
import modelo.Estrategias.EstrategiaJogoFacil;
import modelo.Estrategias.FabricaMostraListaDeLetrasParaJogador;
import visao.IU;
import modelo.Crossword;
import modelo.Letra;

public class Eventos extends JFrame implements ActionListener {

	private JButton botaoSair;
	private JButton botaoAddPalavra;
	private JButton botaoVerJogo;
	private JButton botaoIniciar;
	private static  int tipo;
	private static Crossword crossword = new Crossword();
	
	
	
	public Eventos(){
		super("Eventos");
					
		Container c= getContentPane();
		Container c2= new JPanel();
		
		this.botaoAddPalavra = new JButton ("Adicionar Palavra");
		this.botaoVerJogo = new JButton ("Ver Tabela e Letras");
		this.botaoSair = new JButton ("Sair");
		this.botaoIniciar = new JButton("Iniciar");
		c2.setLayout(new GridLayout(3,1));
		c2.add(botaoAddPalavra);
		c2.add(botaoVerJogo);
		c2.add(botaoSair);
		this.setLocation(500,200);
		
		botaoSair.addActionListener(this);
		botaoVerJogo.addActionListener(this);
		botaoAddPalavra.addActionListener(this);
		botaoIniciar.addActionListener(this);
		
	
	
		
		c.add(BorderLayout.CENTER,botaoIniciar);
		c.add(BorderLayout.EAST,c2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Eventos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			String palavraEscrita = "";
			int opcao = 0;
			List<Letra> listaLetras = new ArrayList<Letra>();
			listaLetras =crossword.getLetrasDisponiveis();
		if(e.getSource() == botaoIniciar){
			 this.tipo= IU.inputInt("Digite 1 para modo facil ou digite qualquer outro número para o "
					+ "modo dificil:");
			 		 	
			
				this.crossword.letrasDisponiveis(this.tipo);
				JOptionPane.showMessageDialog(null, this.crossword.retornaTabuleiro().retornaGrade() + 
						"\n As pecas disponivéis são: " + this.crossword.getLetrasDisponiveis());
		}			
	
		else if(e.getSource() == botaoVerJogo){
			System.out.println("Pontuacão: " + crossword.pontuacao());
			JOptionPane.showMessageDialog(null, crossword.retornaTabuleiro().retornaGrade() + 
					"\n As pecas disponivéis são: " + crossword.getLetrasDisponiveis());
		
			}
		else if(e.getSource()==botaoAddPalavra){
			listaLetras= crossword.getLetrasDisponiveis() ;
			palavraEscrita = IU.digitarMsg("Suas pecas sao: " + crossword.getLetrasDisponiveis()+ 
					"\nDigite as letras que serão adicionadas").toUpperCase();
				
			List<Letra> palavraDigitada =crossword.transformaPalvraDigitadaEmList(palavraEscrita);
			for (int conti = 0; conti < palavraDigitada.size(); conti++) {
				if((crossword.checarSeLetraExisteNasLetrasDisponiveis(palavraDigitada.get(conti))== false)) {
				
					IU.mensagemDeErro("Peça não disponivel");
				  break;
				    }
				
				  try {
					if(crossword.checarSeJogadaValida(palavraEscrita) == true){
						   	    
int linhaInicial = IU.inputInt("Em qual linha deseja comecar");
int colunaInicial = IU.inputInt("Em qual  coluna deseja comecar?");
int linhaFinal = IU.inputInt("Em qual linha deseja terminar");
int colunaFinal = IU.inputInt("Em qual  coluna deseja terminar?");
int direcao = IU.inputInt("Digite 1 para direcao horizontal ou 2 para vertical");

crossword.adicionarPalavra(palavraDigitada, linhaInicial,colunaInicial,linhaFinal,colunaFinal,direcao);
					  break;
					  }
				} catch (InputMismatchException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExcecaoPalavraInexistente e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  try {
					if(crossword.checarSeJogadaValida(palavraEscrita) == false){
						 crossword.subtrairPontos(palavraDigitada);
								  break;
						  }
				} catch (ExcecaoPalavraInexistente e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
				
		else if(e.getSource() == botaoSair){
			System.out.println("Pontuacão: " + crossword.pontuacao());
			JOptionPane.showMessageDialog(null, crossword.retornaTabuleiro().retornaGrade() + 
					"\n As pecas disponivéis são: " + crossword.getLetrasDisponiveis());
			dispose();

		}

}

	public static Crossword getCrossword() {
		return crossword;
	}

	
}



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
	

public class Janela  extends JFrame {
	private static final long serialVersionUID = 1L;
	 
	public Janela(){
		construir();
		//pack();
		//setVisible(Boolean.TRUE);
		
	}
	
	public void construir(){
		JPanel painelA = new JPanel(); 
		painelA.add(new JLabel("Painel A")); 
		painelA.setBackground(Color.BLUE); 
		JPanel painelB = new JPanel(); 
		painelB.add(new JLabel("Painel B")); 
		painelB.setBackground(Color.RED); 
		JPanel painelC = new JPanel(); 
		painelC.add(new JLabel("Painel C")); 
		painelC.setBackground(Color.GREEN); 
		JPanel painelD = new JPanel(); 
		painelD.add(new JLabel("Painel D")); 
		painelD.setBackground(Color.ORANGE); 
		
		JFrame janela = new JFrame("Título"); 
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		janela.add(painelA); 
		janela.add(painelB); 
		janela.add(painelC); 
		janela.add(painelD); 
		//LayoutManager layout= new  FlowLayout (FlowLayout.CENTER, 10, 10); 
		//GridLayout layout2 = new GridLayout(4, 2); 
		//janela.setLayout(layout); 
		BorderLayout layout = new BorderLayout(); 
		janela.getContentPane().setLayout(layout); 
		janela.add(painelA, BorderLayout.PAGE_START	); 
		janela.add(painelB, BorderLayout.LINE_START	); 
		janela.add(painelC, BorderLayout.LINE_END	); 
		janela.add(painelD, BorderLayout.PAGE_END); 
		// janela.add(painelE, BorderLayout.CENTER	); 
		janela.setSize(300, 300); 
		janela.setVisible(true); 
		janela.getContentPane().setLayout(layout); 
	
		janela.setSize(300, 300); 
		janela.setVisible(true); 
		
		
		
		/**JFrame janela = new JFrame("titulo"); 
				JButton botaoMostrarMensagem = new JButton ("mostrar");
				botaoMostrarMensagem.addActionListener(new 	TratadorDeCliqueDoMouse()); 
				janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
				janela.add(botaoMostrarMensagem); 
				janela.pack(); 
				janela.setVisible(true);**/
		
	}
	
	public static void main (String args[])
	 {
		new Janela();
	 
	}
		
	}



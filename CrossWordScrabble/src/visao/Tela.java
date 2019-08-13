package visao;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;

import javax.swing.JFrame;

public class Tela extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Tela() {
		
		LayoutManager mgr = new GridLayout(2, 2);
		getContentPane().setLayout(mgr);
		getContentPane().add(new Label("1 "));
		getContentPane().add(new Label(" 2"));
		getContentPane().add(new Label(" 3"));
		getContentPane().add(new Label(" 4"));
		
		
		setVisible(true);
		
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		new Tela();
		
	}

}

package modelo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import visao.TabelaImoveis;

public class TabelaImoveis implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FachadaAIRBNB fachada;
	
	
	
	 public TabelaImoveis(){
		   fachada =fachada.getInstance();
		   
		 setLayout(null);
		   for(int i= 0; i < fachada.tamanhoListImoveis(); i++){
			   
			   
			   
		   }
		    
		    
		    
	  }
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e)   {
		TabelaImoveis ex = new TabelaImoveis();
		    ex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    ex.getContentPane().setBackground(Color.WHITE);
		    ex.setTitle("Pesquisa");
		    //tira o maximizar e alteração do tamanho
		    ex.setResizable(false);
		    ex.setSize(500,200);
		    ex.setVisible(true);
		    ex.setLocationRelativeTo(null);
		    dispose();
	  }
	  
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

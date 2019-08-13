import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class TratadorDeCliqueDoMouse implements ActionListener{ 
	@Override
	public void actionPerformed(ActionEvent evento) { 
	JOptionPane.showMessageDialog(null, "O botão foi clicado :-)"); 
	} 

}

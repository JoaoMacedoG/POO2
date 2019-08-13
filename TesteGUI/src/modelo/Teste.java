package modelo;

import java.awt.event.*;
import javax.swing.*;

	public class Teste extends JFrame implements ActionListener
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel      texto       = new JLabel("Graus Celcius: ");
    JTextField  caixaTexto  = new JTextField("Fahrenheit");
    JButton     botao       = new JButton("Calcular");
    	
    	public Teste()
    {
        this.setSize(300,150);
        //define tamanho para janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Para de executar ao fechar o programa ^
        this.setLayout(null);
        //null Layout, permite colocar os componentes em qualquer lugar da janela
        caixaTexto.setBounds(10,10,250,20);
        //define as coordenadas da JTextField (posi��o X, posi��o Y, Largura, Altura)
        this.add(caixaTexto);
        //Adiciona o JLabel no JFrame
        botao.setBounds(100,40,90,20);
        //define as coordenadas do JButton (posi��o X, posi��o Y, Largura, Altura)
        botao.addActionListener(this);
        //Adiciona evento para este bot�o
        this.add(botao);
        //Adiciona o JButton no JFrame
        texto.setBounds(10, 70, 250, 20);
        //define as coordenadas da JLabel (posi��o X, posi��o Y, Largura, Altura)
        this.add(texto);
        //Adiciona o JLabel no JFrame
        this.setVisible(true);
        //Deixa a janela visivel
    }
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            // obt�m a entrada de usu�rio a partir da JTextField
            String firstNumber = caixaTexto.getText();
            // converte os valores recebido em string para double
            double number1 = (double)Double.parseDouble(firstNumber);
            //fas um cast para para um tipo primitivo
            // convers�o de guaus fahrenheit para graus celsius
            //double sum = 5/9*number1 - 32;
            double sum = (5.0/9.0)*(number1-32.0);
            //Cuidar os pontos, sen�o ele indentifica com int e deixa o resultado como ZERO
            //setar o resultado na JLabel
            //Concatenar com uma String, pois n�o pode-se colocar diretamente o valor int
            texto.setText("Graus Celcius:  " + sum + "�C");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Caracteres Inv�lidos no Campo JTextField");
            //Caso n�o for possivel converter o valor digirto, ele envia esta mensagem na tela
        }
    }}
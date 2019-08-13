package visao;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import modelo.Crossword;
import modelo.Grade;
import modelo.Letra;
import modelo.Tabuleiro;

public class IU {

    public static int inputInt(String msg) throws InputMismatchException {
	String input = JOptionPane.showInputDialog(msg);
	return Integer.parseInt(input);
    }

    public static String digitarMsg(String msg) throws InputMismatchException {
	String input = JOptionPane.showInputDialog(msg);
	return input;
    }

    public static void msg(String msg) {
	JOptionPane.showMessageDialog(null, msg);
    }

    public static void mensagemDeErro(String message) {
	JOptionPane.showMessageDialog(null, message, "Deu erro!", JOptionPane.ERROR_MESSAGE);
    }




}


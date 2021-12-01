package dt;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		
		String teclado = JOptionPane.showInputDialog("Informe uma data: ");
		
		Data d1 = new Data(teclado);

	}

}

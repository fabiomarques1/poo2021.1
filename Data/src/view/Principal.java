package view;

import javax.swing.JOptionPane;

import model.Data;

public class Principal {

	public static void main(String[] args) {
		
		Data d1 = new Data(JOptionPane.showInputDialog("Informe a data no formato dd/mm/yyyy: "));
		
		System.out.println(d1.dt);
		if (!d1.dt.equals("01/01/0001")) {
			System.out.println(d1.getMesExtenso());
			
			Data d2 = new Data(JOptionPane.showInputDialog("Informe a OUTRA data no formato dd/mm/yyyy: "));
			int resultado = d1.comparar(d2);
			if (resultado == 0) {
				System.out.println("As datas são iguais");
			} else if (resultado == 1) {
				System.out.println("A data do objeto corrente é maior");
			} else {
				System.out.println("A data do outro objeto é maior");
			}
		}

	}

}

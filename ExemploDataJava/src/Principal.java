import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		Date dataNascimento = new Date(); //data do sistema

		System.out.println(dataNascimento); //imprime sem formatacao
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //definicao da formatacao
		System.out.println(sdf.format(dataNascimento)); //imprime com formatacao
		
		try {
		    //Recebe Data do Usuário e converte de string para Date
			dataNascimento = sdf.parse(JOptionPane.showInputDialog("Informe a data de nascimento (dd/MM/yyyy): "));
			
			System.out.println(dataNascimento); //imprime sem formatacao 
			System.out.println(sdf.format(dataNascimento)); //imprime com formatacao
		} catch (Exception e) {
			System.out.println("Data Inválida!");
		    e.printStackTrace();
		}
		
	}

}

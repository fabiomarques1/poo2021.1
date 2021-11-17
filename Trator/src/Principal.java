import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		String teclado;
		
		teclado = JOptionPane.showInputDialog("Informe a marca do trator");
		
		Trator trator = new Trator(teclado);
		
		loop: do {

			boolean erro = true;
			int opcao = 0;
			do {
				teclado = JOptionPane
					.showInputDialog("Informe a poção:\n1-Acelerar\n2-Desacelerar\n3-Parar\n4-Levantar Braço"
							+ "\n5-Abaixar Braço\n6-Desligar");
				try { // tratamento da exceção de conversão de string para inteiro
					opcao = Integer.parseInt(teclado);
					erro = false;
				} catch (NumberFormatException ex) { //Lançamento da exceção de conversão para número
					JOptionPane.showMessageDialog(null, "Informe valores númericos!");
				}
			} while (erro);
			
			switch (opcao) {
			case 1:
				JOptionPane.showMessageDialog(null,trator.acelerar());
				break;
			case 2:
				JOptionPane.showMessageDialog(null,trator.desacelerar());
				break;
			case 3:
				JOptionPane.showMessageDialog(null, trator.parar());
				break;
			case 4:
				JOptionPane.showMessageDialog(null,trator.levantarBraco());
				break;
			case 5:
				JOptionPane.showMessageDialog(null,trator.abaixarBraco());
				break;
			case 6:
				if (trator.velocidade == 0) {
					JOptionPane.showMessageDialog(null,"Desligando o trator...");
					break loop;
				} else {
					JOptionPane.showMessageDialog(null,"O trator está em movimento! Não posso desligar...");
				}
				break;
			default:
				JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
			}
			
			JOptionPane.showMessageDialog(null, trator);

		} while (true);
		
	}

}

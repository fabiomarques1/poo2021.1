package estudante;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		// *********************** VARÁVEIS ************************************
		//Declarar Variáveis
		String teclado;
		double nota, mediaMinima;
		
		// **************** OBJETO **********************************************
		//Instanciar Objeto estudante1
		Estudante estudante1 = new Estudante();
		
		// **************** ENTRADA DE DADOS *************************************
		//Ler Nome
		teclado = JOptionPane.showInputDialog("Informe o nome:");
		estudante1.setNome(teclado);
		
		//Ler Nota 1
		teclado = JOptionPane.showInputDialog("Informe a nota 1:");
		nota = Double.parseDouble(teclado);
		estudante1.setNota1(nota);
		
		//Ler Nota 2
		teclado = JOptionPane.showInputDialog("Informe a nota 2:");
		nota = Double.parseDouble(teclado);
		estudante1.setNota2(nota);
		
		//Ler Média Mínima para Aprovação
		teclado = JOptionPane.showInputDialog("Informe a média para aprovação:");
		mediaMinima = Double.parseDouble(teclado);
		
		// **************** SAÍDA DE DADOS ****************************************
		//Imprimir Dados
		System.out.println("Nome: " + estudante1.getNome());
		System.out.println("Média: " + estudante1.media());
		System.out.println("Média Mínima para Aprovação: " + mediaMinima);
		System.out.println("Resultado: "	+ estudante1.resultado(mediaMinima));
		
		JOptionPane.showMessageDialog(null,     "Nome: " + estudante1.getNome()
											+ "\nMédia: " + estudante1.media()
											+ "\nMédia Mínima para Aprovação: " + mediaMinima
											+ "\nResultado: "	+ estudante1.resultado(mediaMinima));

	}

}

package aplicacao;

import javax.swing.JOptionPane;

import modelo.Cliente;
import modelo.Endereco;

public class Principal {

	public static void main(String[] args) {
		
		long cpf;
		String teclado, nome;
		
		teclado = JOptionPane.showInputDialog("Informe o cpf:");
		cpf = Long.parseLong(teclado);
		
		nome = JOptionPane.showInputDialog("Informe o nome:");
		
		Cliente cliente = new Cliente(cpf, nome);
		
		teclado = JOptionPane.showInputDialog("Deseja cadastrar endereço de entrega? (S)-SIM (N)-NÃO:");
		char opcao = teclado.toUpperCase().charAt(0);
		
		if (opcao == 'S') {
			
			Endereco endereco = cadastrarEndereco();
			cliente.setEnderecoEntrega(endereco);
			
			teclado = JOptionPane.showInputDialog("Endereco de Cobrança é o mesmo Endereço de Entrega? (S)-SIM (N)-NÃO:");
			opcao = teclado.toUpperCase().charAt(0);
			
			if (opcao == 'S') {
				cliente.setEnderecoCobranca(endereco);
			} else {
				Endereco enderecoCobranca = cadastrarEndereco();
				cliente.setEnderecoCobranca(enderecoCobranca);						
			}
		}
		
		System.out.println(cliente);
		JOptionPane.showMessageDialog(null, cliente);
	}
	
	public static Endereco cadastrarEndereco() {
		String rua, complemento, cidade, estado, teclado;
		short numero;
		int cep;
		
		rua = JOptionPane.showInputDialog("Informe a rua :");
		
		teclado = JOptionPane.showInputDialog("Informe o número:");
		numero = Short.parseShort(teclado);
		
		complemento = JOptionPane.showInputDialog("Informe o completo:");
		
		teclado = JOptionPane.showInputDialog("Informe o cep:");
		cep = Integer.parseInt(teclado);
		
		cidade = JOptionPane.showInputDialog("Informe a cidade:");
		estado = JOptionPane.showInputDialog("Informe o estado:");
		
		Endereco endereco = new Endereco(rua, numero, complemento, cep, cidade, estado);
		return endereco;
		

	}

}

package br.com.agenda.aplicacao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.db.ConexaoBD;
import br.com.agenda.modelo.Contato;

public class Principal {

	public static void main(String[] args) {
		
//		try {
//			Connection conn = ConexaoBD.getConexaoMySQL();
//			System.out.println("Conexão com banco Agenda realizada com sucesso");
//		} catch (Exception e) {
//			System.out.println("Falha na Conexão");
//			e.printStackTrace();
//		}
		
//		boolean erro;
//		Contato contato = new Contato();
//		contato.setNome(JOptionPane.showInputDialog("Informe o nome: "));
//		contato.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Informe a idade: ")));
//		contato.setDataCadastro(new Date());
//		
//		erro = ContatoDAO.incluir(contato); //incluir
//		if (!erro) {
//			JOptionPane.showMessageDialog(null, "Contato inserido com sucesso!");
//		} else {
//			JOptionPane.showMessageDialog(null, "Falha ao tentar inserir contato");
//		}
//
//		
//		for(Contato c1 : ContatoDAO.listarContatos()) { //listar
//			System.out.println(c1);
//		}
//		
//		contato = ContatoDAO.findById(Integer.parseInt(JOptionPane.showInputDialog("Informe o id: "))); //encontrar por id
//		contato.setNome(JOptionPane.showInputDialog("Informe o nome: "));
//		contato.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Informe a idade: ")));
//		ContatoDAO.editar(contato);
//		if (!erro) {
//			JOptionPane.showMessageDialog(null, "Contato editado com sucesso!");
//		} else {
//			JOptionPane.showMessageDialog(null, "Falha ao tentar editar contato");
//		}
//		
//		ContatoDAO.apagar(Integer.parseInt(JOptionPane.showInputDialog("Informe o id: ")));
//		if (!erro) {
//			JOptionPane.showMessageDialog(null, "Contato apagado com sucesso!");
//		} else {
//			JOptionPane.showMessageDialog(null, "Falha ao tentar apagar contato");
//		}
//		
//		for(Contato c1 : ContatoDAO.listarContatos()) { //listar
//			System.out.println(c1);
//		}
		
		new frmPrincipal().setVisible(true);
		
	}

}

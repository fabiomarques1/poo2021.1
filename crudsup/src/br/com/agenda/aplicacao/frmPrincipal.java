package br.com.agenda.aplicacao;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.modelo.Contato;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowFocusListener;
import java.util.Date;
import java.util.List;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class frmPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable tblContatos;
	private DefaultTableModel modelo;

	public frmPrincipal() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				preencherTabela();
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new frmContato(null).setVisible(true);
			}
		});
		
		btnIncluir.setBounds(53, 246, 117, 29);
		contentPane.add(btnIncluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 438, 236);
		contentPane.add(scrollPane);
		
		tblContatos = new JTable();
		tblContatos.setShowGrid(true);
		tblContatos.setGridColor(Color.LIGHT_GRAY);
		scrollPane.setViewportView(tblContatos);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
		});
		btnEditar.setBounds(166, 246, 117, 29);
		contentPane.add(btnEditar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
			}
		});
		btnApagar.setBounds(277, 246, 117, 29);
		contentPane.add(btnApagar);
		
		modelo = (DefaultTableModel) tblContatos.getModel();
		modelo.addColumn("Id");
		modelo.addColumn("Nome");
		modelo.addColumn("Idade");
		modelo.addColumn("Data Cadastro");
	}
	
	private void preencherTabela() {
		modelo.getDataVector().clear();
		try {
			for (Contato contato : ContatoDAO.listarContatos()) {
				modelo.addRow(new Object[] { contato.getId(), contato.getNome(), contato.getIdade(),
						contato.getDataCadastro() });
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	private void alterar() {
		try {
			Integer id = (Integer) modelo.getValueAt(tblContatos.getSelectedRow(), 0);
			String nome = (String) modelo.getValueAt(tblContatos.getSelectedRow(), 1);
			int idade = (Integer) modelo.getValueAt(tblContatos.getSelectedRow(), 2);
			Date dataCadastro = (Date) modelo.getValueAt(tblContatos.getSelectedRow(), 3);

			Contato contato = new Contato();
			contato.setId(id);
			contato.setNome(nome);
			contato.setIdade(idade);
			contato.setDataCadastro(dataCadastro);

			new frmContato(contato).setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Por favor, selecionar uma linha da tabela");
		}
	}
	
	private void deletar() {
		try {
			Integer id = (Integer) modelo.getValueAt(tblContatos.getSelectedRow(), 0);
			
			boolean erro = ContatoDAO.apagar(id);
			if (!erro) {
				modelo.removeRow(tblContatos.getSelectedRow());
				JOptionPane.showMessageDialog(this, "Item excluído com sucesso!");
			} else {
				JOptionPane.showMessageDialog(this, "Erro ao excluir.");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Por favor, selecionar uma linha da tabela");
		}
	}
}

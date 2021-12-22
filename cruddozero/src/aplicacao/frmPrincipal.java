package aplicacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.ContatoDAO;
import dao.ContatoDAOMySQL;
import modelo.Contato;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowFocusListener;
import java.util.Date;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmPrincipal extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modelo;
	private ContatoDAO contatoDAO = new ContatoDAOMySQL();
	private JTable tblContato;

	/**
	 * Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipal frame = new frmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmPrincipal() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				listarContatos();
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incluirContato();
			}
		});
		btnIncluir.setBounds(3, 243, 112, 29);
		contentPane.add(btnIncluir);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarContato();
			}
		});
		btnAtualizar.setBounds(118, 243, 112, 29);
		contentPane.add(btnAtualizar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apagarContato();
			}
		});
		btnApagar.setBounds(233, 243, 112, 29);
		contentPane.add(btnApagar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		btnSair.setBounds(348, 243, 112, 29);
		contentPane.add(btnSair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(3, 6, 455, 231);
		contentPane.add(scrollPane);
		
		tblContato = new JTable();
		tblContato.setShowGrid(true);
		tblContato.setGridColor(Color.LIGHT_GRAY);
		scrollPane.setViewportView(tblContato);
		modelo = (DefaultTableModel) tblContato.getModel();
		modelo.addColumn("Id");
		modelo.addColumn("Nome");
		modelo.addColumn("Idade");
		modelo.addColumn("Data Cadastro");
		
	}
	
	private void listarContatos() {
		modelo.getDataVector().clear();
		try {
			for (Contato contato : contatoDAO.listarContatos()) {
				modelo.addRow(new Object[] { contato.getId(), contato.getNome(), contato.getIdade(),
						contato.getDataCadastro() });
			}
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	private void incluirContato() {
		new frmContato(null).setVisible(true);
	}
	
	private void atualizarContato() {
		try {
			Integer id = (Integer) modelo.getValueAt(tblContato.getSelectedRow(), 0);
			String nome = (String) modelo.getValueAt(tblContato.getSelectedRow(), 1);
			int idade = (Integer) modelo.getValueAt(tblContato.getSelectedRow(), 2);
			Date dataCadastro = (Date) modelo.getValueAt(tblContato.getSelectedRow(), 3);

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
	
	private void apagarContato() {
		try {
			Integer id = (Integer) modelo.getValueAt(tblContato.getSelectedRow(), 0);
			
			int linha = contatoDAO.apagar(id);
			if (linha > 0) {
				modelo.removeRow(tblContato.getSelectedRow());
				JOptionPane.showMessageDialog(this, "Contato excluído com sucesso!");
			} else {
				JOptionPane.showMessageDialog(this, "Erro ao excluir.");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Por favor, selecionar uma linha da tabela");
		}
	}
	
	private void sair() {
		Object[] opcao = { "Não", "Sim" };
		int opcaoSelecionada = JOptionPane.showOptionDialog(this, "Deseja realmente sair da aplicação?", "Aviso",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcao, opcao[0]);
		if (opcaoSelecionada == 1) {
			System.exit(0);
		}
	}

}

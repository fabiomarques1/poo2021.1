package br.com.agenda.aplicacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.modelo.Contato;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class frmContato extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;

	public frmContato(Contato contato) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 308, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(56, 39, 61, 16);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(56, 109, 61, 16);
		contentPane.add(lblIdade);
		
		txtNome = new JTextField();
		txtNome.setBounds(115, 35, 130, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(115, 105, 130, 26);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contato == null) {
					inserir();
				} else {
					editar(contato);
				}
			}
		});
		btnSalvar.setBounds(71, 183, 117, 29);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setBounds(185, 183, 117, 29);
		contentPane.add(btnCancelar);
		
		if (contato != null) {
			txtNome.setText(contato.getNome());
			txtIdade.setText(Integer.toString(contato.getIdade()));
		}
	}
	
	private void inserir() {
		Contato contatoInserido = new Contato();
		contatoInserido.setNome(txtNome.getText());
		contatoInserido.setIdade(Integer.parseInt(txtIdade.getText()));
		contatoInserido.setDataCadastro(new Date());

		boolean erro = ContatoDAO.incluir(contatoInserido);
		if (!erro) {
			JOptionPane.showMessageDialog(this, "Contato inserido com sucesso!");
		} else {
			JOptionPane.showMessageDialog(this, "Erro ao inserir Contato.");
		}
		this.dispose();
	}
	
	private void editar(Contato contato) {
		Contato contatoEditado = new Contato();
		contatoEditado.setId(contato.getId());
		contatoEditado.setNome(txtNome.getText());
		contatoEditado.setIdade(Integer.parseInt(txtIdade.getText()));
		contatoEditado.setDataCadastro(contato.getDataCadastro());

		int linha = ContatoDAO.editar(contatoEditado);
		if (linha > 0) {
			JOptionPane.showMessageDialog(this, "Contato editado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(this, "Erro ao editar Contato.");
		}
		this.dispose();
	}
	
	public void cancelar() {
		Object[] opcao = { "Não", "Sim" };
		int opcaoSelecionada = JOptionPane.showOptionDialog(this, "Deseja realmente sair?", "Aviso",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcao, opcao[0]);
		if (opcaoSelecionada == 1) {
			this.dispose();
		}
	}
}

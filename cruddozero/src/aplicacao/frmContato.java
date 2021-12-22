package aplicacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ContatoDAO;
import dao.ContatoDAOMySQL;
import modelo.Contato;

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
	private Contato contato = null;
	private ContatoDAO contatoDAO = new ContatoDAOMySQL();

	/**
	 * Create the frame.
	 */
	public frmContato(final Contato contato) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 280, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(40, 46, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Idade");
		lblNewLabel_1.setBounds(40, 94, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(86, 41, 130, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(86, 89, 130, 26);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		JButton btnSalvar = new JButton("Incluir");
		
		if (contato != null) {
			txtNome.setText(contato.getNome());
			txtIdade.setText(Integer.toString(contato.getIdade()));
			btnSalvar.setText("Atualizar");
			this.contato = contato;
		}
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contato == null) {
					incluirContato();
				} else {
					atualizarContato();
				}
			}
		});
		btnSalvar.setBounds(15, 153, 117, 29);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setBounds(147, 153, 117, 29);
		contentPane.add(btnCancelar);
	}
	
	private void incluirContato() {
		Contato contatoInserido = new Contato();
		contatoInserido.setNome(txtNome.getText());
		contatoInserido.setIdade(Integer.parseInt(txtIdade.getText()));
		contatoInserido.setDataCadastro(new Date());

		int linha = contatoDAO.incluir(contatoInserido);
		if (linha > 0) {
			JOptionPane.showMessageDialog(this, "Contato inserido com sucesso!");
		} else {
			JOptionPane.showMessageDialog(this, "Erro ao inserir Contato.");
		}
		this.dispose();
	}
	
	private void atualizarContato() {
		Contato contatoEditado = new Contato();
		contatoEditado.setId(contato.getId());
		contatoEditado.setNome(txtNome.getText());
		contatoEditado.setIdade(Integer.parseInt(txtIdade.getText()));
		contatoEditado.setDataCadastro(contato.getDataCadastro());

		int linha = contatoDAO.atualizar(contatoEditado);
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

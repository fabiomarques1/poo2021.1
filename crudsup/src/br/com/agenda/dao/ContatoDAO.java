package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.db.ConexaoBD;
import br.com.agenda.modelo.Contato;

public class ContatoDAO {
	
	private static Connection conexao = null;
	private static PreparedStatement sql = null;
	private static ResultSet rset = null;
	
	//C
	public static boolean incluir(Contato contato) {
		boolean erro = false;
		String insert = "INSERT	INTO contatos (nome, idade, dataCadastro) VALUES (?, ?, ?)";
		
		try {
			conexao = ConexaoBD.getConexaoMySQL();
			sql = conexao.prepareStatement(insert);
			sql.setString(1, contato.getNome());
			sql.setInt(2, contato.getIdade());
			sql.setDate(3, new Date(contato.getDataCadastro().getTime()));
			sql.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			erro = true;
		} finally {
			fecharConexao();
		}
		return erro;
	}
	
	//R
	public static List<Contato> listarContatos() {
		
		String select = "SELECT * FROM contatos";

		List<Contato> contatos = new ArrayList<Contato>();

		try {
			conexao = ConexaoBD.getConexaoMySQL();
			sql = conexao.prepareStatement(select);
			rset = sql.executeQuery();

			while (rset.next()) {

				Contato contato = new Contato();

				contato.setId(rset.getInt("id"));
				contato.setNome(rset.getString("nome"));
				contato.setIdade(rset.getInt("idade"));
				contato.setDataCadastro(rset.getDate("datacadastro"));

				contatos.add(contato);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return contatos;
	}
	
	//U
	public static int editar(Contato contato) {
		String update = "UPDATE contatos SET nome = ?, idade = ? WHERE id = ?";
		int linha = 0;
		try {
			conexao = ConexaoBD.getConexaoMySQL();
			sql = conexao.prepareStatement(update);
			sql.setString(1, contato.getNome());
			sql.setInt(2, contato.getIdade());
			sql.setInt(3, contato.getId());
			linha = sql.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return linha;
	}
	
	//D
	public static boolean apagar(int id) {
		boolean erro = false;
		String delete = "DELETE FROM contatos WHERE id = ?";
		
		try {
			conexao = ConexaoBD.getConexaoMySQL();
			sql = conexao.prepareStatement(delete);
			sql.setInt(1, id);
			sql.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			erro = true;
		} finally {
			fecharConexao();
		}
		return erro;
		
	}
	
	public static Contato findById(int id) {
		Contato contato = null;

		String select = "SELECT * FROM contatos WHERE id = ?";

		try {
			conexao = ConexaoBD.getConexaoMySQL();
			sql = conexao.prepareStatement(select);
			sql.setInt(1, id);

			rset = sql.executeQuery();

			while (rset.next()) {

				contato = new Contato();

				contato.setId(rset.getInt("id"));
				contato.setNome(rset.getString("nome"));
				contato.setId(rset.getInt("idade"));
				contato.setDataCadastro(rset.getDate("datacadastro"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}

		return contato;
	}

	private static void fecharConexao() {

		try {

			if (rset != null) {
				rset.close();
			}

			if (sql != null) {
				sql.close();
			}

			if (conexao != null) {
				conexao.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

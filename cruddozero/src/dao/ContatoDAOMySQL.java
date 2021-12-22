package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import db.ConexaoBD;
import modelo.Contato;

public class ContatoDAOMySQL implements ContatoDAO {
	
	private static Connection conexao = null;
	private static PreparedStatement sql = null;
	private static ResultSet rset = null;

	@Override
	public int incluir(Contato contato) {	
		int linha = 0;
		String insert = "INSERT	INTO contatos (nome, idade, dataCadastro) VALUES (?, ?, ?)";
		
		try {
			conexao = ConexaoBD.getConexaoMySQL();
			sql = conexao.prepareStatement(insert);
			sql.setString(1, contato.getNome());
			sql.setInt(2, contato.getIdade());
			sql.setDate(3, new Date(contato.getDataCadastro().getTime()));
			linha = sql.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return linha;
	}

	@Override
	public List<Contato> listarContatos() {
		String select = "SELECT * FROM contatos";

		List<Contato> contatos = new ArrayList<>();

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

	@Override
	public int atualizar(Contato contato) {
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

	@Override
	public int apagar(int id) {
		int linha = 0;
		String delete = "DELETE FROM contatos WHERE id = ?";
		try {
			conexao = ConexaoBD.getConexaoMySQL();
			sql = conexao.prepareStatement(delete);
			sql.setInt(1, id);
			linha = sql.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return linha;
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

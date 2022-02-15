package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoBD;
import modelo.Materia;

public class MateriaDAO {
	
	private static Connection conexao = null;
	private static PreparedStatement sql = null;
	private static ResultSet rset = null;
	
	public int incluir (Materia materia) {
		String insert = "INSERT	INTO materia (disciplina, assunto, autor, descricao, link ) VALUES (?, ?, ?, ?, ?)";
		int linha = 0;
		try {
			conexao = ConexaoBD.getConexaoMySQL();
			sql = conexao.prepareStatement(insert);
			sql.setString(1, materia.getDisciplina());
			sql.setString(2, materia.getAssunto());
			sql.setString(3, materia.getAutor());
			sql.setString(4, materia.getDescricao());
			sql.setString(5, materia.getLink());
			
			linha = sql.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return linha;
	}
	
	public int editar(Materia materia) {
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
		
		return 0;
	}
	
	public List<Materia> listar() {
		
		String select = "SELECT * FROM materia";

		List<Materia> materias = new ArrayList();

		try {
			conexao = ConexaoBD.getConexaoMySQL();
			sql = conexao.prepareStatement(select);
			rset = sql.executeQuery();

			while (rset.next()) {

				Materia materia = new Materia();

				materia.setId(rset.getInt("id"));
				materia.setDisciplina(rset.getString("disciplina"));
				materia.setAssunto(rset.getString("assunto"));
				//materia.setDisciplina(rset.getString("disciplina"));
				//materia.setDisciplina(rset.getString("disciplina"));
				//materia.setDisciplina(rset.getString("disciplina"));

				materias.add(materia);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		
		return materias;
	}
	
	public int excluir(int id) {
		
		
		return 0;
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

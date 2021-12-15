package br.com.agenda.db;

import java.sql.*;

public class ConexaoBD {
	
	private static final String USUARIO = "root";
	private static final String SENHA = "123456";
	private static final String URL_BD = "jdbc:mysql://localhost:3306/agenda";
	
	public static Connection getConexaoMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");	
		Connection conn = DriverManager.getConnection(URL_BD, USUARIO, SENHA);	
		return conn;
	}

}

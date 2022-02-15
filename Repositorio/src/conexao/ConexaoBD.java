package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {

	private static final String USUARIO = "root";
	private static final String SENHA = "123456";
	private static final String URL_BD = "jdbc:mysql://localhost:3306/repositorio";

	public static Connection getConexaoMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL_BD, USUARIO, SENHA);
		return conn;
	}

}

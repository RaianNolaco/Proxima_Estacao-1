package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	//Módulo de conexão
	//Parâmetros de conexão
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL= "jdbc:mysql://127.0.0.1:3306/proxima_estacao?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "";
	
	//Método de conexão
	public static Connection getConnection() {
		try {
			
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		}catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Erro na conexão com o banco!", e);
		}
	}
	
}
	
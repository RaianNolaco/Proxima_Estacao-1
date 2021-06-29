package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	// M�dulo de conex�o
	// Par�metros de conex�o
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/proxima_estacao?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "";

	// M�todo de conex�o
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Erro na conex�o com o banco cara!", e);
		}
	}

	
	//M�todo para fechar o conectio, statementi e resultset
	public static void closeConnection(Connection con) {

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("Erro: " + e);
			}
		}

	}

	public static void closeConnection(Connection con, PreparedStatement stmt) {

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.err.println("Erro: " + e);
			}
			
			closeConnection(con);
		}

	}

	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.err.println("Erro: " + e);
			}
		closeConnection(con,stmt);
		}

	}
	
}

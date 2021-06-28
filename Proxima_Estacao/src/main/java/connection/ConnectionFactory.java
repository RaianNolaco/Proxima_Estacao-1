package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	//M�dulo de conex�o
	//Par�metros de conex�o
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL= "jdbc:mysql://127.0.0.1:3306/proxima_estacao?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "";
	
	//M�todo de conex�o
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		}catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Erro na conex�o com o banco cara!", e);
		}
	}
	
}
	
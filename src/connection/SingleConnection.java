package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	private static String url = "jdbc:postgresql://localhost:5432/cadastro?autoReconnect=true";
	private static String user = "postgres";
	private static String password = "123456";
	private static Connection connection = null;
	private static String driver = "org.postgresql.Driver";
	
	static {
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}
	
	private static void conectar() {
		
		try {
			
			if(connection == null) {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Falha na conexão com o banco de dados!");
		}
	}
	
	public static Connection getConection() {
		return connection;
	}
}

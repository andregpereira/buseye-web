package control.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private String schema = "jdbc:mysql://localhost:3306/projeto_buseye?serverTimezone=America/Sao_Paulo";
	private String user = "root";
	private String password = "root";

	public Connection getConnection() {
		try {
			new com.mysql.cj.jdbc.Driver();
			return DriverManager.getConnection(schema, user, password);
		} catch (SQLException e) {
			System.out.println("Erro ao conectar");
			throw new RuntimeException(e);
		}
	}

}

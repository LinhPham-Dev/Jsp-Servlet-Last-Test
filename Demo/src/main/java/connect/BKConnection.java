package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BKConnection {

	public static Connection connection;
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Test_Last;";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "18122002";

	private BKConnection() {
	}

	public static Connection GetConnection() throws ClassNotFoundException {
		if (connection == null) {

			try {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return connection;
	}

}

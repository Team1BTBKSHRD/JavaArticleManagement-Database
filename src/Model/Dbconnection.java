package Model;

import java.sql.*;

/*
 * Utilities
 * -- Database Connection
 * */
public class Dbconnection {

	/*
	 * getConnection() function return connection *
	 */
	public Connection getConnection() throws SQLException,
			ClassNotFoundException {

		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/dbArtcle", "postgres", "123");
		return conn;

	}

	/*
	 * getConnection(1,2,3) function with param
	 * 
	 * @param : databasename, username, password return connection
	 */
	public Connection getConnection(String databasename, String username,
			String password) throws SQLException, ClassNotFoundException {

		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/" + databasename, username,
				password);
		return conn;
	}
}

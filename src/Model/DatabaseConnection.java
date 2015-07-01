package Model;

import java.sql.*;

/*
 * Utilities
 * -- Database Connection
 * */
public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:";
    private static final String DB_NAME = "dbArtcle";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String PORT_NUMBER = "5432";
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
	
	public String createDatabase() throws ClassNotFoundException, SQLException{		
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/","postgres","123");
		PreparedStatement stm = con.prepareStatement("SELECT datname FROM pg_database WHERE datname='dbArtcle';");
		ResultSet rs=stm.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString(1));
		}
		
		//stm.executeUpdate("CREATE DATABASE MydatAbseName   WITH OWNER postgres    TEMPLATE template0   ENCODING 'SQL_ASCII'   TABLESPACE  pg_default   LC_COLLATE  'C'   LC_CTYPE  'C'   CONNECTION LIMIT  -1;");
		return null;
	}
}

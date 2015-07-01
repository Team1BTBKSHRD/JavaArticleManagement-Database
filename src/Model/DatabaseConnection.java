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
    private DatabaseConnection(){}
	/*
	 * getConnection() function return connection *
	 */
	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {

		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/dbarticle", "postgres", "123");
		return conn;

	}

	/*
	 * getConnection(1,2,3) function with param
	 * 
	 * @param : databasename, username, password return connection
	 */
	public static Connection getConnection(String databasename, String username,
			String password) throws SQLException, ClassNotFoundException {
		
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/" + databasename, username,
				password);
		return conn;
	}
	
	public static String createDatabase() throws ClassNotFoundException, SQLException{		
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/","postgres","123");
		PreparedStatement stm = con.prepareStatement("SELECT datname FROM pg_database WHERE datname='dbarticle';");
		ResultSet rs=stm.executeQuery();
		if(!rs.next()){	
			String sqlScript = "CREATE DATABASE dbarticle   WITH OWNER postgres    TEMPLATE template0   "
							+ "ENCODING 'SQL_ASCII'   TABLESPACE  pg_default   LC_COLLATE  'C'   "
							+ "LC_CTYPE  'C'   CONNECTION LIMIT  -1;";
			stm = con.prepareStatement(sqlScript);			
			stm.executeUpdate();
		
			stm.close();
			con.close();
			
			createDatabaseDefinition();
			
			return "Created New Database.";
		}
		stm.close();
		con.close();

		return "Database Already Existed.";		
	}
	public static String createDatabaseDefinition() throws ClassNotFoundException, SQLException{		
		Class.forName("org.postgresql.Driver");
		Connection con = getConnection();
		String sqlScript = "CREATE SEQUENCE  \"art_id_seq\" INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 2 CACHE 1;"
							+ "SELECT setval(' \"art_id_seq\"', 2, true);"
							+ "CREATE TABLE  \"tbarticle\" (\"id\" int4 DEFAULT nextval('art_id_seq'::regclass) NOT NULL,\"author\" text COLLATE \"default\" NOT NULL,\"title\" text COLLATE \"default\" NOT NULL,\"content\" text COLLATE \"default\",\"published_date\" timestamp(6))WITH (OIDS=FALSE);"
							+ "INSERT INTO  \"tbarticle\" VALUES ('1', 'sambo', 'java', 'kfjalj', '2015-07-01 10:35:40');"
							+ "INSERT INTO  \"tbarticle\" VALUES ('2', 'ellit', 'web', 'kdfjd', '2015-07-01 10:35:55');";
		PreparedStatement stm = con.prepareStatement(sqlScript);
		stm.execute();
		stm.close();
		con.close();

		return "Database Already Existed.";		
	}
}

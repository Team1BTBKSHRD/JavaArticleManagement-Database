package Utilities;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.*;

/*
 * Utilities
 * -- Database Connection
 * */
public class DatabaseConnection {
	private static String DRIVER_NAME = "org.postgresql.Driver";
	private static String URL = "jdbc:postgresql://localhost:";
	private static String PORT_NUMBER = "5432";
	private static String DB_NAME = "dbarticlebtb";
	private static String USER = "postgres";
	private static String PASSWORD = "123";

	/**
	 * Deny object initialization
	 */
	private DatabaseConnection() {
	}

	/**
	 * connecting to a database
	 * 
	 * @return object connection to a database
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		Class.forName(DRIVER_NAME);
		Connection con = DriverManager.getConnection(URL + PORT_NUMBER + "/"
				+ DB_NAME, USER, PASSWORD);
		return con;
	}

	/**
	 * check whether if database is exist or create a new one
	 * 
	 * @return string message
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public static String checkDatabase() throws ClassNotFoundException,
			SQLException, IOException {
		// DO NOT USE getConnection() in this function
		// there will be error when there is no database
		Connection con = DriverManager.getConnection(URL + PORT_NUMBER + "/",
				USER, PASSWORD);
		PreparedStatement stm = con
				.prepareStatement("SELECT datname FROM pg_database WHERE datname='"
						+ DB_NAME + "';");
		ResultSet rs = stm.executeQuery();

		// if rs.next is true => database is already exist
		// false => there is no databse => create new database, functions, views
		if (!rs.next()) {
			// creating new database
			String sqlScript = "CREATE DATABASE "
					+ DB_NAME
					+ "   WITH OWNER "
					+ USER
					+ "    TEMPLATE template0   "
					+ "ENCODING 'SQL_ASCII'   TABLESPACE  pg_default   LC_COLLATE  'C'   "
					+ "LC_CTYPE  'C'   CONNECTION LIMIT  -1;";
			stm = con.prepareStatement(sqlScript);
			stm.executeUpdate();
			rs.close();
			stm.close();
			con.close();

			// creating functions and views
			executeSqlStatementFromFile("db_new_Elit_script.sql");

			return "Created New Database.";
		}
		rs.close();
		stm.close();
		con.close();
		return "Database Already Existed.";
	}

	/**
	 * execute SQL statement from SQL file if error occur it throws exception so
	 * there's no need to return anything
	 * 
	 * @param fileName
	 *            : SQL file name
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void executeSqlStatementFromFile(String fileName)
			throws ClassNotFoundException, SQLException, IOException {
		// Read Sql Statement from sql file
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		StringBuilder sqlScript = new StringBuilder();
		String str1 = "";
		while ((str1 = br.readLine()) != null) {
			sqlScript.append(str1);
			sqlScript.append("\n");
		}
		br.close();

		// then execute it
		// if error occur it throws exception so there's no need to return
		// anything
		Connection con = getConnection();
		PreparedStatement stm = con.prepareStatement(sqlScript.toString());
		stm.execute();
		stm.close();
		con.close();
	}

	public static String getDatabaseName() {
		return DB_NAME;
	}
	/*
	 * public static void main(String[] args) throws ClassNotFoundException,
	 * SQLException, IOException { System.out.println(checkDatabase()); }
	 */
}
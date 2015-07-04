package Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Utilities
 * -- Database Connection
 * */
public class DatabaseConnection {
	private static String DRIVER_NAME = "org.postgresql.Driver";
	private static String URL = "jdbc:postgresql://localhost:";
	private static String PORT_NUMBER = "5432";
	private static String DB_NAME = "dbarticlebtb";
	private static String USER_NAME = "postgres";
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
				+ DB_NAME, USER_NAME, PASSWORD);
		return con;
	}
	public static boolean createDatabase(String fileName) throws SQLException, IOException, ClassNotFoundException{
		if(!checkDatabase()){
			// DO NOT USE getConnection() in this function
			// there will be error when there is no database
			Connection con = DriverManager.getConnection(URL + PORT_NUMBER + "/",
				USER_NAME, PASSWORD);
			String sqlScript = "CREATE DATABASE "
				+ DB_NAME
				+ "   WITH OWNER "
				+ USER_NAME
				+ "    TEMPLATE template0   "
				+ "ENCODING 'SQL_ASCII'   TABLESPACE  pg_default   LC_COLLATE  'C'   "
				+ "LC_CTYPE  'C'   CONNECTION LIMIT  -1;";
			PreparedStatement stm = con.prepareStatement(sqlScript);
			stm.executeUpdate();
			stm.close();
			con.close();
			return restoreDatabase(fileName);			 
		}
		return false;
	}
		
	/**
	 * check whether if database is exist
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	private static boolean checkDatabase() throws ClassNotFoundException,
			SQLException, IOException {
		// DO NOT USE getConnection() in this function
		// there will be error when there is no database
		Connection con = DriverManager.getConnection(URL + PORT_NUMBER + "/",
				USER_NAME, PASSWORD);
		PreparedStatement stm = con
				.prepareStatement("SELECT datname FROM pg_database WHERE datname='"
						+ DB_NAME + "';");
		ResultSet rs = stm.executeQuery();
		boolean hasDB =  rs.next();
		rs.close();
		stm.close();
		con.close();
		// false => there is no databse => create new database, functions, views
		// rs.next is true => database is already exist
		return hasDB;
	}
	public static boolean backUpDatabase() throws IOException{
		Runtime rt = Runtime.getRuntime();
		String fileName =  new SimpleDateFormat("ddMMYYYYHHmmss").format(new Date());
		String[] cmd = {
			    "pg_dump.exe",
			    "-f", fileName + ".sql",
			    "-U", USER_NAME,	  
			    DB_NAME,
			};		
		Process proc = rt.exec(cmd);
		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
		// read any errors from the attempted command
		if ((stdError.readLine()) != null) {
		    return false;
		}			
		return true;
	}
	public static boolean restoreDatabase(String fileName) throws IOException{
		Runtime rt = Runtime.getRuntime();
		String[] cmd = {
			    "psql.exe",
			    "-f", fileName,
			    "-U", USER_NAME,	  
			    DB_NAME,
			};		
		Process proc = rt.exec(cmd);
		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
		// read any errors from the attempted command
		if ((stdError.readLine()) != null) {
		    return false;
		}			
		return true;
	}
	
	public static String getDRIVER_NAME() {
		return DRIVER_NAME;
	}

	public static void setDRIVER_NAME(String dRIVER_NAME) {
		DRIVER_NAME = dRIVER_NAME;
	}

	public static String getURL() {
		return URL;
	}
	
	public static void setURL(String uRL) {
		URL = uRL;
	}
	
	public static String getPORT_NUMBER() {
		return PORT_NUMBER;
	}
	
	public static void setPORT_NUMBER(String pORT_NUMBER) {
		PORT_NUMBER = pORT_NUMBER;
	}
	
	public static String getDB_NAME() {
		return DB_NAME;
	}
	
	public static void setDB_NAME(String dB_NAME) {
		DB_NAME = dB_NAME;
	}
	
	public static String getUSER_NAME() {
		return USER_NAME;
	}
	
	public static void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	
	public static String getPASSWORD() {
		return PASSWORD;
	}
	
	public static void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
//	public static void main(String[] args) throws ClassNotFoundException,
//	  SQLException, IOException {
//	  	System.out.println(createDatabase("db_new_Elit_script.sql")); 
// 
//		  //System.out.println(backUpDatabase());
//		//  System.out.println(restoreDatabase("05072015041046.sql"));
//	}
	 
}
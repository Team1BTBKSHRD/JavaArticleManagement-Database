package Model;

import java.sql.SQLException;

public class test {
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		System.out.println(DatabaseConnection.createDatabase());
	}
}

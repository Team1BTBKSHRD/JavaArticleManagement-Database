package Model;

import java.sql.*;
import java.util.ArrayList;

public class tblArticle {
	public ArrayList<Article> all() throws ClassNotFoundException{
		ArrayList<Article> allArticles = new ArrayList<Article>();
		
		Class.forName("org.postgresql.Driver");
		Connection con=null;
		PreparedStatement stm=null;
		try{
		con=DriverManager.getConnection("jdbc:postgresql://localhost:3721/dbTest","postgres","12345678");
		stm=con.prepareStatement("select * from tbstudent");

		ResultSet rs=stm.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString(1));
		}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
			
		return allArticles;
	}
	public static void main(String args[]){
		System.out.println("asdf");
	}
}

package Model;

import java.sql.*;
import java.util.ArrayList;

import Utilities.DatabaseConnection;

public class ArticleDAO {
	public static boolean insertDB(ArrayList<ArticleDTO> arraylist) {
		try {
			PreparedStatement pstm = DatabaseConnection
					.getConnection()
					.prepareStatement(
							"insert into tbarticle(author,title,content) values(?,?,?)");
			for (ArticleDTO articleDTO : arraylist) {
				pstm.setString(1, articleDTO.getAuthor());
				pstm.setString(1, articleDTO.getTitle());
				pstm.setString(1, articleDTO.getContent());
				pstm.execute();
			}
			pstm.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();// write to error log
		}

		return false;
	}

	public boolean removeRecord(int key) {
		try {
			PreparedStatement pstm = DatabaseConnection.getConnection()
					.prepareStatement("delete * from tbarticle where id=?");
			pstm.setInt(1, key);
			if (pstm.executeUpdate() > 0) {
				return true;
			}
			pstm.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateRecordAuthor(int key, String author) {
		try {
			PreparedStatement pstm = DatabaseConnection.getConnection()
					.prepareStatement(
							"update tbarticle set author=? where id=?");
			pstm.setString(1, author);
			pstm.setInt(2, key);
			if (pstm.executeUpdate() > 0) {
				return true;
			}
			pstm.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateRecordTitle(int key, String title) {
		try {
			PreparedStatement pstm = DatabaseConnection.getConnection()
					.prepareStatement(
							"update tbarticle set author=? where id=?");
			pstm.setString(1, title);
			pstm.setInt(2, key);
			if (pstm.executeUpdate() > 0) {
				return true;
			}
			pstm.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateRecordContent(int key, String content) {
		try {
			PreparedStatement pstm = DatabaseConnection.getConnection()
					.prepareStatement(
							"update tbarticle set author=? where id=?");
			pstm.setString(1, content);
			pstm.setInt(2, key);
			if (pstm.executeUpdate() > 0) {
				return true;
			}
			pstm.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateRecordAll(int key, ArticleDTO article) {
		try {
			PreparedStatement pstm = DatabaseConnection
					.getConnection()
					.prepareStatement(
							"update tbarticle set author=?,title=?,content=? where id=?");
			pstm.setString(1, article.getAuthor());
			pstm.setString(2, article.getTitle());
			pstm.setString(3, article.getContent());
			pstm.setInt(4, key);
			if (pstm.executeUpdate() > 0) {
				return true;
			}
			pstm.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<ArticleDTO> searchRecord(int key, String operation,
			String fields) throws ClassNotFoundException, SQLException {
		ArrayList<ArticleDTO> articlelsit = new ArrayList<ArticleDTO>();
		Statement stm=null;
		ResultSet rs=null;
		switch (operation) {
		case "author":
			stm=DatabaseConnection.getConnection().createStatement();
			rs=stm.executeQuery("select * from tbarticle where author LIKE "+fields+'%');
			while(rs.next()){
				//articlelsit.add()
			}
			break;
		case "title":

			break;
		case "content":

			break;
		default:
			stm=DatabaseConnection.getConnection().createStatement();
			rs=stm.executeQuery("select * from tbarticle where id="+key);
			while(rs.next()){
				articlelsit.add(new ArticleDTO(rs.getInt("id"), rs.getString("author"), rs.getString("title"), rs.getString("content"), rs.getString("published_date")));
			}
			break;
		}
		stm.close();
		rs.close();
		return articlelsit;
	}

	public ArrayList<ArticleDTO> listData() {
		ArrayList<ArticleDTO> articlelsit = new ArrayList<ArticleDTO>();

		return articlelsit;
	}

}
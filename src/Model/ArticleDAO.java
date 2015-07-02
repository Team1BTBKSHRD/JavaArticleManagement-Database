package Model;

import java.sql.*;
import java.util.ArrayList;

import Utilities.DatabaseConnection;

public class ArticleDAO {
	private String message = null;

	public boolean insertRecords(ArrayList<ArticleDTO> arraylist) {
		String data = "{call add_article(?,?,?)}";
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(data);) {
			for (ArticleDTO articleDTO : arraylist) {
				cstm.setString(1, articleDTO.getAuthor());
				cstm.setString(2, articleDTO.getTitle());
				cstm.setString(3, articleDTO.getContent());
				cstm.execute();
			}
			return true;
		} catch (Exception e) {
			message = e.getMessage();
		}

		return false;
	}

	public boolean removeRecord(int key) {
		String data = "{call delete_article(?)}";
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(data);) {
			cstm.setInt(1, key);
			ResultSet rs = cstm.executeQuery();
			rs.next();
			return rs.getBoolean(1);
		} catch (Exception e) {
			message = e.getMessage();
		}
		return false;
	}

	public boolean updateRecordAuthor(int key, String author) {
		String data = "{call update_article_author(?,?)}";
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(data);) {
			cstm.setInt(1, key);
			cstm.setString(2, author);
			if (cstm.executeUpdate() > 0) {

				return true;

			}
		} catch (Exception e) {
			message = e.getMessage();
		}

		return false;
	}

	public boolean updateRecordTitle(int key, String title) {
		String data = "{call update_article_title(?,?)}";
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(data);) {
			cstm.setInt(1, key);
			cstm.setString(2, title);
			if (cstm.executeUpdate() > 0) {

				return true;

			}
		} catch (Exception e) {
			message = e.getMessage();
		}

		return false;
	}

	public boolean updateRecordContent(int key, String content) {
		String data = "{call update_article_content(?,?)}";
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(data);) {
			cstm.setInt(1, key);
			cstm.setString(2, content);
			if (cstm.executeUpdate() > 0) {

				return true;

			}
		} catch (Exception e) {
			message = e.getMessage();
		}

		return false;
	}

	public boolean updateRecordAll(int key, String author, String title,
			String content) {
		String data = "{call update_article(?,?,?,?)}";
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(data);) {
			cstm.setInt(1, key);
			cstm.setString(2, author);
			cstm.setString(3, title);
			cstm.setString(4, content);
			ResultSet rs = cstm.executeQuery();
			rs.next();
			return rs.getBoolean(1);
		} catch (Exception e) {
			message = e.getMessage();
		}
		return false;
	}

	public ArrayList<ArticleDTO> searchRecord(String operation, String fields) {
		ArrayList<ArticleDTO> articlelsit = new ArrayList<ArticleDTO>();
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			switch (operation) {
			case "author":
				String author = "{call search_by_author(?)}";
				cstm = DatabaseConnection.getConnection().prepareCall(author);
				cstm.setString(1, fields);
				rs = cstm.executeQuery();
				while (rs.next()) {
					articlelsit.add(new ArticleDTO(rs.getInt("id"), rs
							.getString("author"), rs.getString("title"), rs
							.getString("content"), rs.getDate("published_date")
							.toString()));
				}

				break;
			case "title":
				String title = "{call search_by_title(?)}";
				cstm = DatabaseConnection.getConnection().prepareCall(title);
				cstm.setString(1, fields);
				rs = cstm.executeQuery();
				while (rs.next()) {
					articlelsit.add(new ArticleDTO(rs.getInt("id"), rs
							.getString("author"), rs.getString("title"), rs
							.getString("content"), rs.getDate("published_date")
							.toString()));
				}

				break;
			case "content":
				String content = "{call search_by_content(?)}";
				cstm = DatabaseConnection.getConnection().prepareCall(content);
				cstm.setString(1, fields);
				rs = cstm.executeQuery();
				while (rs.next()) {
					articlelsit.add(new ArticleDTO(rs.getInt("id"), rs
							.getString("author"), rs.getString("title"), rs
							.getString("content"), rs.getDate("published_date")
							.toString()));
				}

				break;
			case "id":
				String id = "{call search_by_id(?)}";
				cstm = DatabaseConnection.getConnection().prepareCall(id);
				cstm.setInt(1, Integer.parseInt(fields));
				rs = cstm.executeQuery();
				while (rs.next()) {
					articlelsit.add(new ArticleDTO(rs.getInt("id"), rs
							.getString("author"), rs.getString("title"), rs
							.getString("content"), rs.getDate("published_date")
							.toString()));
				}

				break;
			}

		} catch (Exception e) {
			message = e.getMessage();
		} finally {
			try {
				cstm.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				message = e.getMessage();
			}
		}

		if (articlelsit.size() > 0) {
			message = "true";
		} else {
			message = "false";
		}
		return articlelsit;
	}

	public ArrayList<ArticleDTO> listData(){
		ArrayList<ArticleDTO> articlelsit = new ArrayList<ArticleDTO>();
		String data = "{call vw_show_by_id}";
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(data); ResultSet rs = cstm.executeQuery();) {
			while (rs.next()) {
				articlelsit.add(new ArticleDTO(rs.getInt("id"), rs
						.getString("author"), rs.getString("title"), rs
						.getString("content"), rs.getString("published_date")));
			}
		}catch (Exception e) {
			message=e.getMessage();
		}
		return articlelsit;
	}

	//public ArrayList<ArticleDTO> setRow(int row){return }
	//public int returnCountRow(){return}
}
package Model;

import java.sql.*;
import java.util.ArrayList;

import Utilities.DatabaseConnection;

public class ArticleDAO {
	private Exception messageerror = null;
	private ArrayList<ArticleDTO> articlelsit = null;
	public static String lenghtId = "";

	public Exception getMessageError() {
		return messageerror;
	}

	public boolean insertRecords(ArrayList<ArticleDTO> arraylist)
			throws ClassNotFoundException, SQLException {
		String stm = "{call add_article(?,?,?)}";
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(stm);) {
			for (ArticleDTO articleDTO : arraylist) {
				cstm.setString(1, articleDTO.getAuthor());
				cstm.setString(2, articleDTO.getTitle());
				cstm.setString(3, articleDTO.getContent());
				cstm.execute();
				lenghtId += returnLastId() + ";";
			}
			return true;
		}
	}

	public boolean removeRecord(int key) throws ClassNotFoundException,
			SQLException {
		String data = "{call delete_article(?)}";
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(data); ResultSet rs = cstm.executeQuery();) {
			cstm.setInt(1, key);

			rs.next();
			return rs.getBoolean(1);
		}
	}

	public boolean updateRecordAuthor(int key, String author)
			throws ClassNotFoundException, SQLException {
		String data = "{call update_article_author(?,?)}";
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(data);) {
			cstm.setInt(1, key);
			cstm.setString(2, author);
			if (cstm.executeUpdate() > 0) {

				return true;

			}
		}

		return false;
	}

	public boolean updateRecordTitle(int key, String title)
			throws ClassNotFoundException, SQLException {
		String data = "{call update_article_title(?,?)}";
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(data);) {
			cstm.setInt(1, key);
			cstm.setString(2, title);
			if (cstm.executeUpdate() > 0) {

				return true;

			}
		}

		return false;
	}

	public boolean updateRecordContent(int key, String content)
			throws ClassNotFoundException, SQLException {
		String data = "{call update_article_content(?,?)}";
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(data);) {
			cstm.setInt(1, key);
			cstm.setString(2, content);
			if (cstm.executeUpdate() > 0) {

				return true;

			}
		}

		return false;
	}

	public boolean updateRecordAll(int key, String author, String title,
			String content) throws ClassNotFoundException, SQLException {
		String data = "{call update_article(?,?,?,?)}";
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(data); ResultSet rs = cstm.executeQuery();) {
			cstm.setInt(1, key);
			cstm.setString(2, author);
			cstm.setString(3, title);
			cstm.setString(4, content);

			rs.next();
			return rs.getBoolean(1);
		}
	}

	public ArrayList<ArticleDTO> searchRecord(String operation, String fields)
			throws SQLException, ClassNotFoundException, NullPointerException {
		CallableStatement cstm = null;
		articlelsit = new ArrayList<ArticleDTO>();
		ResultSet rs = null;
			switch (operation.toLowerCase()) {
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
				String id = "{call search_id(?)}";
				cstm = DatabaseConnection.getConnection().prepareCall(id);
				cstm.setInt(1, Integer.parseInt(fields));
				rs = cstm.executeQuery();
				if (rs.next()) {
					articlelsit.add(new ArticleDTO(rs.getInt("id"), rs
							.getString("author"), rs.getString("title"), rs
							.getString("content"), rs.getDate("published_date")
							.toString()));
				}
				break;
			}
			cstm.close();
			rs.close();
			return articlelsit;
		
	}

	public ArrayList<ArticleDTO> listDb() throws ClassNotFoundException,
			SQLException {
		articlelsit = new ArrayList<ArticleDTO>();
		String data = "{call vw_show_by_id}";
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(data); ResultSet rs = cstm.executeQuery();) {
			while (rs.next()) {
				articlelsit.add(new ArticleDTO(rs.getInt("id"), rs
						.getString("author"), rs.getString("title"), rs
						.getString("content"), rs.getString("published_date")));
			}
		}
		return articlelsit;
	}

	public ArrayList<ArticleDTO> listSort(String fields, String orders)
			throws SQLException, ClassNotFoundException {
		articlelsit = new ArrayList<ArticleDTO>();
		CallableStatement cstm = null;
		ResultSet rs = null;
		String query = "";
			switch (fields) {
			case "id":
				if (orders.equals("desc")) {
					query = "{call vw_show_by_id_dsc}";
					cstm = DatabaseConnection.getConnection()
							.prepareCall(query);
					rs = cstm.executeQuery();
					while (rs.next()) {
						articlelsit.add(new ArticleDTO(rs.getInt("id"), rs
								.getString("author"), rs.getString("title"), rs
								.getString("content"), rs
								.getString("published_date")));
					}
				} else {
					query = "{call vw_show_by_id}";
					cstm = DatabaseConnection.getConnection()
							.prepareCall(query);
					rs = cstm.executeQuery();
					while (rs.next()) {
						articlelsit.add(new ArticleDTO(rs.getInt("id"), rs
								.getString("author"), rs.getString("title"), rs
								.getString("content"), rs
								.getString("published_date")));
					}
				}
				break;
			case "author":
				if (orders.equals("desc")) {
					query = "{call vw_short_by_author_desc}";
					cstm = DatabaseConnection.getConnection()
							.prepareCall(query);
					rs = cstm.executeQuery();
					while (rs.next()) {
						articlelsit.add(new ArticleDTO(rs.getInt("id"), rs
								.getString("author"), rs.getString("title"), rs
								.getString("content"), rs
								.getString("published_date")));
					}
				} else {
					query = "{call vw_short_by_author_asc}";
					cstm = DatabaseConnection.getConnection()
							.prepareCall(query);
					rs = cstm.executeQuery();
					while (rs.next()) {
						articlelsit.add(new ArticleDTO(rs.getInt("id"), rs
								.getString("author"), rs.getString("title"), rs
								.getString("content"), rs
								.getString("published_date")));
					}
				}
				break;
			case "title":
				if (orders.equals("desc")) {
					query = "{call vw_short_by_title_desc}";
					cstm = DatabaseConnection.getConnection()
							.prepareCall(query);
					rs = cstm.executeQuery();
					while (rs.next()) {
						articlelsit.add(new ArticleDTO(rs.getInt("id"), rs
								.getString("author"), rs.getString("title"), rs
								.getString("content"), rs
								.getString("published_date")));
					}
				} else {
					query = "{call vw_short_by_title_asc}";
					cstm = DatabaseConnection.getConnection()
							.prepareCall(query);
					rs = cstm.executeQuery();
					while (rs.next()) {
						articlelsit.add(new ArticleDTO(rs.getInt("id"), rs
								.getString("author"), rs.getString("title"), rs
								.getString("content"), rs
								.getString("published_date")));
					}
				}
				break;
			case "content":
				if (orders.equals("desc")) {
					query = "{call vw_short_by_content_desc}";
					cstm = DatabaseConnection.getConnection()
							.prepareCall(query);
					rs = cstm.executeQuery();
					while (rs.next()) {
						articlelsit.add(new ArticleDTO(rs.getInt("id"), rs
								.getString("author"), rs.getString("title"), rs
								.getString("content"), rs
								.getString("published_date")));
					}
				} else {
					query = "{call vw_short_by_content_asc}";
					cstm = DatabaseConnection.getConnection()
							.prepareCall(query);
					rs = cstm.executeQuery();
					while (rs.next()) {
						articlelsit.add(new ArticleDTO(rs.getInt("id"), rs
								.getString("author"), rs.getString("title"), rs
								.getString("content"), rs
								.getString("published_date")));
					}
				}
				break;

			}
			cstm.close();
			rs.close();
		return articlelsit;
	}

	public ArrayList<ArticleDTO> setRow(int row, int page)
			throws ClassNotFoundException, SQLException {
		articlelsit = new ArrayList<ArticleDTO>();
		String data = "{call set_row(?,?)}";
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(data);) {

			cstm.setInt(1, row);
			cstm.setInt(2, page);
			ResultSet rs = cstm.executeQuery();
			while (rs.next()) {
				articlelsit.add(new ArticleDTO(rs.getInt("id"), rs
						.getString("author"), rs.getString("title"), rs
						.getString("content"), rs.getString("published_date")));
			}

		}
		return articlelsit;
	}

	public int returnCountRow() throws SQLException, ClassNotFoundException {
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(" {call total_record()}");
				ResultSet rs = cstm.executeQuery();) {

			rs.next();

			return rs.getInt(1);
		}
	}

	public int returnLastId() throws ClassNotFoundException, SQLException {
		String data = "{call last_record()}";
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(data); ResultSet rs = cstm.executeQuery();) {
			rs.next();
			return rs.getInt(1);
		}
	}

	public boolean checkExitId(int id) throws ClassNotFoundException,
			SQLException {
		String data = "{call bol_search_id(?)}";
		try (CallableStatement cstm = DatabaseConnection.getConnection()
				.prepareCall(data)) {
			cstm.setInt(1, id);
			ResultSet rs = cstm.executeQuery();
			rs.next();
			return rs.getBoolean(1);
		}

	}
	/*
	 * public static void main(String[] args) throws ClassNotFoundException,
	 * SQLException { System.out.println(new ArticleDAO().checkExitId(238)); }
	 */
}
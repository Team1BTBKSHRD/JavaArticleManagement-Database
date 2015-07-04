package Controller;

import Utilities.DatabaseConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.postgresql.core.Logger;

import Model.ArticleDAO;
import Model.ArticleDTO;
import View.ArticleView;

public class ArticleController {
	private ArticleView articleview = null;
	private ArticleDAO articledao = null;
	private ArrayList<ArticleDTO> arraylistdto = null;
	private String message;
	private static int nextpage; // number of page increase
	private static int numberofpages; // amount of pages

	public String getMessage() {
		return message;
	}

	public void controllerAction(String operation) {
		articleview = new ArticleView();
		articledao = new ArticleDAO();
		try {
			// transfer arraylist from db to
			arraylistdto = articledao.listDb(); // arraylist local
			int totalcount = articledao.returnCountRow(); // number of elements
															// of
															// arraylist
			switch (operation.toLowerCase()) {
			case "a":
				ArrayList<ArticleDTO> alist = articleview.add();
				message = String.valueOf(articledao.insertRecords(alist));
				arraylistdto = articledao.listDb();
				totalcount = arraylistdto.size();
				for (ArticleDTO articleDTO : alist) {
					Controller.Logger.getLogger().writeLogAdd(totalcount++);
				}

				break;

			case "r":
				int removeid = articleview.removeById();
				message = String.valueOf(articledao.removeRecord(removeid));
				arraylistdto = articledao.listDb();
				totalcount = arraylistdto.size();
				Controller.Logger.getLogger().writeLogDelete(removeid);
				break;
			case "s":
				String searchoption = new ArticleView().search();
				String[] parts = searchoption.split(";");
				String field = parts[0];
				String key = parts[1];
				arraylistdto = articledao.searchRecord(field, key);
				totalcount = arraylistdto.size();
				break;
			case "u":
				ArticleDTO articledto = articleview.update();
				int articleid = articledto.getId();
				String fieldname;
				String author = articledto.getAuthor();
				String title = articledto.getTitle();
				String content = articledto.getContent();
				if (author != null) {
					message = String.valueOf(articledao.updateRecordAll(
							articleid, author, title, content));
					articledao.updateRecordAuthor(articleid, author);
					fieldname=author;
				} else if (title != null) {
					message = String.valueOf(articledao.updateRecordAll(
							articleid, author, title, content));
					articledao.updateRecordTitle(articleid, title);
					fieldname=title;
				} else if (content != null) {
					message = String.valueOf(articledao.updateRecordAll(
							articleid, author, title, content));
					articledao.updateRecordContent(articleid, content);
					fieldname=content;
				} else {
					message = String.valueOf(articledao.updateRecordAll(
							articleid, author, title, content));
					fieldname="All";
				}
				arraylistdto = articledao.listDb();
				totalcount = arraylistdto.size();
				Controller.Logger.getLogger().writeLogUpdate(articleid, fieldname);
				break;
			case "ss":
				String sortoption = new ArticleView().sort().toLowerCase();
				String[] sort = sortoption.split(";");
				String fields = sort[0];
				String order = sort[1];
				System.out.println(fields + "  " + order);
				arraylistdto = articledao.listSort(fields, order);
				totalcount = arraylistdto.size();
				break;
			case "h":
				arraylistdto = articledao.listDb();
				totalcount = arraylistdto.size();
				break;
			case "v":
				articleview.viewDetail(articledao.searchRecord("id",
						String.valueOf(articleview.viewOneRecord())).get(0));
				articleview.setArticles(arraylistdto);
				if (articleview
						.getStringKeyboard("Press anykey for Back to home page : ") != null) {

					totalcount = arraylistdto.size();
				}
				break;
			case "#":
				numberofpages = articleview.setPageSize();
				arraylistdto = articledao.setRow(numberofpages,
						numberofpages * 0);
				break;

			case "n":
				// System.out.println(nextpage++);
				arraylistdto = articledao.setRow(numberofpages, numberofpages
						* nextpage);
				break;
			case "p":

				break;
			case "f":

				break;
			case "l":

				break;
			case "g":

				break;
			}// End of switch();
			articleview.setArticles(arraylistdto);
			articleview.setTotalRecord(totalcount);
			articleview.process();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			Controller.Logger.getLogger().writeLogException(e, "", "");
		}
	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, IOException {
		System.gc();
		DatabaseConnection.checkDatabase();
		Controller.Logger.getLogger().writeLogOpenDatabase(DatabaseConnection.getDatabaseName());
		ArticleView av = new ArticleView();
		av.setArticles(new ArticleDAO().listDb());
		av.setTotalRecord(new ArticleDAO().returnCountRow());
		av.process();

	}
}

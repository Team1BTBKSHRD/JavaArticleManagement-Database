package Controller;

import Utilities.DatabaseConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.ArticleDAO;
import Model.ArticleDTO;
import View.ArticleView;

public class ArticleController {
	private ArticleView articleview = null;
	private ArticleDAO articledao = null;
	private ArrayList<ArticleDTO> arraylistdto = null;
	private String message;

	public String getMessage() {
		return message;
	}

	public void controllerAction(String operation) {
		articleview = new ArticleView();
		articledao = new ArticleDAO();
		arraylistdto = new ArrayList<ArticleDTO>();
		switch (operation.toLowerCase()) {
		case "a":
			arraylistdto = articleview.add();
			message = String
					.valueOf(articledao.insertRecords(articleview.add()));
			break;

		case "r":
			message = String.valueOf(articledao.removeRecord(articleview
					.removeById()));
			break;
		case "s":
			String searchoption = new ArticleView().search();
			String[] parts = searchoption.split(";");
			String field = parts[0];
			String key = parts[1];
			articleview.setArticles(articledao.searchRecord(field, key));
			articleview.process();
			message = articledao.getMessage();
			break;
		case "u":
			ArticleDTO articledto = articleview.update();
			int articleid = articledto.getId();
			String author = articledto.getAuthor();
			String title = articledto.getTitle();
			String content = articledto.getContent();
			if (author != null) {
				message = String.valueOf(articledao.updateRecordAll(articleid,
						author, title, content));
				articledao.updateRecordAuthor(articleid, author);
			} else if (title != null) {
				message = String.valueOf(articledao.updateRecordAll(articleid,
						author, title, content));
				articledao.updateRecordTitle(articleid, title);
			} else if (content != null) {
				message = String.valueOf(articledao.updateRecordAll(articleid,
						author, title, content));
				articledao.updateRecordContent(articleid, content);
			} else {
				message = String.valueOf(articledao.updateRecordAll(articleid,
						author, title, content));
			}
			articleview.setArticles(articledao.listDb());
			articleview.process();
		case "ss":
			// ArrayList<ArticleDTO> listsort=new ArrayList<ArticleDTO>();
			String sortoption = new ArticleView().sort().toLowerCase();
			String[] sort = sortoption.split(";");
			String fields = sort[0];
			String order = sort[1];
			System.out.println(fields + "  " + order);
			articleview.setArticles(articledao.listSort(fields, order));
			articleview.process();
			break;
		case "h":
			articleview.setArticles(articledao.listDb());
			articleview.process();
			break;
		case "v":
			articleview.viewDetail(articledao.searchRecord("id",
					String.valueOf(articleview.viewOneRecord())).get(0));
			break;
		case "#":
			int i = articleview.setPageSize();
			articleview.setTotalRecord(articledao.returnCountRow());
			articleview.setArticles(articledao.setRow(i, i * 0));
			
			articleview.process();
			break;

		case "n":

			break;
		case "p":

			break;
		case "f":

			break;
		case "l":

			break;
		}// End of switch();

	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, IOException {
		DatabaseConnection.checkDatabase();
		ArticleView av = new ArticleView();
		av.setArticles(new ArticleDAO().listDb());
		av.process();
	}
}

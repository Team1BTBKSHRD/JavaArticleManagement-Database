package Controller;

import Utilities.DatabaseConnection;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.ArticleDAO;
import Model.ArticleDTO;
import Model.UserDAO;
import View.ArticleView;
import View.LoginView;
import View.View;
import View.validateUserinput;

public class ArticleController {
	private ArticleView articleView = null;
	private ArticleDAO articleDao = null;
	private ArrayList<ArticleDTO> arrayListDao = null;
	private String message;
	private static int numberofpages = 5; // amount of pages
	private int failaccess = 0;

	public String getMessage() {
		return message;
	}

	public ArticleController() {
		articleView = new ArticleView();
		articleDao = new ArticleDAO();
	}

	@SuppressWarnings("unused")
	public void controllerAction(String operation) {
		int totalRecord = 0;
		try {
			totalRecord = articleDao.returnCountRow();
			switch (operation.toLowerCase()) {
			case "a":
				int lastid = articleDao.returnLastId();
				ArrayList<ArticleDTO> alist = articleView.add();
				message = String.valueOf(articleDao.insertRecords(alist));
				totalRecord = articleDao.returnCountRow();
				for (ArticleDTO articleDTO : alist) {
					lastid++;
					Controller.Logger.getLogger().writeLogAdd(lastid);
				}

				break;

			case "r":
				int removeid = articleView.removeById();
				message = String.valueOf(articleDao.removeRecord(removeid))
						.toLowerCase();
				if (message.equals("false")) {
					Controller.Logger.getLogger().writeLogException(
							new Exception(),
							"Remove(id " + removeid + "not found)",
							"Controller");
				} else {
					totalRecord = articleDao.returnCountRow();
					Controller.Logger.getLogger().writeLogDelete(removeid);
				}

				break;
			case "s":
				String searchoption = articleView.search();// new
															// ArticleView().search();
				String[] parts = searchoption.split(";");
				String field = parts[0];
				String key = parts[1];
				arrayListDao = articleDao.searchRecord(field, key);
				totalRecord = arrayListDao.size();
				break;
			case "u":
				int idex = articleView.checkUpdate();
				ArticleDTO article = articleView.update(idex);
				int articleid = article.getId();
				String fieldname = null;
				String author = article.getAuthor();
				String title = article.getTitle();
				String content = article.getContent();
				if (author.isEmpty() == false && title.isEmpty() == false
						&& content.isEmpty() == false) {
					message = String.valueOf(articleDao.updateRecordAll(
							articleid, author, title, content));
					fieldname = "All";
				} else {
					if (author.isEmpty() == false) {
						articleDao.updateRecordAuthor(articleid, author);
						fieldname = author;
					} else if (title.isEmpty() == false) {
						articleDao.updateRecordTitle(articleid, title);
						fieldname = title;
					} else if (content.isEmpty() == false) {
						articleDao.updateRecordContent(articleid, content);
						fieldname = content;
					}
					arrayListDao = articleDao.setRow(5, 0); // totalRecord =
															// arrayListDao.size();
					Controller.Logger.getLogger().writeLogUpdate(articleid,
							fieldname);
				}
				break;

			case "ss":
				String sortOption = new ArticleView().sort().toLowerCase();
				String[] sort = sortOption.split(";");
				String fields = sort[0];
				String order = sort[1];

				arrayListDao = articleDao.listSort(fields, order);

				break;
			case "h":

				arrayListDao = articleDao.setRow(5, 0);

				break;
			case "v":
				articleView.viewDetail(articleDao.searchRecord("id",
						String.valueOf(articleView.viewOneRecord())).get(0));
				articleView.setArticles(arrayListDao);
				View.getStringKeyboard("Press anykey for Back to home page : ");
				break;
			case "#":
				numberofpages = articleView.setPageSize();
				arrayListDao = articleDao.setRow(numberofpages, 0);
				break;

			case "n":

				articleView.gotoNextPage();
				arrayListDao = articleDao.setRow(numberofpages, numberofpages
						* articleView.getCurrentPage());
				break;
			case "p":
				articleView.gotoPreviousPage();
				arrayListDao = articleDao.setRow(numberofpages, numberofpages
						* articleView.getCurrentPage());
				break;
			case "f":
				articleView.gotoFirstPage();

				arrayListDao = articleDao.setRow(numberofpages, numberofpages
						* articleView.getCurrentPage());
				break;
			case "l":
				articleView.gotoLastPage();
				arrayListDao = articleDao.setRow(numberofpages, numberofpages
						* articleView.getCurrentPage());
				break;
			case "g":
				articleView.gotoPage();
				arrayListDao = articleDao.setRow(numberofpages, numberofpages
						* articleView.getCurrentPage());
				break;
			case "he":
				articleView.helpOption(readFile("help option.txt"));
				articleView.waiting();
				break;
			case "ab":
				articleView.helpOption(readFile("aboutus.txt"));
				articleView.waiting();
				break;			
			case "e":
				articleView.alertMessage("System Exited ...");
				System.exit(0);
				break;
			}// End of switch();
			articleView.setArticles(arrayListDao);
			articleView.setTotalRecord(totalRecord);
			start();

		} catch (ClassNotFoundException classnotexp) {
			Controller.Logger.getLogger().writeLogException(classnotexp,
					operation, "Controller");
			articleView.setArticles(arrayListDao);
			articleView.setTotalRecord(totalRecord);
			start();
		} catch (IndexOutOfBoundsException indexoutbound) {

			Controller.Logger.getLogger().writeLogException(indexoutbound,
					operation, "Controller");
			articleView.setArticles(arrayListDao);
			articleView.setTotalRecord(totalRecord);
			start();
		} catch (IOException IoE) {

			Controller.Logger.getLogger().writeLogException(IoE, operation,
					"Controller");
			articleView.setArticles(arrayListDao);
			articleView.setTotalRecord(totalRecord);
			start();
		} catch (NullPointerException nullpExp) {
			Controller.Logger.getLogger().writeLogException(nullpExp,
					operation, "Controller");
			articleView.setArticles(arrayListDao);
			articleView.setTotalRecord(totalRecord);
			start();
		} catch (SQLException sqlexp) {
			try {
				if (DatabaseConnection.getConnection() != null) {
					DatabaseConnection.getConnection().rollback();
				}
			} catch (ClassNotFoundException e) {
				Controller.Logger.getLogger().writeLogException(e, operation,
						"Controller");
			} catch (SQLException e) {
				Controller.Logger.getLogger().writeLogException(e, operation,
						"Controller");
			}
			Controller.Logger.getLogger().writeLogException(sqlexp, operation,
					"Controller");
			articleView.setArticles(arrayListDao);
			articleView.setTotalRecord(totalRecord);
			start();
		}
	}

	public void start() {
		controllerAction(articleView.process());
	}

	public void startDefualt() {
		LoginView lgv = new LoginView();
		boolean username;
		boolean passwordconfirm;
		try {
			failaccess++;
			DatabaseConnection.checkDatabase();
			if (failaccess == 4) {
				System.exit(1);
			} else {
				username = new UserDAO().compareUserNameOrEmail(lgv
						.viewLoginUser());
				if (username) {
					passwordconfirm = new UserDAO().comparePassword(lgv
							.viewLoginPassword());
					if (passwordconfirm) {
						Controller.Logger.getLogger().writeLogOpenDatabase(
								DatabaseConnection.getDatabaseName());
						arrayListDao = articleDao.setRow(numberofpages, 0);
						int totalRecord = articleDao.returnCountRow(); // number
																		// of
																		// elements
																		// of
																		// arraylist
						articleView.setTotalRecord(totalRecord);
						articleView.setArticles(arrayListDao);

						controllerAction(articleView.process());
					}
				} else {
					articleView.alertMessage("Invalid Username or Email !!!");
					String did = View.getStringKeyboard("Press E)xit, T)ry again... ");
					if (did.compareToIgnoreCase("y") == 1) {
						startDefualt();
					} else {
						System.exit(0);
					}
				}
			}
		} catch (SQLException sqlexp) {
			Controller.Logger.getLogger().writeLogException(sqlexp,
					"StartDefault", "Controller");
			startDefualt();
		} catch (ClassNotFoundException classnotexp) {
			Controller.Logger.getLogger().writeLogException(classnotexp,
					"StartDefault", "Controller");
			startDefualt();
		} catch (IOException Ioe) {
			Controller.Logger.getLogger().writeLogException(Ioe,
					"StartDefault", "Controller");
			startDefualt();
		} catch (validateUserinput vlduser) {
			Controller.Logger.getLogger()
					.writeLogException(vlduser,
							"StartDefault {" + vlduser.getMessage() + "}",
							"Controller");
			startDefualt();
		}
	}

	/* Sarin read hepl option from txtfile help option.txt */
	public String readFile(String fileName) throws IOException {
		FileInputStream fis = new FileInputStream(fileName);
		// Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = "";
		String geth = "";
		while ((line = (br.readLine())) != null) {
			geth += line + "\n";
		}
		br.close();
		return geth;
	}

	public static void main(String[] args) {
		System.gc();
		new ArticleController().startDefualt();

	}
}

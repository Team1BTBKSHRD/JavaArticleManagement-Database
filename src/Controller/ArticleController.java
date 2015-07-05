package Controller;

import Utilities.DatabaseConnection;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.attribute.PosixFilePermissions;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.crypto.Data;

import org.postgresql.core.Logger;

import Model.ArticleDAO;
import Model.ArticleDTO;
import Model.UserDAO;
import View.ArticleView;
import View.LoginView;
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
			/*
			 * Operation Insert Data
			 */
			case "a":
				int lastid = articleDao.returnLastId(); /*
														 * return the last id
														 * from DAO
														 */
				ArrayList<ArticleDTO> alist = articleView.add(); /*
																 * view add()
																 * and return
																 * arraylist
																 */
				message = String.valueOf(articleDao.insertRecords(alist)); /*
																			 * message
																			 * (
																			 * true
																			 * )
																			 * ,
																			 * Data
																			 * insert
																			 * to
																			 * Db
																			 */
				totalRecord = articleDao.returnCountRow(); /*
															 * number of records
															 * in Db
															 */
				for (ArticleDTO articleDTO : alist) {
					lastid++;
					Controller.Logger.getLogger().writeLogAdd(lastid); /*
																		 * each
																		 * id of
																		 * data
																		 * insertion
																		 * ,
																		 * write
																		 * to
																		 * logAdd
																		 */
				}

				break;
			/*
			 * Operation Remove Data
			 */
			case "r":
				int removeid = articleView.removeById(); /*
														 * return id from
														 * viewRemove
														 */
				message = String.valueOf(articleDao.removeRecord(removeid))
						.toLowerCase(); /* message(true), Data remove in Db */
				if (message.equals("false")) { /*
												 * id not found will write to
												 * LogException
												 */
					Controller.Logger.getLogger().writeLogException(
							new Exception(),
							"Remove(id " + removeid + "not found)",
							"Controller");
				} else {
					totalRecord = articleDao.returnCountRow();
					Controller.Logger.getLogger().writeLogDelete(removeid); /*
																			 * id
																			 * removed
																			 * ,
																			 * write
																			 * id
																			 * to
																			 * logDeleted
																			 */
				}

				break;
			/*
			 * Operation Search Data
			 */
			case "s":
				String searchoption = articleView.search(); /*
															 * return string of
															 * [operation;data]
															 */
				String[] parts = searchoption.split(";");
				String field = parts[0];// Operation
				String key = parts[1];// data
				arrayListDao = articleDao.searchRecord(field, key); /*
																	 * searching
																	 * record
																	 * (field
																	 * ,key)
																	 */
				totalRecord = arrayListDao.size(); /*
													 * return number of
													 * searching data
													 */
				break;
			/*
			 * Operation Update Data
			 */
			case "u":
				int idex = articleView.checkUpdate(); /*
													 * return update id from
													 * viewUpdate
													 */
				ArticleDTO article = articleView.update(idex); /*
																 * set id to
																 * viewUpdate
																 * and return
																 * object
																 */
				int articleid = article.getId();
				String fieldname = null;
				String author = article.getAuthor();
				String title = article.getTitle();
				String content = article.getContent();
				/*
				 * action update all fields
				 */
				if (author.isEmpty() == false && title.isEmpty() == false
						&& content.isEmpty() == false) {
					message = String.valueOf(articleDao.updateRecordAll(
							articleid, author, title, content));
					fieldname = "All";
				} else {
					if (author.isEmpty() == false) {
						/*
						 * action update only author field
						 */
						articleDao.updateRecordAuthor(articleid, author);
						fieldname = author;
					} else if (title.isEmpty() == false) {
						/*
						 * action update only title field
						 */
						articleDao.updateRecordTitle(articleid, title);
						fieldname = title;
					} else if (content.isEmpty() == false) {
						/*
						 * action update only content field
						 */
						articleDao.updateRecordContent(articleid, content);
						fieldname = content;
					}
					arrayListDao = articleDao.setRow(5, 0);
					Controller.Logger.getLogger().writeLogUpdate(articleid,
							fieldname);/* write affected id to logUpdate */
				}
				break;
			/*
			 * Operation Sort Data
			 */
			case "ss":
				String sortOption = new ArticleView().sort().toLowerCase(); /*
																			 * return
																			 * string
																			 * sortOption
																			 * (
																			 * operation
																			 * ,
																			 * data
																			 * )
																			 */
				String[] sort = sortOption.split(";");
				String fields = sort[0];
				String order = sort[1];

				arrayListDao = articleDao.listSort(fields, order);/*
																 * return
																 * arraylist by
																 * limited
																 * record
																 */

				break;
			/*
			 * operation goto Homepage
			 */
			case "h":				
				arrayListDao = articleDao.setRow(5, 0); /* set limited record for display */

				break;
			/*
			 * operation viewDetails
			 * 
			 * */
			case "v":
				articleView.viewDetail(articleDao.searchRecord("id",
						String.valueOf(articleView.viewOneRecord())).get(0));
				articleView.setArticles(arrayListDao);
				articleView
						.getStringKeyboard("Press anykey for Back to home page : ");
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
				articleView.helpOption(help());
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
					String did = articleView
							.getStringKeyboard("Press E)xit, T)ry again... ");
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
	public String help() throws IOException {
		FileInputStream fis = new FileInputStream("help option.txt");
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

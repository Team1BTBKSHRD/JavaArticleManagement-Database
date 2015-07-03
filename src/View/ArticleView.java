package View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Controller.ArticleController;
import Model.ArticleDTO;

public class ArticleView {

	private char topLeft;
	private char topRight;

	private char buttomLeft;
	private char buttomRight;

	private char middleTop;
	private char middleButtom;
	private char middleCenter;
	private char middleLeft;
	private char middleRight;

	private char verticalLine;
	private char horizontalLine;

	ArrayList<ArticleDTO> articles;
	
	List<ArticleDTO> subPages; /* Use for store a set of articles for view */

	private ArticleController articleController=new ArticleController();
	
	
	private int currentPage; /* Current page position */
	private int pageSize; /* Number of records for view */
	private int totalPage; /* Store All Total Pages */
	private int totalRecord;
	
	
	public int getCurrentPage(){
		return currentPage;
	}
	public void setTotalRecord(int totalRecord){
		this.totalRecord = totalRecord;
	}
	/*public int getTotalRecord(){
		return totalRecord;
	}*/
	/*
	 * Method setPageSize() Use for set number of record for view pageSize
	 * parameter is a number of record that we want to view
	 */
	public int setPageSize() {
		int pageSize = getNumberKeyboard("Input Page Size: ");
		this.pageSize = pageSize;
		repaginate(); /* After set a new value we need to repaginate */
		return pageSize;
	}

	/*
	 * Method setArticles() Use for set all of articles
	 */
	public void setArticles(ArrayList<ArticleDTO> articles) {
		this.articles = articles;
		System.out.println(this.articles.size()+" Arraylist in setArticles");
	}

	/*
	 * Method gotoPage Use for set number of page that the client want to visit
	 * pageNumbe parameter is a number of page
	 */
	public void gotoPage(int pageNumber) {
		currentPage = pageNumber - 1; /* currentPage value started from 0 */
		if (currentPage < 0) { /* Goto first page if current page < 0 */
			gotoFirstPage();
		} else if (currentPage > totalPage) { /*
											 * Goto last page if current page >
											 * totalPage
											 */
			gotoLastPage();
		}
		repaginate(); /* repaginate after set value */
	}

	/*
	 * Default constructor default currentPage = 0 default page size = 5 set
	 * default table style and regainate page again
	 */
	public ArticleView() {
		currentPage = 0;
		pageSize = 5;
		articles = new ArrayList<ArticleDTO>();
		topLeft = topRight = buttomLeft = buttomRight = middleTop = middleButtom = middleLeft = middleCenter = middleRight = '+';
		horizontalLine = '-';
		verticalLine = '|';
		repaginate();
		
	}

	/*
	 * Constructor with parameters Use for set default table style set current
	 * page = 0 page size = 5 and then start to repaginate
	 */
	public ArticleView(char topLeft, char topRight, char buttomLeft,
			char buttomRight, char middleTop, char middleButton,
			char middleLeft, char middleCenter, char middleRight,
			char verticalLine, char horizontalLine) {

		currentPage = 0;
		pageSize = 5;
		articles = new ArrayList<ArticleDTO>();
		this.topLeft = topLeft;
		this.topRight = topRight;

		this.buttomLeft = buttomLeft;
		this.buttomRight = buttomRight;

		this.middleTop = middleTop;
		this.middleButtom = middleButton;
		this.middleLeft = middleLeft;
		this.middleCenter = middleCenter;
		this.middleRight = middleRight;

		this.verticalLine = verticalLine;
		this.horizontalLine = horizontalLine;
		repaginate();
	}

	/*
	 * Method gotoNextPage() Use for increase the current page
	 */
	public int gotoNextPage() {
		if (currentPage < totalPage) { /*
										 * if current page is not the last page
										 * increase current page
										 */
			return currentPage++;
		}
		/* else set current page into the first page */
		return 0;//gotoFirstPage();
		//repaginate(); /* After set repaginate page again */
	}

	/*
	 * Method gotoPreviousPage() Use for decrease current page
	 */
	public int gotoPreviousPage() {
		if (currentPage >= 0) { /*
								 * if current page is not the start page
								 * increase current page
								 */
			return currentPage--;
		} 
		/* else set current page into the last page */
		return gotoLastPage();
		//repaginate(); /* After set repaginate page again */
	}

	/*
	 * Method gotoFirstPage Use for set current page into the first page
	 */
	public int gotoFirstPage() {
		//currentPage = 0;
		return 0;
	}

	/*
	 * Method gototLastPage() Use for set current page into the last page
	 */
	public int gotoLastPage() {
		//currentPage = totalPage - 1;
		return totalPage - 1;
	}

	/*
	 * Method repaginate() Use for get objects for view by page size and current
	 * page (add into subPages)
	 */
	private void repaginate() {
		System.out.println(totalRecord);
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
		if (!articles.isEmpty()) {
			totalPage = (int) Math
					.ceil(totalRecord / (float) pageSize); /*
																	 * Calculate
																	 * the total
																	 * page
																	 */
			int start = currentPage * pageSize; /* Start index */
			int end = start + pageSize - 1; /* End index */
			if (end >= totalRecord) { /*
										 * if end value is out of bound of
										 * ArrayList
										 */
				end = totalRecord - 1; /*
											 * set end index = the last index of
											 * array
											 */
			}
			if (start >= totalRecord) { /*
											 * if start index >= total size of
											 * ArrayList)
											 */
				gotoFirstPage(); /* set current page into the first page */
				//repaginate(); /* repaginate page again */
			} else if (start < 0) { /* if start index < 0 */
				gotoLastPage(); /* set current page into the last page */
				if (totalRecord % pageSize == 0) { /*
														 * if total size is even
														 * number
														 */
					currentPage--; /* decrease current page */
				}
				repaginate(); /* repaginate page again */
			} else { /* else start < total records */
				subPages = articles.subList(start, end + 1); /*
															 * Separate them
															 * into subPages for
															 * display
															 */
				
			}
		}
		//System.out.println(subPages.size());
	}

	/*
	 * Method process() Use for out put the records of subPages
	 */
	public void process() {
		//setTotalRecord(articles.size());
		repaginate();
		//drawTable(subPages);
		drawTable(articles);
		System.out.println("--------->Input Operation : ");
		articleController.controllerAction(getStringKeyboard(""));
		System.out.println(articleController.getMessage());
	}

	/*
	 * Method setTableStyle() Use for set table style by its parameter
	 */
	public void setTableStyle(char topLeft, char topRight, char buttomLeft,
			char buttomRight, char middleTop, char middleButton,
			char middleLeft, char middleCenter, char middleRight,
			char verticalLine, char horizontalLine) {

		this.topLeft = topLeft;
		this.topRight = topRight;

		this.buttomLeft = buttomLeft;
		this.buttomRight = buttomRight;

		this.middleTop = middleTop;
		this.middleButtom = middleButton;
		this.middleLeft = middleLeft;
		this.middleCenter = middleCenter;
		this.middleRight = middleRight;

		this.verticalLine = verticalLine;
		this.horizontalLine = horizontalLine;
	}

	/*
	 * Method header() Use for output the organization's name and the project's
	 * name
	 */
	public void header(int[] maxColumns, int totalLenght) {
		final String ORGANIZATION_NAME = "KOREAN SOFTWARE HRD CENTER";
		final String PROJECT_NAME = "ARTICLES MANAGEMENT SYSTEM";
		String head = "";
		// head = addHorizontalLine(head, maxColumns, topLeft, horizontalLine,
		// topRight);
		// head = addLetter(head, verticalLine, 1);
		head = addLetter(head, '_',
				(totalLenght - ORGANIZATION_NAME.length()) / 2);
		head += ORGANIZATION_NAME;
		head = addLetter(head, '_',
				(totalLenght - ORGANIZATION_NAME.length()) / 2);
		// head = addLetter(head, verticalLine, 1) + "\n";
		head += "\n";
		// head = addLetter(head, verticalLine, 1);
		head = addLetter(head, '*', (totalLenght - PROJECT_NAME.length()) / 2);
		head += PROJECT_NAME;
		head = addLetter(head, '*', (totalLenght - PROJECT_NAME.length()) / 2);
		// head = addLetter(head, verticalLine, 1) + "\n";

		// head += addHorizontalLine(head, maxColumns, buttomLeft,
		// horizontalLine, buttomRight);
		System.out.println(head);
	}

	public void menu(int[] maxColumns, int totalLenght) {
		final String MENU1 = "F) First | P) Previous | N) Next | L) Last";
		final String MENU2 = "A) Add | R) Remove | S)Search |  U) Update | SS) Sort";
		final String MENU3 = "H) Home | V) View Detail | G) Goto | #) Set Row";
		final String MENU4 = "W) Write | Re) Read | B) Backup | E) Exit";
		String strMenu = "";
		strMenu = addHorizontalLine(strMenu, maxColumns, topLeft,
				horizontalLine, topRight);
		// strMenu = addLetter(strMenu, verticalLine, 1);
		strMenu = addLetter(strMenu, ' ', (totalLenght - MENU1.length()) / 2);
		strMenu += MENU1;
		strMenu = addLetter(strMenu, ' ',
				totalLenght - ((totalLenght - MENU1.length())));
		// strMenu = addLetter(strMenu, verticalLine, 1) + "\n";
		strMenu += "\n";

		// strMenu = addLetter(strMenu, verticalLine, 1);
		strMenu = addLetter(strMenu, ' ', (totalLenght - MENU2.length()) / 2);
		strMenu += MENU2;
		strMenu = addLetter(strMenu, ' ',
				totalLenght - ((totalLenght - MENU2.length())));
		// strMenu = addLetter(strMenu, verticalLine, 1) + "\n";
		strMenu += "\n";

		// strMenu = addLetter(strMenu, verticalLine, 1);
		strMenu = addLetter(strMenu, ' ', (totalLenght - MENU3.length()) / 2);
		strMenu += MENU3;
		strMenu = addLetter(strMenu, ' ',
				totalLenght - ((totalLenght - MENU3.length())));
		// strMenu = addLetter(strMenu, verticalLine, 1) + "\n";
		strMenu += "\n";
		strMenu = addLetter(strMenu, ' ', (totalLenght - MENU4.length()) / 2);
		strMenu += MENU4;
		strMenu = addLetter(strMenu, ' ',
				totalLenght - ((totalLenght - MENU4.length())));

		strMenu += "\n";

		strMenu += addHorizontalLine(strMenu, maxColumns, buttomLeft,
				horizontalLine, buttomRight);
		System.out.println(strMenu);
	}

	/*
	 * Method maxColumnsLength() Use for fine maximum length of every columns
	 */
	private static final String[] headers = { "ID", "AUTHOR ", "TITLE ",
			"PUBLISH DATE" };

	/*
	 * private int[] maxColumnsLength(List<Article> articles) { int[] maxLengths
	 * = new int[] { headers[0].length(), headers[1].length(),
	 * headers[2].length(), headers[3].length()};
	 * 
	 * for (Article article : articles) { if
	 * (Integer.toString(article.getId()).length() > maxLengths[0]) Find maximum
	 * length of column ID
	 * 
	 * maxLengths[0] = Integer.toString(article.getId()).length() + 6; // +
	 * padding 6 space;
	 * 
	 * if (article.getAuthor().length() > maxLengths[1]) Find maximum length of
	 * column Author
	 * 
	 * if(article.getAuthor().length() > 10) maxLengths[1] = 13; else
	 * maxLengths[1] = article.getAuthor().length();
	 * 
	 * if (article.getTitle().length() > maxLengths[2]) Find maximum length of
	 * column Title
	 * 
	 * if(article.getTitle().length() > 23) maxLengths[2] = 23; else
	 * maxLengths[2] = article.getTitle().length();
	 * 
	 * if (article.getPublishDate().length() > maxLengths[3]) Find maximum
	 * length of column Publish Date
	 * 
	 * maxLengths[3] = article.getPublishDate().length();
	 * 
	 * } return maxLengths; return maximum length of every columns }
	 */
	/*
	 * Method addLetter() Use for add letter into string string parameter is
	 * original string, letter is the character we need to add, letterNumber
	 * parameter is the number of latter are going add to string
	 */
	private String addLetter(String string, char letter, int letterNumber) {
		for (int i = 0; i < letterNumber; i++)
			string += Character.toString(letter);
		return string;
	}

	/*
	 * Method replaceLastIndex() Use for replace the last character of string
	 * string parameter is original string key is a character for replace
	 */
	private String replaceLastIndex(String string, char key) {
		string = string.substring(0, string.length() - 1); /*
															 * Cut the last
															 * character of
															 * string
															 */
		string += Character.toString(key); /* Add key into string */
		return string;
	}

	/*
	 * Method addHorizontalLine() Use for add horizontal line into string string
	 * parameter is the original string maxColumns parameter is maximum length
	 * of every columns start parameter is a character of the beginning of the
	 * line middle parameter is a character of the middle in the line end
	 * parameter is a character of the end of the line
	 */
	private String addHorizontalLine(String string, int[] maxColumns,
			char start, char middle, char end) {
		string = Character.toString(start); /* Beginning Character of the line */
		for (int columnLength : maxColumns) {
			for (byte line = 0; line < columnLength; line++) {
				string += Character.toString(horizontalLine); /*
															 * Length of cell =
															 * maximum of column
															 * length
															 */
			}
			string += Character.toString(middle); /*
												 * Add the middle character of
												 * horizontal line
												 */
		}
		string = replaceLastIndex(string, end); /*
												 * Add the last character of
												 * horizontal line
												 */
		string += "\n"; /* Add a new line */
		return string; /* Value of string is horizontal line */
	}

	/*
	 * Method sumColumnsLenght Use for sum each columns length
	 */
	private int sumColumnsLength(int[] maxColumns) {
		int sum = 0;
		for (int columnLength : maxColumns) {
			sum += columnLength + 1;
		}
		return sum;
	}

	/*
	 * Method drawTable() Use for draw table, header, and menu bar articles
	 * parameter is the articles we want to put into the table
	 */
	public void drawTable(List<ArticleDTO> articles) {
		int[] maxColumns = new int[] { 14, 24, 34, 25 };// maxColumnsLength(articles);
														// /* Find maximum
														// length for every
														// columns*/
		int totalLenght = sumColumnsLength(maxColumns);/*
														 * calculate total
														 * length
														 */
		String table = "";
		/* Header Block */
		header(maxColumns, totalLenght); /* Output header */
		// First line of table;
		table += addHorizontalLine(table, maxColumns, topLeft, middleTop,
				topRight);
		// Add Header Title;
		int index = 0;
		for (String header : headers) {
			table += Character.toString(verticalLine); // "?";
			// Add spaces;
			table = addLetter(table, ' ',
					(maxColumns[index] - header.length()) / 2);
			// Add header name;
			table += header;
			// Add spaces;
			int totalLength = maxColumns[index]
					- (maxColumns[index] - header.length()) / 2
					- header.length();
			table = addLetter(table, ' ', totalLength);
			// (maxColumns[index] - header.length()) / 2);

			index++;
		}
		table += Character.toString(verticalLine) + "\n"; /* Add vertical line */

		/* End of Header Block */

		// Body
		final int PADDING = 2;
		for (ArticleDTO article : articles) {
			// Horizontal Line of every records;
			table += addHorizontalLine(table, maxColumns, middleLeft,
					middleCenter, middleRight);

			// Add ID
			table += Character.toString(verticalLine);
			table = addLetter(table, ' ', PADDING); // Add padding 1 space;
			table += article.getId(); // Add ID
			table = addLetter(table, ' ',
					maxColumns[0] - Integer.toString(article.getId()).length()
							- PADDING);
			// End Add ID;

			// Add Author
			table += Character.toString(verticalLine);
			table = addLetter(table, ' ', PADDING); // Add padding space;
			if (article.getAuthor().length() > 22) {
				table += article.getAuthor().substring(0, 17) + "..."; // Add
																		// Author
				table = addLetter(table, ' ', PADDING);
			} else {
				table += article.getAuthor(); // Add Author
			}
			table = addLetter(table, ' ', maxColumns[1]
					- article.getAuthor().length() - PADDING);
			// End Add Author;

			// Add Title
			table += Character.toString(verticalLine);
			table = addLetter(table, ' ', PADDING);
			if (article.getTitle().length() > 32) {
				table += article.getTitle().substring(0, 27) + "...";
				table = addLetter(table, ' ', PADDING);
			} else
				table += article.getTitle();
			table = addLetter(table, ' ', maxColumns[2]
					- article.getTitle().length() - PADDING);
			// End Add Title;

			// Add Publish Date;
			table += Character.toString(verticalLine);
			table = addLetter(table, ' ', PADDING);
			table += article.getPublishDate();
			table = addLetter(table, ' ', maxColumns[3]
					- article.getPublishDate().length() - PADDING);

			table += Character.toString(verticalLine);
			table += "\n";
		}
		// End of Body

		// Footer;
		table += addHorizontalLine(table, maxColumns, buttomLeft, middleButtom,
				buttomRight);
		// End of Footer;
		System.out.println(table);
		System.out.println("Total Records:" + totalRecord); /*
																	 * Output
																	 * total
																	 * records
																	 */
		System.out
				.println("Pages: " + (this.currentPage + 1) + "/" + totalPage); /*
																				 * Output
																				 * current
																				 * page
																				 * and
																				 * total
																				 * pages
																				 */
		System.out.println();
		// Menu bar;
		menu(maxColumns, totalLenght); /* Output Menu Bar */
	}
	/*
	 * viewOneRecord
	 * */
	public int viewOneRecord(){
		System.out.println("Please input id : ");
		return getNumberKeyboard("");
	}
	public void viewDetail(ArticleDTO article) {
		System.out.println("ID: " + article.getId());
		System.out.println("Author: " + article.getAuthor());
		System.out.println("Title: " + article.getTitle());
		System.out.println("Content: " + article.getContent());
		System.out.println("Publish Date: " + article.getPublishDate());		
	}

	public ArrayList<ArticleDTO> add() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String author;
		String title;
		String content;
		ArrayList<ArticleDTO> articles = new ArrayList<ArticleDTO>();
		do {
			author = getStringKeyboard("Please Enter Author : ");
			title = getStringKeyboard("Please Enter Title : ");
			System.out.println("Type 3 periods (...) to stop");
			System.out.print("Please Enter Content: ");
			content = inputContent();

			articles.add(new ArticleDTO(1, author, title, content, currentDate()));
			// logfile.writeLogAdd(newArticle);

			System.out.print("Do you want to continues?(Y/N)");
			String confirm = input.next();
			switch (confirm.toLowerCase()) {
			case "y":
				break;
			default:
				return articles;
			}// End switch;
		} while (true);
	}// End of add();

	@SuppressWarnings("resource")
	public static String getStringKeyboard(String message) {
		Scanner put = new Scanner(System.in);
		String str = "";
		while (str.equals("")) {
			System.out.print(message);
			str = put.nextLine();
		}
		return str;
	}// End of getStringKeyboard();

	private String currentDate() {
		return new SimpleDateFormat("dd/MM/YYYY HH:mm:ss").format(new Date());
	}

	@SuppressWarnings("resource")
	private String inputContent() {
		StringBuilder contents = new StringBuilder();
		try {
			Scanner put = new Scanner(System.in);
			while (put.hasNext()) {
				contents.append(put.next());
				if (contents.toString().endsWith("...")) {
					contents.setLength(contents.length() - 3);
					break;
				}
				contents.append("\n");
			}// End while;
		} catch (Exception e) {
			// logfile.writeLogException(e, "inputContent", "Management");
		}
		return contents.toString();
	}// End of inputContent();

	@SuppressWarnings("resource")
	private int getNumberKeyboard(String message) {
		Scanner put = new Scanner(System.in);
		while (true) {
			System.out.print(message);
			try {
				return put.nextInt();
			} catch (java.util.InputMismatchException e) {
				System.out
						.println("Input Mismatch. Please Input Number Again.");
				// logfile.writeLogException(e, "getNumberKeyboard",
				// "Management");
				put.nextLine();
			}
		}
	}

	public ArticleDTO update() {
		try {
			int id = getNumberKeyboard("Please, input ID for update: ");

			String author = null;
			String title = null;
			String content = null;
			String option = "";

			option = getStringKeyboard("Update : Au) Author | T) Title) | C) Content | Al) All: ");
			switch (option.toLowerCase()) {
			case "au":/* Updating Author by ID */
				author = getStringKeyboard("Please Input Author : ");
				break;
			case "t":/* Updating Title by ID */
				title = getStringKeyboard("Please Input Title : ");
				break;
			case "c":/* Updating Content by ID */
				System.out.print("Input Content : ");
				content = inputContent();
				break;
			case "al": /* Updating All Fields by ID */
				author = getStringKeyboard("Please Input Author : ");
				title = getStringKeyboard("Please Input Title : ");
				System.out.print("Please input Content: ");
				content = inputContent();
				break;
			default:/* Not Permit invalid Key */
				System.err.println("Invalid");
				waiting();
				break;
			}// End of switch;
			System.out.println("Update Completed!");
			//waiting();
			return new ArticleDTO(id, author, title, content, null);
		} catch (Exception e) {
			// logfile.writeLogException(e, "update", "Management");
		}
		// logfile.writeLogEdit(articles.get(index));
		return null;
	}// End of update();

	public String search() {
		String searchOption;
		String searchBy = getStringKeyboard("I) ID | Au)Author | T)Title | P)Publish Date--> ");
		String key = getStringKeyboard("Please, input key for search: ");
		switch (searchBy.toLowerCase()) {
		case "i": // search ID
			searchOption = "id;" + key;
			break;
		case "au": // search Author name
			searchOption = "author;" + key;
			break;
		case "p": // search PublishDate
			searchOption = "published_date;" + key;
			break;
		case "t": // search Title
			searchOption = "title;" + key;
			break;
		default:
			System.out.println("No Option. Please Input Again.");
			waiting();
			return null;
		}
		return searchOption;
	}// End of search();

	public String sort() {
		String sortBy = getStringKeyboard("Sort By: I) ID | Au) Author | T) Title | P) Publish Date --> ");
		String sortOption;
		switch (sortBy.toLowerCase()) {
		case "i": // sort ID
			sortOption = "id;";
			break;
		case "au": // sort Author name
			sortOption = "author;";
			break;
		case "p": // sort PublishDate
			sortOption = "published_date";
			break;
		case "t": // sort Title
			sortOption = "title;";
			break;
		default:
			System.out.println("No Option. Please Input Again.");
			waiting();
			return null;
		}
		String orderBy = getStringKeyboard("Order By: ASC or DESC --> ");
		if (orderBy.equalsIgnoreCase("asc"))
			sortOption += "ASC";
		else
			sortOption += "DESC";
		return sortOption;
	}

	public int removeById() {
		return getNumberKeyboard("Please, input ID for remove");
	}

	private void waiting() {
		System.out.print("Press Enter to continue...");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}
}// End of class;

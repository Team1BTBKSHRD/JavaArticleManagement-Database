package View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * contains all helper/util function for view
 * @author lit
 *
 */
public class UtilView {	
	/**
	 * get String from input keyboard
	 * @param message : message to show on console screen
	 * @return : string from keyboard
	 */
	public static String getStringKeyboard(String message) {
		@SuppressWarnings("resource")
		Scanner put = new Scanner(System.in);
		String str = "";
		while (str.equals("")) {
			System.out.print(message);
			str = put.nextLine();
		}
		return str;
	}// End of getStringKeyboard();
	
	/**
	 * input multiple line of String
	 * @return content as multiple line of String from Keyboard when user input 3 period  
	 */
	@SuppressWarnings("resource")
	public static String inputContent() {
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
			}
		} catch (Exception e) {
			// logfile.writeLogException(e, "inputContent", "Management");
		}
		return contents.toString();
	}
	
	/**
	 * get number from input keyboard 
	 * if error/mismatch input again
	 * @param message : message to show on console screen
	 * @return : number from keyboard
	 */
	public static int getNumberKeyboard(String message) {
		@SuppressWarnings({ "resource" })
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
	
	/**
	 * currentDate return current date and time
	 * @return string of current date and time
	 */
	public static String currentDate() {
		return new SimpleDateFormat("dd/MM/YYYY HH:mm:ss").format(new Date());
	}
}

package View;

import java.util.InputMismatchException;


@SuppressWarnings("serial")
public class validateUserInputException extends InputMismatchException {
			private String message;
			public  validateUserInputException(String s){
				super("Input wrong");
				this.message=s;
			}
			public String getMessage(){
				return this.message;
			}
}

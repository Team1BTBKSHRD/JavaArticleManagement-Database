package View;
public class LoginView extends View{
	//UtilView.getStringKeyboard("Type \"C\" to connect to New Database \nType \"D\" to connect to Default Database: ");
	/**
	 * display loginuser  
	 * @return string of username or email to compare
	 */
	public String viewLoginUser(){
		return super.getStringKeyboard("Username or Email: "); 
	}
	/**
	 * display loginpassword
	 * @return sting of password to compare
	 */
	public String viewLoginPassword(){
		return super.getStringKeyboard("Password: ");
	}
	public String switchDatabaseConnection(){
		return super.getStringKeyboard("Choose Database for connection ----> ");
	}
}

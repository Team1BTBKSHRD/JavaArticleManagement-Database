package Controller;
import java.io.FileWriter;
import java.io.BufferedWriter;

import View.UtilView;

public class Logger {   
	private static Logger logger = null;
	public static String logFileName = "article.log";
	public static String errorLogFileName = "error.log";
	private Logger() {}
	public static Logger getLogger() {			
		if(logger == null)	logger = new Logger();		
		return logger;		
	}	
	public void writeLogOpenDatabase(String dbName){
		try(BufferedWriter output = new BufferedWriter(new FileWriter(logFileName, true)))
		{	output.write(UtilView.currentDate() + ":\t Open Database Name \"" + dbName + "\"");
			output.write(System.getProperty("line.separator"));			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void writeLogAdd(int id){
		try(BufferedWriter output = new BufferedWriter(new FileWriter(logFileName, true)))
		{	output.write(UtilView.currentDate() + ":\t ADDNEW Record ID " + id);
			output.write(System.getProperty("line.separator"));			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void writeLogUpdate(int id, String fieldName){
		try(BufferedWriter output = new BufferedWriter(new FileWriter(logFileName, true)))
		{	output.write(UtilView.currentDate() + ":\t UPDATE Record ID " + id + " with FIELDNAME \"" + fieldName + "\"");
			output.write(System.getProperty("line.separator"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void writeLogDelete(int id){
		try(BufferedWriter output = new BufferedWriter(new FileWriter(logFileName, true)))
		{	output.write(UtilView.currentDate() + ":\t DELETE Record ID " + id);
			output.write(System.getProperty("line.separator"));			 	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void writeLogException(Exception ex, String methodName, String className){
		try(BufferedWriter output = new BufferedWriter(new FileWriter(errorLogFileName, true))) 
		{	output.write(UtilView.currentDate() + ":\t" + ex + " in METHOD \"" + methodName + "\" CLASS \"" + className + "\"");
			output.write(System.getProperty("line.separator"));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
}

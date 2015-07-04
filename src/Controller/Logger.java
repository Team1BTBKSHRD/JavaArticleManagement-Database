package Controller;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		{	output.write(getCurrentDate() + ":\t Open Database Name \"" + dbName + "\"");
			output.write(System.getProperty("line.separator"));			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void writeLogAdd(int id){
		try(BufferedWriter output = new BufferedWriter(new FileWriter(logFileName, true)))
		{	output.write(getCurrentDate() + ":\t ADDNEW Record ID " + id);
			output.write(System.getProperty("line.separator"));			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void writeLogUpdate(int id, String fieldName){
		try(BufferedWriter output = new BufferedWriter(new FileWriter(logFileName, true)))
		{	output.write(getCurrentDate() + ":\t UPDATE Record ID " + id + " with FIELDNAME \"" + fieldName + "\"");
			output.write(System.getProperty("line.separator"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void writeLogDelete(int id){
		try(BufferedWriter output = new BufferedWriter(new FileWriter(logFileName, true)))
		{	output.write(getCurrentDate() + ":\t DELETE Record ID " + id);
			output.write(System.getProperty("line.separator"));			 	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void writeLogException(Exception ex, String methodName, String className){
		try(BufferedWriter output = new BufferedWriter(new FileWriter(errorLogFileName, true))) 
		{	output.write(getCurrentDate() + ":\t" + ex + " in METHOD \"" + methodName + "\" CLASS \"" + className + "\"");
			output.write(System.getProperty("line.separator"));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
	private String getCurrentDate(){ 
		return new SimpleDateFormat("HH:mm:ss dd/MM/YYYY").format(new Date());
	} 
}

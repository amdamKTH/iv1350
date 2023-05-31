package se.kth.iv1350.retailStore.dbhandler;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class replicates the one provided in the course book and prints statements to a log. 
 * */
public class FileLogger {
	private PrintWriter logStream;
	
	/**
	 * Creates new instance and a file to log to. Exsisting file will be deleted.
	 * */
	public FileLogger() {
		try {
			logStream = new PrintWriter(new FileWriter("log.text"), true);
		}
		catch (IOException ioe) {
			System.out.println("Cannot log.");
			ioe.printStackTrace();
		}
		
	}
	
	/**
	 * Logs message to file. 
	 * */
	public void log(String message) {
		logStream.println(message);
	}

}

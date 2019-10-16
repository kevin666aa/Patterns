package hw1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PrintManager {
	static private PrintManager _secretPrinter; 
	private static PrintWriter writer;
	
	private PrintManager()  {
		try {
			writer = new PrintWriter(new FileOutputStream("Q1Log.txt", false));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Instance Created");
		writer.println("Instance Created");
		writer.close();
	}
	static public PrintManager ThePrintManager() {
		
		if( _secretPrinter == null) {
			_secretPrinter = new PrintManager();
		} else {
			try {
				writer = new PrintWriter(new FileOutputStream("Q1Log.txt", true));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Previously Created instance returned");
			writer.println("Previously Created instance returned");
			writer.close();
		}
		return (_secretPrinter);
		
	}
	

	
}

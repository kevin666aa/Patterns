package hw1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class myprint {
	private static myprint _secretPrinter = null; 
	private static PrintWriter writer;
		
	private myprint() {
		try {
			writer = new PrintWriter(new FileOutputStream("Q2&3Log.txt", false));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.close();
	}
	

	static public void mylogclass(String output) {
		if( _secretPrinter == null) {
			_secretPrinter = new myprint();
		} 
		
		try {
			writer = new PrintWriter(new FileOutputStream("Q2&3Log.txt", true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(output);
		writer.println(output);
		writer.close();
	}

	
	
}

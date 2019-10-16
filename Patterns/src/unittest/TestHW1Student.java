package unittest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import org.junit.Test;

import hw1.PrintManager;
import hw1.DestObserver;
import hw1.LibraryBook;
import hw1.SourceObserver;

/**
* Typically test execution is arbitrary, this fixes the order
* to run Question1 -> 2 -> 3, which is needed to keep the
* test log in order.
*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestHW1Student {
	@Test
	public void Question1 () {
		System.out.println("------------------------- Question 1 -------------------------");
		
		// Tracking your output starts here.
		PrintManager pm = PrintManager.ThePrintManager();
		PrintManager pm2 = PrintManager.ThePrintManager();

		// The objects should be the same instance.
		assertEquals(pm, pm2);
			
		// Make sure the lines of log file match those in the example output file.
		List<String> expected_lines = null;
		try {
			expected_lines = Files.lines(Paths.get("ExampleQ1Output.txt")).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		List<String> actual_lines = null;
		try {
			actual_lines = Files.lines(Paths.get("Q1Log.txt")).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertEquals(expected_lines.size(), actual_lines.size());
		for (int i = 0; i < expected_lines.size(); i++) {
			System.out.println("Expected:");
			System.out.println(expected_lines.get(i));
			System.out.println("Actual:");
			System.out.println(actual_lines.get(i));
			assertEquals(expected_lines.get(i).toLowerCase().trim(), actual_lines.get(i).toLowerCase().trim());
		}
		System.out.println("------------------------- Question 1 -------------------------");

	}
	
	@Test
	public void Question2() {
		System.out.println("------------------------- Question 2 -------------------------");
		
		// Tracking your output starts here.
		LibraryBook b = new LibraryBook("Design Patterns");
		
		b.returnIt();
		b.shelf();
		b.issue();
		b.extend();
		b.extend();
		b.extend();
		b.returnIt();
		b.extend();
		b.issue();
		b.shelf();
		b.extend();
		
		// Make sure the lines of log file match those in the example output file.
		List<String> expected_lines = null;
		try {
			expected_lines = Files.lines(Paths.get("ExampleQ2Output.txt")).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<String> actual_lines = null;
		try {
			actual_lines = Files.lines(Paths.get("Q2&3Log.txt")).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertEquals(expected_lines.size(), actual_lines.size());
		
		for (int i = 0; i < expected_lines.size(); i++) {
			System.out.println("Expected:");
			System.out.println(expected_lines.get(i));
			System.out.println("Actual:");
			System.out.println(actual_lines.get(i));
			assertEquals(expected_lines.get(i).toLowerCase().trim(), actual_lines.get(i).toLowerCase().trim());
		}
		System.out.println("------------------------- Question 2 -------------------------");
	}

	@Test
	public void Question3() {
		System.out.println("------------------------- Question 3 -------------------------");
		
		// Tracking your output starts here.
		LibraryBook b1 = new LibraryBook("Design Patterns");
		LibraryBook b2 = new LibraryBook("Deep Learning");
		
		SourceObserver a = new SourceObserver("Casey");
		DestObserver b = new DestObserver("Ji");
		
		b1.detach(b);
		b1.attach(a);
		b1.attach(b);
		b2.attach(b);
				
		b1.issue();
		b1.extend();
		b1.detach(a);
		b1.extend();
		b1.returnIt();
		b1.shelf();
		
		b2.shelf();
		b2.issue();
		b2.attach(a);
		b2.returnIt();
		b2.detach(b);
		b2.shelf();
		b2.issue();
				
		// Make sure the lines of log file match those in the example output file.
		List<String> expected_lines = null;
		try {
			expected_lines = Files.lines(Paths.get("ExampleQ3Output.txt")).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<String> actual_lines = null;
		try {
			actual_lines = Files.lines(Paths.get("Q2&3Log.txt")).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<String> expectedq2_lines = null;
		try {
			expectedq2_lines = Files.lines(Paths.get("ExampleQ2Output.txt")).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertEquals(expected_lines.size() + expectedq2_lines.size(), actual_lines.size());
		
		for (int i = 0; i < expected_lines.size(); i++) {
			System.out.println("Expected:");
			System.out.println(expected_lines.get(i));
			System.out.println("Actual:");
			System.out.println(actual_lines.get(i + expectedq2_lines.size()));
			assertEquals(expected_lines.get(i).toLowerCase().trim(), actual_lines.get(i + expectedq2_lines.size()).toLowerCase().trim());
		}
		
		System.out.println("------------------------- Question 3 -------------------------");

	}
}

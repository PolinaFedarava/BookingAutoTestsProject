package by.htp.booking_com.run;

import java.util.Scanner;

public class ScannerClass {
	
	private static Scanner scanner;

	static {
		scanner = new Scanner(System.in);
	}

	private ScannerClass() {

	}

	public static Scanner getScanner() {
		return scanner;
	}
}

package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
		Scanner myFirstScanner = new Scanner(System.in);
		System.out.println("what is the path for the file you would like to scan?");
		String filePathToSearch = myFirstScanner.nextLine();
		System.out.println("What word would you like to search for?");
		String searchString = myFirstScanner.nextLine();
		System.out.println("Do you want the result to be case sensitive? (Y/N)");
		String yesOrNo = myFirstScanner.nextLine();

	File textToScan = new File(filePathToSearch);
	int lineNumber=0;

		try (Scanner searchable = new Scanner(textToScan)) {
			while (searchable.hasNextLine()) {

				if (yesOrNo.equalsIgnoreCase("y")) {
					String searchLine = searchable.nextLine();
					lineNumber += 1;
					if (searchLine.contains(searchString)) {
						System.out.println(lineNumber + ": " + searchLine);
					}
				} else if (yesOrNo.equalsIgnoreCase("n")) {
					String searchLine = searchable.nextLine();
					lineNumber += 1;
					if (searchLine.toLowerCase().contains(searchString.toLowerCase())) {
						System.out.println(lineNumber + ": " + searchLine);
					}
				}
			}
		}
		catch(FileNotFoundException e){
			System.err.println("That file cannot be found");


	}
	}

}

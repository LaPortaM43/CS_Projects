
package edu.monmouth.hw4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;

import edu.monmouth.book.*;

public class BookHW4 {
    public static void main(String args[]) {
    	
        if (args.length != BookHW4Constants.NUMBEROFARGUMENTS) {
            System.err.println("Usage: java BookHW4 <data_file> <output_file>");
            System.exit(BookHW4Constants.WRONGARGUMENT);
        }

        String dataFile = args[0];

        String outputFile = args[1];

        try {
            PrintStream ps = new PrintStream(new FileOutputStream(outputFile));
            System.setOut(ps);
            System.setErr(ps);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found." + outputFile);
            e.printStackTrace();
            System.exit(BookHW4Constants.WRONGARGUMENT); 
        }
        
        HashSet<Book> bookSet = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        String title = parts[0];
                        BookTypes bookType = BookTypes.valueOf(parts[1]);
                        int numberOfPages = Integer.parseInt(parts[2]);
                        double price = Double.parseDouble(parts[3]);
                        int publicationYear = Integer.parseInt(parts[4]);
                        Book book = new Book(numberOfPages, price, title, bookType, publicationYear);
                        bookSet.add(book);
                    } catch (IllegalArgumentException | BookException e) {
                        System.err.println("Error creating Book object from line: " + line);
                    }
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data file: " + e.getMessage());
        }
        
        for (Book book : bookSet) {
            System.out.println(book);
        }

        Book bookToFind = null;
		try {
			bookToFind = new Book(829, 23.95, "The Soloman Curse", BookTypes.HARDBACK, 2003);
			if(bookSet.contains(bookToFind)== true) {
				System.out.println(bookToFind + "\nExists in bookSet");
			} else {
				System.out.println(bookToFind + "\nDoes not exist in bookSet");
			}
			bookToFind = new Book(629, 87.00, "The BigBang Theory", BookTypes.HARDBACK, 2010);
			if(bookSet.contains(bookToFind)== true) {
				System.out.println(bookToFind + "\nExists in bookSet");
			} else {
				System.out.println(bookToFind + "\nDoes not exist in bookSet");
			}
		} catch (BookException e) {
			System.err.println("Cannot create a Book object from these values:\n" + bookToFind + e.getMessage());
		}
    }
}


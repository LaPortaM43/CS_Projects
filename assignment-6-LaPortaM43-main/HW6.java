package edu.monmouth.hw6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;
import java.util.TreeSet;
import java.util.Set;

import edu.monmouth.book.Book;
import edu.monmouth.book.BookException;
import edu.monmouth.book.BookTypes;

public class HW6 {

    public static void main(String[] args) {
        // Step 1: Accept 1 command line argument
        if (args.length != HW6Constants.NUMBEROFARGUMENTS) {
            System.err.println("Usage: java HW6 <properties_file>");
            System.exit(HW6Constants.WRONGARGUMENT);
        }

        String propertiesFileName = args[0];
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(propertiesFileName)) {
            properties.load(input);
            String logFileName = properties.getProperty("log_file_name");
            redirectOutput(logFileName);
            String bookFileName = properties.getProperty("book_file_name");
            String bookDelimiter = properties.getProperty("book_delimiter");

            TreeSet<Book> bookSet = new TreeSet<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(bookFileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(bookDelimiter);
                    if (parts.length == 5) {
                        try {
                            String title = parts[0].trim();
                            if (title.isEmpty() || parts[1].trim().isEmpty() || parts[2].trim().isEmpty() || parts[3].trim().isEmpty() || parts[4].trim().isEmpty()) {
                                throw new BookException("Empty field found in book data");
                            }
                            BookTypes type = BookTypes.valueOf(parts[1].trim());
                            int numberOfPages = Integer.parseInt(parts[2].trim());
                            double price = Double.parseDouble(parts[3].trim());
                            int publicationYear = Integer.parseInt(parts[4].trim());
                            Book book = new Book(numberOfPages, price, title, type, publicationYear);
                            bookSet.add(book);
                        } catch (BookException | IllegalArgumentException e) {
                            System.err.println("Error creating book: " + e.getMessage());
                        }
                    } else {
                        System.err.println("Invalid data format in book file: " + line);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading book data file: " + e.getMessage());
                System.exit(HW6Constants.WRONGARGUMENT); 
            }

            System.out.println("Books sorted by natural ordering:");
            for (Book book : bookSet) {
                System.out.println(book);
            }

            Set<Book> treePrice = new TreeSet<>(new BookPrice());

            try (BufferedReader reader = new BufferedReader(new FileReader(bookFileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(bookDelimiter);
                    if (parts.length == 5) {
                        try {
                            String title = parts[0].trim();
                            if (title.isEmpty() || parts[1].trim().isEmpty() || parts[2].trim().isEmpty() || parts[3].trim().isEmpty() || parts[4].trim().isEmpty()) {
                                throw new BookException("Empty field found in book data");
                            }
                            BookTypes type = BookTypes.valueOf(parts[1].trim());
                            int numberOfPages = Integer.parseInt(parts[2].trim());
                            double price = Double.parseDouble(parts[3].trim());
                            int publicationYear = Integer.parseInt(parts[4].trim());
                            Book book = new Book(numberOfPages, price, title, type, publicationYear);
                            treePrice.add(book);
                        } catch (BookException | IllegalArgumentException e) {
                            System.err.println("Error creating book: " + e.getMessage());
                        }
                    } else {
                        System.err.println("Invalid data format in book file: " + line);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading book data file: " + e.getMessage());
                System.exit(HW6Constants.WRONGARGUMENT); 
            }
            
            System.out.println("\nBooks sorted by price:");
            for (Book book : treePrice) {
                System.out.println(book);
            }
        } catch (IOException e) {
            System.err.println("Error reading properties file: " + e.getMessage());
            System.exit(HW6Constants.WRONGARGUMENT); 
        }
    }

    private static void redirectOutput(String fileName) {
        try {
            PrintStream fileStream = new PrintStream(fileName);
            System.setOut(fileStream);
            System.setErr(fileStream);
        } catch (IOException e) {
            System.err.println("Error redirecting output: " + e.getMessage());
            System.exit(HW6Constants.WRONGARGUMENT); 
        }
    }
}



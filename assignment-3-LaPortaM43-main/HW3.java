package edu.monmouth.hw3;

import edu.monmouth.book.*;

import java.io.*;
import java.util.*;

public class HW3 {
    public static void main(String[] args) {
        if (args.length != HW3Constants.NUMBEROFARGUMENTS) {
            System.err.println("Usage: java HW3 <output_file> <string_file> <book_file>");
            System.exit(HW3Constants.WRONGARGUMENTS);
        }
        redirectOutput(args[HW3Constants.OUTPUT_FILE]);

        List<String> stringArrayList = new ArrayList<>();
        List<String> stringLinkedList = new LinkedList<>();
        readAndPopulateList(args[HW3Constants.STRING_FILE], stringArrayList);
        readAndPopulateList(args[HW3Constants.STRING_FILE], stringLinkedList);

        List<Book> bookArrayList = new ArrayList<>();
        List<Book> bookLinkedList = new LinkedList<>();
        readAndPopulateBookList(args[HW3Constants.BOOK_FILE], bookArrayList);
        readAndPopulateBookList(args[HW3Constants.BOOK_FILE], bookLinkedList);

        testListMethods("ArrayList", stringArrayList);
        testListMethods("LinkedList", stringLinkedList);
        testListMethods("ArrayList", bookArrayList);
        testListMethods("LinkedList", bookLinkedList);
    }

    private static void redirectOutput(String filename) {
        try {
            System.setOut(new PrintStream(new FileOutputStream(filename)));
            System.setErr(new PrintStream(new FileOutputStream(filename, true)));
        } catch (FileNotFoundException e) {
            System.err.println("Error redirecting output: " + e.getMessage());
        }
    }

    private static void readAndPopulateList(String filename, List<String> list) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void readAndPopulateBookList(String filename, List<Book> list) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        list.add(new Book(parts[0], BookTypes.valueOf(parts[1]), Integer.parseInt(parts[2]),
                                Double.parseDouble(parts[3]), Double.parseDouble(parts[4])));
                    } catch (IllegalArgumentException | BookException e) {
                        System.err.println("Error creating book: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void testListMethods(String listType, List list) {
        System.out.println(listType + " methods:");
        System.out.println("isEmpty: " + list.isEmpty());
        
        if (!list.isEmpty()) {
            Object removed = list.remove(0);
            System.out.println("Removed object: " + removed);
        }
        
        System.out.println("Size: " + list.size());
        
        Iterator iterator = list.iterator();
        System.out.println("Using Iterator:");
        while (iterator.hasNext()) {
            System.out.println("Object: " + iterator.next());
        }
        
        if (list instanceof LinkedList && !list.isEmpty() && list.get(0) instanceof String) {
            LinkedList<String> linkedList = (LinkedList<String>) list;
            linkedList.add("New String");
        } else if (list instanceof LinkedList && !list.isEmpty() && list.get(0) instanceof Book) {
            LinkedList<Book> linkedList = (LinkedList<Book>) list;
            try {
                linkedList.add(new Book("New Book", BookTypes.HARDBACK, 100, 10.0, 2022));
            } catch (BookException e) {
                System.err.println("Error adding book: " + e.getMessage());
            }
        }
        
        for (Object obj : list) {
            System.out.println("Object: " + obj);
        }
    }
}




package edu.monmouth.lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
    	
    	// Verifying that one command line argument is being used 
        if (args.length != Lab3Constants.NUMBEROFARGUMENTS) {
            System.err.println("Error: Please provide a filename as command line argument.");
            System.exit(Lab3Constants.WRONGARGUMENT);
        }

        // Redirecting stdout and stderr to Lab3Output.txt 
        try {
            System.setOut(new PrintStream(new File(Lab3Constants.OUTPUTFILE)));
            System.setErr(new PrintStream(new File(Lab3Constants.OUTPUTFILE)));
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found: " + e.getMessage());
            System.exit(Lab3Constants.WRONGARGUMENT);
        }
        
        // Declaring an array that can house 10 Competitor objects 
        Competitor[] competitors = new Competitor[Lab3Constants.MAX_COMPETITORS];

        // Opening golf.txt and handling exceptions 
        // Reading golf.txt, creating Competitor objects for each valid line, and adding it to the array 
        try (Scanner scanner = new Scanner(new File("golf.txt"))) {
            int index = 0;
            while (scanner.hasNextLine() && index < Lab3Constants.MAX_COMPETITORS) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2 && !parts[0].trim().isEmpty()) {
                    String name = parts[0].trim();
                    try {
                        int score = Integer.parseInt(parts[1].trim());
                        Competitor competitor = new Competitor(name, score);
                        competitors[index++] = competitor;
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing score for line: " + line);
                    }
                } else {
                    System.err.println("Invalid line format or missing name: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + e.getMessage());
            System.exit(Lab3Constants.WRONGARGUMENT);
        }


        
        // Sort array in ascending order 
        Arrays.sort(competitors);
        
        // Print out sorted array 
        System.out.println("--------------------------");
        System.out.println("Sorted Competitors (Golf):");
        System.out.println("--------------------------");
        for (Competitor competitor : competitors) {
            if (competitor != null) {
                System.out.println(competitor);
            }
        }

        // Declare a PriorityQueue that can house Competitor objects named “golfers”
        PriorityQueue<Competitor> golfers = new PriorityQueue<>();
        
        // Iterate through the array-adding the Competitor objects to the PriorityQueue
        for (Competitor competitor : competitors) {
            if (competitor != null) {
                golfers.offer(competitor);
            }
        }
        
        // Print the leader of the golfers using the poll() method 
        System.out.println("---------------------------------------------------------");
        System.out.println("Leader of the Golfers: " + golfers.poll());
        System.out.println("---------------------------------------------------------");

        // Declare a second PriorityQueue that can house Competitor objects named “bowlers”
        // Supply it with the BowlerComparator class.
        PriorityQueue<Competitor> bowlers = new PriorityQueue<>(new BowlerComparator());

        // Open bowling.txt and handle exceptions 
        // Read bowling.txt, create a Competitor object for each line-add to the PriorityQueue.
        try (Scanner scanner = new Scanner(new File("bowling.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    try {
                        int score = Integer.parseInt(parts[1].trim());
                        Competitor competitor = new Competitor(name, score);
                        bowlers.offer(competitor);
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing score for line: " + line);
                    }
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + e.getMessage());
            System.exit(Lab3Constants.WRONGARGUMENT);
        }

        // Print the leader of the bowlers.
        System.out.println("Leader of the Bowlers: " + bowlers.poll());
        System.out.println("---------------------------------------------------------");
        
        
        // Using an Iterator in a looping construct, print the remaining bowlers.
        System.out.println("Remaining Bowlers:");
        System.out.println("------------------");
        while (!bowlers.isEmpty()) {
            System.out.println(bowlers.poll());
        }
    }
}


 
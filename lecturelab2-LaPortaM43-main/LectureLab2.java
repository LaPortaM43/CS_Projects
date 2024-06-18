package edu.monmouth.shape;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class LectureLab2 {

    public static void main(String[] args) {
    	
    	// verify 1 cmd arg present
        if (args.length != 1) {
            System.err.println("Error: Incorrect number of command line arguments.");
            System.exit(-1);
        }
        
        // Redirect STDERR and STDOUT to the specified file
        try {
            String fileName = args[0];
            PrintStream fileStream = new PrintStream(new FileOutputStream(fileName));
            System.setErr(fileStream);
            System.setOut(fileStream);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
            System.exit(-1);
        }
        // create Circle & Rectangle objects
        Circle c1 = new Circle("c1", 100);
        Circle c2 = new Circle("c2", 2);
        Circle c3 = new Circle("c3", 30);
        Circle c4 = new Circle("c4", 408);
        Circle c5 = new Circle("c5", 5);
        Circle c6 = new Circle("c6", 5);
        Circle c7 = new Circle("c7", 8);
        Rectangle r1 = new Rectangle("r1", 10, 12);
        Rectangle r3 = new Rectangle("r3", 3, 3);
        Rectangle r4 = new Rectangle("r4", 4, 32);
        Rectangle r5 = new Rectangle("r5", 5, 1);
        Rectangle r0 = new Rectangle("r0", 10, 12);
        Rectangle r2 = new Rectangle("r2", 2, 20);

        // create a List for Circles
        List<Circle> circleList = new LinkedList<>();

        // insert Circle objects to List
        circleList.add(c1);
        circleList.add(c2);
        circleList.add(c3);
        circleList.add(c4);
        circleList.add(c5);
        circleList.add(c6);
        circleList.add(c7);

        // Step 6: Iterate through the List of Circles (Unsorted)
        System.out.println("Iterating through Circle List (Unsorted):");

        // Enhanced for loop
        for (Circle circle : circleList) {
            System.out.println(circle);
        }

        // Using Iterator's hasNext() with a while loop
        System.out.println("Iterating through Circle List with Iterator (Unsorted):");
        Iterator<Circle> circleIterator = circleList.iterator();
        while (circleIterator.hasNext()) {
            Circle circle = circleIterator.next();
            System.out.println(circle);
        }

        // Using List's size() and get() methods with a for loop
        System.out.println("Iterating through Circle List with List's size() and get() methods (Unsorted):");
        for (int i = 0; i < circleList.size(); i++) {
            Circle circle = circleList.get(i);
            System.out.println(circle);
        }

        // Step 7: Sort the List of Circles
        Collections.sort(circleList);

        // Step 8: Iterate through the sorted List of Circles
        System.out.println("Iterating through Sorted Circle List:");
        for (Circle circle : circleList) {
            System.out.println(circle);
        }

        // Step 9: Declare a List for Rectangles using LinkedList
        List<Rectangle> rectangleList = new LinkedList<>();

        // Step 10: Add Rectangle objects to List
        rectangleList.add(r1);
        rectangleList.add(r3);
        rectangleList.add(r4);
        rectangleList.add(r5);
        rectangleList.add(r0);
        rectangleList.add(r2);

    	// Step 11: Iterate through the List of Rectangles (Unsorted)
        System.out.println("Iterating through Rectangle List (Unsorted):");

        // Enhanced for loop
        for (Rectangle rectangle : rectangleList) {
            System.out.println(rectangle);
        }

        // Using Iterator's hasNext() with a while loop
        System.out.println("Iterating through Rectangle List with Iterator (Unsorted):");
        Iterator<Rectangle> rectangleIterator = rectangleList.iterator();
        while (rectangleIterator.hasNext()) {
            Rectangle rectangle = rectangleIterator.next();
            System.out.println(rectangle);
        }

        // Using List's size() and get() methods with a for loop
        System.out.println("Iterating through Rectangle List with List's size() and get() methods (Unsorted):");
        for (int i = 0; i < rectangleList.size(); i++) {
            Rectangle rectangle = rectangleList.get(i);
            System.out.println(rectangle);
        }


        // Step 12: Sort the List of Rectangles
        Collections.sort(rectangleList);

        // Step 13: Iterate through the sorted List of Rectangles
        System.out.println("Iterating through Sorted Rectangle List:");
        for (Rectangle rectangle : rectangleList) {
            System.out.println(rectangle);
        }

        // Step 14: Create two more objects
        Circle findThisCircle = new Circle("cX", 98);
        Rectangle findThisRectangle = new Rectangle("r4", 4, 4);

        // Step 15: Binary Search for the objects in their respective Lists
        System.out.println("Searching for objects:");
        int circleIndex = Collections.binarySearch(circleList, findThisCircle);
        if (circleIndex >= 0) {
            System.out.println("Circle found at index " + circleIndex + " in the Circle List.");
        } else {
            System.out.println("Circle not found in the Circle List.");
        }

        int rectangleIndex = Collections.binarySearch(rectangleList, findThisRectangle);
        if (rectangleIndex >= 0) {
            System.out.println("Rectangle found at index " + rectangleIndex + " in the Rectangle List.");
        } else {
            System.out.println("Rectangle not found in the Rectangle List.");
        }
    }
}

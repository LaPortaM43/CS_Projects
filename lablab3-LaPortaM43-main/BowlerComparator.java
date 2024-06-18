//BowlerComparator.java
package edu.monmouth.lab3;

import java.util.Comparator;

// Create a class named BowlerComparator
public class BowlerComparator implements Comparator<Competitor> {
 @Override
 public int compare(Competitor c1, Competitor c2) {
	 // Define the compare() method
	 // Ensure scores are ordered opposite of Competitor's natural ordering 
     return Integer.compare(c2.getScore(), c1.getScore());
 }
}
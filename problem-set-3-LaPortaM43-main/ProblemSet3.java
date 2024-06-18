package edu.monmouth.problemSet3;

import edu.monmouth.problemSet1.MusicalInstrument;

public class ProblemSet3 {
	public static void main(String[] args) {
		
		final int FEWEST = 6; 
		
		MusicalInstrument instrument1 = new MusicalInstrument();
		// verify default constructor sets all attributes correctly
		
		MusicalInstrument instrument2 = new MusicalInstrument("GuiTar", "STRIng", 6);
		// verify this constructor sets all attributes correctly
		
		MusicalInstrument instrument3 = new MusicalInstrument("Trumpet", "brass", 3, 109.99);
		// verify this constructor sets all attributes correctly
		
		MusicalInstrument instrument4 = new MusicalInstrument("", "BRAss", -14, 109.99);
		// verify this constructor sets all attributes correctly
		
		MusicalInstrument instrument5 = new MusicalInstrument("CLARINET", "Wooodwid", 10, 89.99);
		// verify this constructor sets all attributes correctly
		
		MusicalInstrument instrument6 = new MusicalInstrument("Oboe", "Woodwind", 12, 79.99);
		// verify this constructor sets all attributes correctly
		
		MusicalInstrument instrument7 = new MusicalInstrument("tuba", "Brass", 3, 189.99);
		// verify this constructor sets all attributes correctly
		
		MusicalInstrument instrument8 = new MusicalInstrument("trianGle", "percussion", 0, 49.99);

		MusicalInstrument[] instruments = new MusicalInstrument[8];
		
		instruments[0] = instrument1;
		instruments[1] = instrument2;
		instruments[2] = instrument3;
		instruments[3] = instrument4;
		instruments[4] = instrument5;
		instruments[5] = instrument6;
		instruments[6] = instrument7;
		instruments[7] = instrument8;
		
		System.out.println("------------------------------------------------------------------------------------------------");
		
		for (MusicalInstrument instrument : instruments) {
		    System.out.println(instrument);
		}
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println();

	        // Determine the most expensive instrument among objects instrument 5-8
	        MusicalInstrument mostExpensiveInstrument = instruments[4];
	        for (int i = 5; i < instruments.length; i++) {
	            if (instruments[i].getPrice() > mostExpensiveInstrument.getPrice()) {
	                mostExpensiveInstrument = instruments[i];
	            }
	        }
	        
	        System.out.println("--------------");
	        System.out.println("Most expensive");
	        System.out.println("--------------");
	        System.out.println("The most expensive instrument is: " + mostExpensiveInstrument.getName() +
	                " costing $" + mostExpensiveInstrument.getPrice());

	        
	        System.out.println("----------------");
	        System.out.println("Type 'woodwind'");
	        System.out.println("----------------");
	        
	        // Determine if the objects 5-8 has the type woodwind
	        for (int i = 4; i < instruments.length; i++) {
	            MusicalInstrument woodwindInstrument = instruments[i];
	            String type = woodwindInstrument.getType();

	            if (type.equalsIgnoreCase("woodwind")) {
	                System.out.println(woodwindInstrument.getName() + " is a woodwind instrument.");
	            } else {
	                
	            }
	        }
	      
	     System.out.println("--------------");
	     System.out.println("Greater than 6");
	     System.out.println("--------------");
	     // Determine if objects 5-8 have keys or strings > 6
	        for (int i = 4; i < instruments.length; i++) {
	            MusicalInstrument instrument = instruments[i];
	            int keysOrStrings = instrument.getNumberOfKeysorStrings();

	            if (keysOrStrings > FEWEST) {
	                System.out.println(instrument.getName() + " has keys or strings > 6.");
	            } else {
	                
	            }
	        }
	}
	        
}







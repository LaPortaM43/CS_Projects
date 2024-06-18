package edu.monmouth.problemSet2;

import edu.monmouth.problemSet1.MusicalInstrument;

public class ProblemSet2 {

	public static void main(String[] args) {
		// Object creation using default constructor 
		MusicalInstrument instrument1 = new MusicalInstrument();
		
		System.out.println("-------");
		System.out.println("Default");
		System.out.println("-------");
		System.out.println("Name: " + instrument1.getName());
		System.out.println("Type: " + instrument1.getType());
		System.out.println("# of keys or strings: " + instrument1.getNumberOfKeysorStrings());
		
		instrument1.setName("Piano");
		instrument1.setType("Keyboard");
		instrument1.setNumberOfKeysorStrings(88);
		
		System.out.println("------------");
		System.out.println("Instrument 1");
		System.out.println("------------");
		System.out.println("Name: " + instrument1.getName());
		System.out.println("Type: " + instrument1.getType());
		System.out.println("# of keys or strings: " + instrument1.getNumberOfKeysorStrings());
		
		MusicalInstrument instrument2 = new MusicalInstrument("Guitar", "String", 6);
		
		System.out.println("------------");
		System.out.println("Instrument 2");
		System.out.println("------------");
		System.out.println("Name: " + instrument2.getName());
		System.out.println("Type: " + instrument2.getType());
		System.out.println("# of keys or strings: " + instrument2.getNumberOfKeysorStrings());
		
		instrument2.setName("snare drum");
		instrument2.setType("percussion");
		instrument2.setNumberOfKeysorStrings(0);
		
		System.out.println("------------");
		System.out.println("Instrument 2 Changed");
		System.out.println("------------");
		System.out.println("Name: " + instrument2.getName());
		System.out.println("Type: " + instrument2.getType());
		System.out.println("# of keys or strings: " + instrument2.getNumberOfKeysorStrings());
		
		MusicalInstrument instrument3 = new MusicalInstrument("", "Basketball", 200);
		
		System.out.println("------------");
		System.out.println("Instrument 3 Invalid");
		System.out.println("------------");
		System.out.println("Name: " + instrument3.getName());
		System.out.println("Type: " + instrument3.getType());
		System.out.println("# of keys or strings: " + instrument3.getNumberOfKeysorStrings());
		
		MusicalInstrument instrument4 = new MusicalInstrument("", "Keanu Reeves", -5);
		
		System.out.println("------------");
		System.out.println("Instrument 4 Invalid");
		System.out.println("------------");
		System.out.println("Name: " + instrument4.getName());
		System.out.println("Type: " + instrument4.getType());
		System.out.println("# of keys or strings: " + instrument4.getNumberOfKeysorStrings());
		
	}

}

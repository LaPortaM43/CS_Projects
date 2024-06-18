package edu.monmouth.problemset6;

import edu.monmouth.musicalInstrument.*;

public class ProblemSet6 {

    public static void main(String[] args) {
        try {
            // Valid
            MusicalInstrument validInstrument1 = new MusicalInstrument("Flute", "woodwind", 16, 500.0);
            MusicalInstrument validInstrument2 = new MusicalInstrument("Trumpet", "brass", 3, 800.0);

            // Invalid
            try {
                MusicalInstrument invalidInstrument1 = new MusicalInstrument(null, "woodwind", 16, 500.0);
            } catch (MusicalInstrumentException e) {
                System.out.println("Exception creating invalid instrument: " + e.getMessage());
            }

            try {
                MusicalInstrument invalidInstrument2 = new MusicalInstrument("Violin", "invalidtype", 4, 600.0);
            } catch (MusicalInstrumentException e) {
                System.out.println("Exception creating invalid instrument: " + e.getMessage());
            }
        } catch (MusicalInstrumentException e) {
            System.out.println("Exception in main: " + e.getMessage());
        }
    }
}

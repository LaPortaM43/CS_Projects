package edu.monmouth.problemSet4;

import edu.monmouth.problemSet1.MusicalInstrument;

public class ProblemSet4 {
    public static void main(String[] args) {

        final int ARRAY_SIZE = 10;
        MusicalInstrument[] instrumentArray = new MusicalInstrument[ARRAY_SIZE];

        instrumentArray[0] = new MusicalInstrument("Flute", "woodwind", 16, 300.0);
        instrumentArray[1] = new MusicalInstrument("Trumpet", "brass", 3, 500.0);
        instrumentArray[2] = new MusicalInstrument("Violin", "string", 4, 600.0);
        instrumentArray[3] = new MusicalInstrument("Drums", "percussion", 8, 800.0);
        instrumentArray[4] = new MusicalInstrument("Piano", "keyboard", 88, 1500.0);
        instrumentArray[5] = new MusicalInstrument("Saxophone", "woodwind", 23, 700.0);
        instrumentArray[6] = new MusicalInstrument("Trombone", "brass", 2, 450.0);
        instrumentArray[7] = new MusicalInstrument("Cello", "string", 4, 900.0);
        instrumentArray[8] = new MusicalInstrument("Xylophone", "percussion", 25, 400.0);
        instrumentArray[9] = new MusicalInstrument("Organ", "keyboard", 61, 2000.0);

        System.out.println("Printing all MusicalInstrument objects:");
        for (int i = 0; i < ARRAY_SIZE; i++) {
            System.out.println("MusicalInstrument[" + i + "] " + instrumentArray[i]);
        }

        int minKeysOrStringsIndex = 0;
        for (int i = 1; i < ARRAY_SIZE; i++) {
            if (instrumentArray[i].getNumberOfKeysorStrings() < instrumentArray[minKeysOrStringsIndex].getNumberOfKeysorStrings()) {
                minKeysOrStringsIndex = i;
            }
        }
        System.out.println("\nMusicalInstrument with the fewest keys or strings (Index " + minKeysOrStringsIndex + "):");
        System.out.println("MusicalInstrument[" + minKeysOrStringsIndex + "] " + instrumentArray[minKeysOrStringsIndex]);

        System.out.println("\nMusicalInstrument(s) with type 'brass':");
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (instrumentArray[i].getType().equals("brass")) {
                System.out.println("MusicalInstrument[" + i + "] " + instrumentArray[i]);
            }
        }

        int maxPriceIndex = 0;
        for (int i = 1; i < ARRAY_SIZE; i++) {
            if (instrumentArray[i].getPrice() > instrumentArray[maxPriceIndex].getPrice()) {
                maxPriceIndex = i;
            }
        }
        System.out.println("\nMusicalInstrument with the greatest price (Index " + maxPriceIndex + "):");
        System.out.println("MusicalInstrument[" + maxPriceIndex + "] " + instrumentArray[maxPriceIndex]);

        MusicalInstrument[] brassInstrumentArray = new MusicalInstrument[ARRAY_SIZE];
        int brassCount = 0;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (instrumentArray[i].getType().equals("brass")) {
                brassInstrumentArray[brassCount++] = new MusicalInstrument(instrumentArray[i].getName(),
                        instrumentArray[i].getType(), instrumentArray[i].getNumberOfKeysorStrings(),
                        instrumentArray[i].getPrice());
            }
        }

        System.out.println("\nPrinting MusicalInstrument objects with type 'brass' in the new array:");
        for (int i = 0; i < brassCount; i++) {
            System.out.println("MusicalInstrument[" + i + "] " + brassInstrumentArray[i]);
        }
    }
}



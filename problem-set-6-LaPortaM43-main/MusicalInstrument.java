package edu.monmouth.musicalInstrument;

public class MusicalInstrument {

    final String UNKNOWNNAME = "UNKNOWNNAME";
    final String UNKNOWNTYPE = "UNKNOWNTYPE";
    final int LOWESTNAMELENGTH = 0;
    final int UNKNOWNKEYSORSTRINGS = -1;
    final int MINIMUMSTRINGSORKEYS = 1;
    final int MAXIMUMSTRINGSORKEYS = 100;
    final int LOWESTPRICE = 0;
    final int UNKNOWNPRICE = -9;

    private String name;
    private String type;
    private int numberOfKeysorStrings;
    private double price;

    public MusicalInstrument() throws MusicalInstrumentException {
        try {
            setName(UNKNOWNNAME);
            setType(UNKNOWNTYPE);
            setNumberOfKeysorStrings(UNKNOWNKEYSORSTRINGS);
            setPrice(UNKNOWNPRICE);
        } catch (MusicalInstrumentException e) {
            throw e;
        }
    }

    public MusicalInstrument(String name, String type, int numberOfKeysorStrings) throws MusicalInstrumentException {
        try {
            setName(name);
            setType(type);
            setNumberOfKeysorStrings(numberOfKeysorStrings);
            setPrice(UNKNOWNPRICE);
        } catch (MusicalInstrumentException e) {
            throw e;
        }
    }

    public MusicalInstrument(String name, String type, int numberOfKeysorStrings, double price) throws MusicalInstrumentException {
        try {
            setName(name);
            setType(type);
            setNumberOfKeysorStrings(numberOfKeysorStrings);
            setPrice(price);
        } catch (MusicalInstrumentException e) {
            throw e;
        }
    }

    public void setType(String type) throws MusicalInstrumentException {
        String[] validTypes = {"woodwind", "brass", "string", "percussion", "keyboard"};

        if (type == null || type.length() == 0) {
            throw new MusicalInstrumentException("Invalid type: Type cannot be null or empty.");
        }

        for (String validType : validTypes) {
            if (type.equalsIgnoreCase(validType)) {
                this.type = type.toLowerCase();
                return;
            }
        }

        throw new MusicalInstrumentException("Invalid type: " + type + " is not a valid instrument type.");
    }

    public void setName(String name) throws MusicalInstrumentException {
        if (name == null || name.length() == 0) {
            throw new MusicalInstrumentException("Invalid name: Name cannot be null or empty.");
        }

        this.name = name.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getNumberOfKeysorStrings() {
        return numberOfKeysorStrings;
    }

    public void setNumberOfKeysorStrings(int numberOfKeysorStrings) {
        if (numberOfKeysorStrings > MAXIMUMSTRINGSORKEYS || numberOfKeysorStrings < MINIMUMSTRINGSORKEYS) {
            this.numberOfKeysorStrings = UNKNOWNKEYSORSTRINGS;
            return;
        } else {
            this.numberOfKeysorStrings = numberOfKeysorStrings;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < LOWESTPRICE) {
            this.price = UNKNOWNPRICE;
        } else {
            this.price = price;
        }
    }

    public String toString() {
        return ("[name= " + name + ", type= " + type + ", numberOfKeysorStrings= " +
                numberOfKeysorStrings + ", price= " + price + "]");
    }
}

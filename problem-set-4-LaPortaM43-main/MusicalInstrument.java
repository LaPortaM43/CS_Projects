package edu.monmouth.problemSet1;

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

	public MusicalInstrument() {
		setName(UNKNOWNNAME);
		setType(UNKNOWNTYPE);
		setNumberOfKeysorStrings(UNKNOWNKEYSORSTRINGS);
		setPrice(UNKNOWNPRICE);
	}
	public MusicalInstrument(String name, String type, int numberOfKeysorStrings) {
		setName(name);
		setType(type);
		setNumberOfKeysorStrings(numberOfKeysorStrings);
		setPrice(UNKNOWNPRICE);
	}
	
	
    public MusicalInstrument(String name, String type, int numberOfKeysorStrings, double price) {
        setName(name);
        setType(type);
        setNumberOfKeysorStrings(numberOfKeysorStrings);
        setPrice(price);
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name == null || name.length() == 0) {
			this.name = UNKNOWNNAME;
			return;	
		} else {
			this.name = name.toLowerCase();
		}
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
	    String[] validTypes = {"woodwind", "brass", "string", "percussion", "keyboard"};
	    
	    if (type != null && type.length() > LOWESTNAMELENGTH) {
	        for (String validType : validTypes) {
	            if (type.equalsIgnoreCase(validType)) {
	                this.type = type.toLowerCase();
	                return;
	            }
	        }
	        
	        this.type = UNKNOWNTYPE;
	    }
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

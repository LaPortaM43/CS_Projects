package edu.monmouth.problemSet1;

public class MusicalInstrument {
	
	final String UNKNOWNNAME = "UNKNOWNNAME";
	final String UNKNOWNTYPE = "UNKNOWNTYPE";
	final int UNKNOWNKEYSORSTRINGS = -1;
	
	private String name;
	private String type;
	private int numberOfKeysorStrings;

	public MusicalInstrument() {
		setName(UNKNOWNNAME);
		setType(UNKNOWNTYPE);
		setNumberOfKeysorStrings(UNKNOWNKEYSORSTRINGS);
	}
	public MusicalInstrument(String name, String type, int numberOfKeysorStrings) {
		setName(name);
		setType(type);
		setNumberOfKeysorStrings(numberOfKeysorStrings);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name == null || name.length() == 0) {
			this.name = UNKNOWNNAME;
			return;	
		} else {
			this.name = name;
		}
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		if (type != null && type.length() > 0) { 
			if (type.equalsIgnoreCase("woodwind") || type.equalsIgnoreCase("string") || 
				type.equalsIgnoreCase("brass") || type.equalsIgnoreCase("keyboard") || 
				type.equalsIgnoreCase("percussion")) {
				this.type = type;
			} else {
				this.type = UNKNOWNTYPE;
			}
		}
	}
	public int getNumberOfKeysorStrings() {
		return numberOfKeysorStrings;
	}
	public void setNumberOfKeysorStrings(int numberOfKeysorStrings) {
		if (numberOfKeysorStrings > 100 || numberOfKeysorStrings < 1) {
			this.numberOfKeysorStrings = UNKNOWNKEYSORSTRINGS;
			return;
		} else {
			this.numberOfKeysorStrings = numberOfKeysorStrings;
		}
		
	}

}

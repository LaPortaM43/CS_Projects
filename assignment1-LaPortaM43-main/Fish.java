package edu.monmouth.animal;

public class Fish implements Animal {
    private String color;
    
    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void move() {
        System.out.println("Fish is swimming.");
    }

    @Override
    public void makeSound() {
        System.out.println("Fish is silent.");
    }

	@Override
	public String toString() {
		return "Fish [color=" + color + "]";
	}
 
}


package edu.monmouth.animal;

public class Dog implements Animal {
	 private String furColor;
	
	 public void setFurColor(String furColor) {
	     this.furColor = furColor;
	 }
	
	 public String getFurColor() {
	     return furColor;
	 }
	
	 @Override
	 public void move() {
	     System.out.println("Dog is running.");
	 }
	
	 @Override
	 public void makeSound() {
	     System.out.println("Dog is barking.");
	 }
	
	@Override
	public String toString() {
		return "Dog [furColor=" + furColor + "]";
	}
 
 
}


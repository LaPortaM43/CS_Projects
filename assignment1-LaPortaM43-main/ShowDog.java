package edu.monmouth.animal;

public class ShowDog extends Dog {
	 private String breed;
	
	 public void setBreed(String breed) {
	     this.breed = breed;
	 }
	
	 public String getBreed() {
	     return breed;
	 }
	 
	 @Override
	 public void move() {
	     System.out.println("ShowDog is running.");
	 }
	
	 @Override
	 public void makeSound() {
	     System.out.println("ShowDog is barking.");
	 }

	@Override
	public String toString() {
		return "ShowDog [breed=" + breed + "]";
	}
	 
	 
}


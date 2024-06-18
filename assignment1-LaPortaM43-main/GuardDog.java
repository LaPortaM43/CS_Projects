package edu.monmouth.animal;

public class GuardDog extends Dog {
	 private short meanness;
	
	 public void setMeanness(short meanness) {
		this.meanness = meanness;
	}

	 public short getMeanness() {
	     return meanness;
	 }
	 
	 @Override
	 public void move() {
	     System.out.println("GuardDog is running.");
	 }
	
	 @Override
	 public void makeSound() {
	     System.out.println("GuardDog is barking.");
	 }

	@Override
	public String toString() {
		return "GuardDog [meanness=" + meanness + "]";
	}
	 
}


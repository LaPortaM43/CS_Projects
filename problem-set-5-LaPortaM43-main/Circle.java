package edu.monmouth.problemSet5;

public class Circle implements Shape {
	
	private int radius; 

	public Circle(int radius) {
		super();
		setRadius(radius);
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 0;
        }
    }

	@Override
	public double area() {
		double area = Math.PI * radius * radius;
		return area; 

	}

}

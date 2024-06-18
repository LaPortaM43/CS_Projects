package edu.monmouth.problemSet5;

public class Rectangle implements Shape {
	
	private int length;
	private int width;
	
	public Rectangle(int length, int width) {
		super();
		setLength(length);
		setWidth(width);
	}
	
	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + "]";
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		if (length > 0) {
			this.length = length;
	    } else {
	    	this.length = 0;
	    }
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if (width > 0) {
			this.width = width;
	    } else {
	    	this.width = 0;
	    }
	}

	@Override
	public double area() {
		int area = length * width; 
		return area;

	}

}

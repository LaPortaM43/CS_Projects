package edu.monmouth.shape;

public class Circle implements Shape, Comparable<Circle>{
    private int radius;
    private String name;

    public Circle(String name, int radius) {
        setRadius(radius);
        setName(name);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Circle [radius=" + radius + " name=" + name + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Circle other = (Circle) obj;
        if (radius != other.radius) {
            return false;
        }
        return (this.name.equals(other.name));
    }

    @Override
    public int compareTo(Circle otherCircle) {
        return this.radius - otherCircle.radius;
    }

    @Override
    public double area() {
        return Math.PI * (radius*radius);
    }
}


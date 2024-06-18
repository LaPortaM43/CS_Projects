package edu.monmouth.lab3;

import java.util.Objects;

public class Competitor implements Comparable<Competitor> {
    private String name;
    private int score;

    
    public Competitor(String name, int score) {
    	setName(name);
    	setScore(score);
 
    }
    
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || !(obj instanceof Competitor))
            return false;
        Competitor that = (Competitor) obj;
        return score == that.score;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
    
    @Override
    public int compareTo(Competitor other) {
        return Integer.compare(this.score, other.score);
    }
}

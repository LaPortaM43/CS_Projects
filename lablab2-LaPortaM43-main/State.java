package edu.monmouth.lab2;

import java.util.Objects;

public class State {
    private String name;
    private int coastLength;
    private String stateBird;

    public State(String name, int coastLength, String stateBird) {
        setName(name);
        setCoastLength(coastLength);
        setStateBird(stateBird);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoastLength() {
        return coastLength;
    }

    public void setCoastLength(int coastLength) {
        this.coastLength = coastLength;
    }

    public String getStateBird() {
        return stateBird;
    }

    public void setStateBird(String stateBird) {
        this.stateBird = stateBird;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        State state = (State) obj;
        return coastLength == state.coastLength &&
                Objects.equals(name, state.name) &&
                Objects.equals(stateBird, state.stateBird);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coastLength, stateBird);
    }

    @Override
    public String toString() {
        return "State [name=" + name + ", coastLength=" + coastLength + ", stateBird=" + stateBird + "]";
    }
}



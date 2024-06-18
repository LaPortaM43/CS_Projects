package edu.monmouth.lab2;

import java.util.Objects;

public class Governor {
    private String name;
    private int age;

    public Governor(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Governor governor = (Governor) obj;
        return age == governor.age &&
                Objects.equals(name, governor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Governor [name=" + name + ", age=" + age + "]";
    }
}

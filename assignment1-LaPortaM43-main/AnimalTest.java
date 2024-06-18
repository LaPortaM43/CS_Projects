package edu.monmouth.animal;

import java.util.Arrays;

public class AnimalTest {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 5;

        Animal[] animals = new Animal[ARRAY_SIZE];
        
        Dog bob = new Dog(); 
        bob.setFurColor("Brown");
        
        Fish nemo = new Fish();
        nemo.setColor("Orange");
        
        GuardDog gerald = new GuardDog();
        gerald.setMeanness((short) 10);
        
        ShowDog max = new ShowDog();
        max.setBreed("Yorkie");
        
        Dog henry = new Dog();
        henry.setFurColor("White");
        
        animals[0] = bob;
        animals[1] = nemo;
        animals[2] = gerald;
        animals[3] = max;
        animals[4] = henry;  

        System.out.println("Using advanced for loop:");
        for (Animal animal : animals) {
            animal.move();
            animal.makeSound();
            System.out.println(animal.toString());
            System.out.println("------------------");
        }

        System.out.println("Using normal for loop:");
        for (int i = 0; i < animals.length; i++) {
            animals[i].move();
            animals[i].makeSound();
            System.out.println(animals[i].toString());
            System.out.println("------------------");
        }

        System.out.println("Using while loop:");
        int index = 0;
        while (index < animals.length) {
            animals[index].move();
            animals[index].makeSound();
            System.out.println(animals[index].toString());
            System.out.println("------------------");
            index++;
        }

        System.out.println("Printing all Animals using Arrays.toString():");
        System.out.println(Arrays.toString(animals));

        Animal[] newAnimals = Arrays.copyOf(animals, 3);
        System.out.println("Printing first three Animals in the new array:");
        System.out.println(Arrays.toString(newAnimals));
    }
}



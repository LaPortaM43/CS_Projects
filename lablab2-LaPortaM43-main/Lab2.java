package edu.monmouth.lab2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Lab2 {
    public static void main(String[] args) {
    	
        // Validate there is one and only one command line argument given
        if (args.length != Lab2Constants.NUMBEROFARGUMENTS) {
            System.err.println("Error: Please provide the name of the file to which standard error and standard out will be redirected.");
            System.exit(Lab2Constants.WRONGARGUMENT); 
        }

        // Redirect standard error and standard out using the method presented in class
        try {
            PrintStream ps = new PrintStream(new FileOutputStream(Lab2Constants.OUTPUTFILE));
            System.setOut(ps);
            System.setErr(ps);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found." + Lab2Constants.OUTPUTFILE);
            e.printStackTrace();
            System.exit(Lab2Constants.WRONGARGUMENT); 
        }
        
        State newJersey = new State("New Jersey", 130,  "Eastern Goldfinch");
    	State newYork = new State("New York", 127,  "Eastern Bluebird");
    	State pennsylvania = new State("Pennsylvania", 0,  "Ruffled Grouse");
    	State delaware = new State("Delaware", 28,  "Blue Hen");
    	State maryland = new State("Maryland", 31,  "Oriole");
    	State connecticut = new State("Connecticut", 96,  "Robin");
    	State newJersey2 = new State("New Jersey", 130,  "Eastern Goldfinch");
    	
    	Governor njGov = new Governor("Murphy", 65);
    	Governor nyGov = new Governor("Hochul", 64);
    	Governor paGov = new Governor("Shapiro", 49);
    	Governor deGov = new Governor("Carney", 66);
    	Governor mdGov = new Governor("Moore", 44);
    	Governor ctGov = new Governor("Lamont", 69);
    	
        // Verify State hashCode and equals methods are consistent
        System.out.println("--------------------------------------------");
        System.out.println("Verifying State hashCode and equals methods");
        System.out.println("--------------------------------------------");
        State stateTest1 = new State("New Jersey", 130, "Eastern Goldfinch");
        State stateTest2 = new State("New Jersey", 130, "Eastern Goldfinch");

        System.out.println("State1 equals State2: " + stateTest1.equals(stateTest2));
        System.out.println("State1 hash code: " + stateTest1.hashCode());
        System.out.println("State2 hash code: " + stateTest2.hashCode());
        
        State stateTest3 = new State("New York", 127,  "Eastern Bluebird");
        System.out.println("StateTest2 equals StateTest3: " + stateTest2.equals(stateTest3));
        System.out.println("StateTest2 hash code: " + stateTest2.hashCode());
        System.out.println("StateTest3 hash code: " + stateTest3.hashCode());

        // Verify Governor hashCode and equals methods are consistent
        System.out.println("-----------------------------------------------");
        System.out.println("Verifying Governor hashCode and equals methods");
        System.out.println("-----------------------------------------------");
        Governor governorTest1 = new Governor("Murphy", 65);
        Governor governorTest2 = new Governor("Murphy", 65);

        System.out.println("GovernorTest1 equals Governor2: " + governorTest1.equals(governorTest2));
        System.out.println("GovernorTest1 hash code: " + governorTest1.hashCode());
        System.out.println("GovernorTest2 hash code: " + governorTest2.hashCode());
        
        Governor governorTest3 = new Governor("Hochul", 64);

        System.out.println("GovernorTest2 equals GovernorTest3: " + governorTest2.equals(governorTest3));
        System.out.println("GovernorTest2 hash code: " + governorTest2.hashCode());
        System.out.println("GovernorTest3 hash code: " + governorTest3.hashCode());
        
        // create a HashSet that can only house State objects
        Set<State> stateHashSet = new HashSet<>();

        // attempt to insert all 7 State objects to the HashSet
    	// print whether or not the object was added or not
        System.out.println("--------------------------------------------------------");
        System.out.println("Inserting State Objects to HashSet and printing if added");
        System.out.println("--------------------------------------------------------");
        
        System.out.println("New Jersey added: " + stateHashSet.add(newJersey));
        System.out.println("New York added: " + stateHashSet.add(newYork));
        System.out.println("Pennsylvania added: " + stateHashSet.add(pennsylvania));
        System.out.println("Delaware added: " + stateHashSet.add(delaware));
        System.out.println("Maryland added: " + stateHashSet.add(maryland));
        System.out.println("Connecticut added: " + stateHashSet.add(connecticut));
        System.out.println("New Jersey 2 added: " + stateHashSet.add(newJersey2)); 

        // Iterate through the HashSet for each State 
        System.out.println("--------------------------------------");
        System.out.println("Iterate through HashSet for each State");
        System.out.println("--------------------------------------");
        for (State state : stateHashSet) {
            System.out.println(state);
        }

        // create a HashMap associating State and Governor objects
        HashMap<State, Governor> stateGovernorHashMap = new HashMap<>();

        // for the 6 unique State objects insert State and Governor objects 
        stateGovernorHashMap.put(newJersey, njGov);
        stateGovernorHashMap.put(newYork, nyGov);
        stateGovernorHashMap.put(pennsylvania, paGov);
        stateGovernorHashMap.put(delaware, deGov);
        stateGovernorHashMap.put(maryland, mdGov);
        stateGovernorHashMap.put(connecticut, ctGov);

        // Print the number of elements in the HashMap
        System.out.println("---------------------------------");
        System.out.println("Number of elements in HashMap: " + stateGovernorHashMap.size());
        System.out.println("---------------------------------");

        // Print all elements in the HashMap
        System.out.println("--------------------");
        System.out.println("Elements in HashMap:");
        System.out.println("--------------------");
        for (State state : stateGovernorHashMap.keySet()) {
            System.out.println("State: " + state + " - Governor: " + stateGovernorHashMap.get(state));
        }

        // Print the governor for the state of New York
        System.out.println("-----------------------------------------------------");
        System.out.println("Governor for New York: " + stateGovernorHashMap.get(newYork));
        System.out.println("-----------------------------------------------------");

        // Determine if the “newJersey” State object exists in the HashMap
        // If it exists, print the governor 
        System.out.println("------------------------------------");
        System.out.println("Determining governor for New Jersey:");
        System.out.println("------------------------------------");
        Governor newJerseyGovernor = stateGovernorHashMap.get(newJersey);
        if (newJerseyGovernor != null) {
            System.out.println("Governor for New Jersey: " + newJerseyGovernor);
        } else {
            System.out.println("New Jersey does not exist in HashMap.");
        }

        // determine if the State object rhodeIsland exists as a key in the HashSet containing states
        System.out.println("-----------------------------------------------------");
        System.out.println("Determine if State object rhodeIsland exists as a key");
        System.out.println("-----------------------------------------------------");
        State rhodeIsland = new State("Rhode Island", 40, "Rhode Island Red");
        if (stateGovernorHashMap.containsKey(rhodeIsland)) {
            System.out.println("Rhode Island exists in HashMap.");
        } else {
            System.out.println("Rhode Island does not exist in HashMap.");
        }
    }
}


package edu.monmouth.tree;

import java.io.*;
import java.util.Properties; 

public class TreeApp {


	public static void main(String[] args) {

	    if (args.length != TreeAppConstants.NUMBEROFARGUMENTS) {
	        System.err.println("Usage: java TreeApp <properties-file>");
	        System.exit(TreeAppConstants.WRONGARGUMENTS); 
	    }
	    
	    Properties properties = new Properties();
	    try {
	        FileInputStream fileInputStream = new FileInputStream(args[0]);
	        properties.load(fileInputStream);
	        fileInputStream.close();
	    } catch (FileNotFoundException e) {
	        System.err.println("Properties file not found: " + args[0]);
	        e.printStackTrace();
	        System.exit(TreeAppConstants.WRONGARGUMENTS); 
	    } catch (IOException e) {
	        System.err.println("Error loading properties file: " + args[0]);
	        e.printStackTrace();
	        System.exit(TreeAppConstants.WRONGARGUMENTS); 
	    }

	    String logFileName = properties.getProperty(TreeAppConstants.LOG_FILE_NAME_PROPERTY);

	    try {
	        PrintStream fileOut = new PrintStream(logFileName);
	        System.setOut(fileOut);
	        System.setErr(fileOut);
	    } catch (FileNotFoundException e) {
	        System.err.println("Error redirecting output to log file: " + logFileName);
	        e.printStackTrace();
	        System.exit(TreeAppConstants.WRONGARGUMENTS); 
	    }

	    String nodeValuesStr = properties.getProperty("node_values");

	    if (nodeValuesStr == null || nodeValuesStr.isEmpty()) {
	        System.err.println("Error: node_values property is missing or empty.");
	        System.exit(TreeAppConstants.WRONGARGUMENTS);
	    }

	    String[] nodeValuePairs = nodeValuesStr.split(";");

	    Tree tree = new Tree();

	    for (String pair : nodeValuePairs) {
	    
	        String[] keyValue = pair.split(",");
	        if (keyValue.length != 2) {
	            System.err.println("Error: Invalid node value pair format: " + pair);
	            continue; 
	        }
	        try {
	            int key = Integer.parseInt(keyValue[0]);
	            double value = Double.parseDouble(keyValue[1]);
	            tree.insert(key, value); 
	        } catch (NumberFormatException e) {
	            System.err.println("Error: Invalid number format in node value pair: " + pair);
	            continue; 
	        }
	    }

	    tree.min();
	    tree.max();
	    tree.find(10);

	    System.out.println("Find(10): " + tree.find(10));
	    System.out.println("Min: " + tree.min());
	    System.out.println("Max: " + tree.max());
	}

}



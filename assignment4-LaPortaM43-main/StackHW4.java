package edu.monmouth.hw4;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Stack;

public class StackHW4 {
	public static void main(String[] args) {
        // Check if there is exactly one command line argument
        if (args.length != 1) {
            System.err.println("Usage: java StackPalindromeChecker <properties_file>");
            return;
        }

        String propertiesFileName = args[0];

        // Read properties file and get log file name and words
        String logFileName = null;
        String words = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(propertiesFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    if (key.equals("log_file_name")) {
                        logFileName = value;
                    } else if (key.equals("words")) {
                        words = value;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading properties file: " + e.getMessage());
            return;
        }

        // Check if logFileName and words are properly initialized
        if (logFileName == null || words == null) {
            System.err.println("log_file_name or words property not found in the properties file.");
            return;
        }

        // Redirect stdout and stderr to log file
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(logFileName))) {
            System.setOut(new PrintStream(new FileOutputStream(logFileName, true)));
            System.setErr(new PrintStream(new FileOutputStream(logFileName, true)));
        } catch (IOException e) {
            System.err.println("Error redirecting output to log file: " + e.getMessage());
            return;
        }



        // Parse words and check for palindromes
        String[] wordArray = words.split(",");
        for (String word : wordArray) {
            if (isPalindrome(word)) {
                System.out.println(word + " is a palindrome.");
            } else {
                System.out.println(word + " is not a palindrome.");
            }
        }
    }

    private static boolean isPalindrome(String word) {
        Stack<Character> stack = new Stack<>();
        StringBuilder reversedWord = new StringBuilder();

        // Push each character onto the stack
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        // Pop each character off the stack and build the reversed word
        while (!stack.isEmpty()) {
            reversedWord.append(stack.pop());
        }

        // Compare the reversed word with the original word
        return word.equals(reversedWord.toString());
    }
}

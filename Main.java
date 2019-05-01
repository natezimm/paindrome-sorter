package com.nathan;

import java.io.File;
import java.util.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //Initialize file and scanner
        File file = new File("test.txt");
        Scanner scanner = new Scanner(file);

        //Create arraylist to hold values of file
        List<String> words = new ArrayList<String>();

        //Loop through file and add strings to arraylist
        while (scanner.hasNext()) {
            String word = scanner.next();
            words.add(word);
        }

        //Initialize count of palindromes
        int palindromeCounter = 0;
        System.out.println("Palindromes in file: ");

        //Loop through arraylist to check if each string is palindrome
        for(int i = 0; i < words.size(); i++){
            if(isPalindrome(words.get(i))){
                palindromeCounter++;
                System.out.print(words.get(i) + " ");
            }
        }

        //Print total
        System.out.println("Number of palindromes in this file: " + palindromeCounter);

        //Sort strings in arraylist
        Collections.sort(words);

        //Initialize file writer for each file to add values
        WriteToFile firstFile = new WriteToFile("output1.txt", true);
        WriteToFile secondFile = new WriteToFile("output2.txt", true);

        for(int i = 0; i < words.size(); i++){
            char c = words.get(i).charAt(0);
            if (c >= 'A' && c <= 'M' || c >= 'a' && c <= 'm'){
                firstFile.writeToTheFile(words.get(i));
            } else {
                secondFile.writeToTheFile(words.get(i));
            }
        }

        //Close the scanner
        scanner.close();

    }

    //Method to check if a string is a palindrome
    public static boolean isPalindrome (String input){
        int n = input.length();
        for(int i = 0; i < n; i++){
            if(!Character.isLetter(input.charAt(i))){
                return false;
            }
        }
        int front = 0;
        int rear = n - 1;
        while (rear > front) {
            char forwardLetter = input.charAt(front++);
            char backwardLetter = input.charAt(rear--);
            if (forwardLetter != backwardLetter){
                return false;
            }
        }
        return true;
    }
}


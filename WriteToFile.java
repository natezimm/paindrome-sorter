package com.nathan;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class WriteToFile {
    //Initialize variables for class
    private String file;
    private boolean addToFile = false;

    //Constructor
    public WriteToFile(String fileLocation){
        file = fileLocation;
    }

    //Constructor
    public WriteToFile(String file_path, boolean addValue){
        file = file_path;
        addToFile = addValue;
    }

    //Method to print string values to file
    public void writeToTheFile(String textLine) throws IOException {
        FileWriter write = new FileWriter(file, addToFile);
        PrintWriter printLine = new PrintWriter(write);

        printLine.printf("%s" + "%n", textLine);

        printLine.close();
    }
}

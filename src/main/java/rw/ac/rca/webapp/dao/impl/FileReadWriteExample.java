package rw.ac.rca.webapp.dao.impl;// Importing File class
import java.io.File;
// Importing the IOException class for handling errors
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class CreateFile {
    public static void main(String args[]) {
        try {
            // Creating an object of a file
            File f0 = new File("C:FileOperationExample.txt");
            if (f0.createNewFile()) {
                FileWriter fileWriter = new FileWriter("C:FileOperationExample.txt");
                fileWriter.write("Hello world");
                fileWriter.close();
            } else {
                Scanner dataReader = new Scanner(f0);
                while(dataReader.hasNext()){
                    String fileData = dataReader.nextLine();
                    System.out.println(fileData);
                }
                dataReader.close();
            }
        } catch (IOException exception) {
            System.out.println("An unexpected error is occurred.");
            exception.printStackTrace();
        }
    }
}
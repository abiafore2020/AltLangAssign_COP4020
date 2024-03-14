import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csvFile = "cells.csv"; // Open csv file
        String line; 
        String cvsSplitBy = ","; // Split csv into singular data fields

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy); // splits lines into data fields
                // 
            }
        } catch (IOException e) { // Handle IO exceptions and print for debugging
            e.printStackTrace();
        }
    }
}

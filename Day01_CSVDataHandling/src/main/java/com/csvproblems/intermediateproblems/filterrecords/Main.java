package com.csvproblems.intermediateproblems.filterrecords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath ="src/main/java/com/csvproblems/intermediateproblems/filterrecords/file.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] column = line.split(",");

                // Check if the row has enough columns before accessing them
                if (column.length >= 4) {
                    try {
                        int marks = Integer.parseInt(column[3]);
                        if (marks >= 80) {
                            System.out.println("ID: " + column[0] + ", Name: " + column[1] + ", Age: " + column[2] + ", Marks: " + column[3]);
                        }
                    } catch (NumberFormatException e) {
                        // If the marks column is not an integer, handle it
                        System.out.println("Invalid marks format in row: " + line);
                    }
                } else {
                    System.out.println("Skipping invalid row: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

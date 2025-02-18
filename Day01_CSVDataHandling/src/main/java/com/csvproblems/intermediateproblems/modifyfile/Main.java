package com.csvproblems.intermediateproblems.modifyfile;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/csvproblems/intermediateproblems/modifyfile/file.csv";
        String newFilePath = "src/main/java/com/csvproblems/intermediateproblems/modifyfile/file2.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(newFilePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] column = line.split(",");

                // Update salary for IT department employees
                if (column[1].equals("IT")) {
                    try {
                        double salary = Double.parseDouble(column[2]) * 1.10; // Increase salary by 10%
                        column[2] = String.valueOf(salary);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid salary format in row: " + line);
                    }
                    bw.write(String.join(",", column));  // Write updated row
                    bw.newLine();
                } // Add a new line after each row
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

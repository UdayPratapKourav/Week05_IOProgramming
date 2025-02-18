package com.csvproblems.advancedproblems.mergetwofiles;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath1 ="src/main/java/com/csvproblems/advancedproblems/mergetwofiles/file1.csv";
        String filePath2 ="src/main/java/com/csvproblems/advancedproblems/mergetwofiles/file2.csv";
        String restulFile="src/main/java/com/csvproblems/advancedproblems/mergetwofiles/result.csv";
        Map<Integer, String[]> studentMap = new HashMap<>();

        // Read students1.csv (ID, Name, Age)
        try (BufferedReader br = new BufferedReader(new FileReader(filePath1))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length < 3) continue;

                int id = Integer.parseInt(columns[0].trim());
                String name = columns[1].trim();
                String age = columns[2].trim();

                studentMap.put(id, new String[]{name, age, "", ""}); // Placeholder for Marks & Grade
            }
        } catch (IOException e) {
            System.out.println("Error reading file1: " + e.getMessage());
        }

        // Read students2.csv (ID, Marks, Grade) and merge with studentMap
        try (BufferedReader br = new BufferedReader(new FileReader(filePath2))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length < 3) continue;

                int id = Integer.parseInt(columns[0].trim());
                String marks = columns[1].trim();
                String grade = columns[2].trim();

                if (studentMap.containsKey(id)) {
                    String[] details = studentMap.get(id);
                    details[2] = marks;
                    details[3] = grade;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file2: " + e.getMessage());
        }

        // Write merged data to a new CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(restulFile))) {
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            for (Map.Entry<Integer, String[]> entry : studentMap.entrySet()) {
                int id = entry.getKey();
                String[] details = entry.getValue();
                bw.write(id + "," + String.join(",", details));
                bw.newLine();
            }

            System.out.println("Merged CSV file created successfully!");
        } catch (IOException e) {
            System.out.println("Error writing merged file: " + e.getMessage());
        }
    }
}

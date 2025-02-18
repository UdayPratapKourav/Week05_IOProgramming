package com.csvproblems.advancedproblems.detectduplicates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath="src/main/java/com/csvproblems/advancedproblems/detectduplicates/file.csv";
        Set<String> uniqueIds = new HashSet<>();
        List<String> duplicateRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                // Skip header
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] columns = line.split(",");
                if (columns.length == 0) continue;

                String id = columns[0].trim(); // Assuming ID is the first column

                // Check for duplicates
                if (!uniqueIds.add(id)) {
                    duplicateRecords.add(line);
                }
            }

            // Print duplicate records
            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records Found:");
                for (String record : duplicateRecords) {
                    System.out.println(record);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

package com.csvproblems.advancedproblems.readlargefile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath="src/main/java/com/csvproblems/advancedproblems/readlargefile/file.csv";
        int batchSize = 100; // Process 100 lines at a time
        int totalRecords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int batchCount = 0;

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                batchCount++;
                totalRecords++;

                // Process the line (Example: Just print the first record in a batch)
                if (batchCount == 1) {
                    System.out.println("Processing record: " + line);
                }

                // Process in batches of 100
                if (batchCount == batchSize) {
                    System.out.println("Processed " + totalRecords + " records so far...");
                    batchCount = 0; // Reset batch count
                }
            }

            // Final summary
            System.out.println("Total records processed: " + totalRecords);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

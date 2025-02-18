package com.csvproblems.advancedproblems.validatedata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String filePath="src/main/java/com/csvproblems/advancedproblems/validatedata/file.csv";
        // Define regex patterns for validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^[0-9]{10}$";

        // Compile the regex patterns
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String header = br.readLine(); // Read the header

            if (header != null) {
                System.out.println("Validating CSV Data...");
                System.out.println(header); // Print column headers
            }

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");

                // Assuming Email is at index 3 and Phone Number is at index 4
                if (columns.length < 5) {
                    System.out.println("Invalid row (Missing Columns): " + line);
                    continue;
                }

                String email = columns[3].trim();
                String phoneNumber = columns[4].trim();

                boolean isEmailValid = emailPattern.matcher(email).matches();
                boolean isPhoneValid = phonePattern.matcher(phoneNumber).matches();

                if (!isEmailValid || !isPhoneValid) {
                    System.out.print("Invalid Row: " + line + " | Error: ");
                    if (!isEmailValid) System.out.print("Invalid Email Format. ");
                    if (!isPhoneValid) System.out.print("Invalid Phone Number. ");
                    System.out.println();
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

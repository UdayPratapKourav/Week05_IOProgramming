package com.csvproblems.advancedproblems.convertdataintojavaobjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/csvproblems/advancedproblems/convertdataintojavaobjects/file.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");

                // Ensure proper data format
                if (columns.length < 4) {
                    System.out.println("Skipping invalid row: " + line);
                    continue;
                }

                try {
                    int id = Integer.parseInt(columns[0].trim());
                    String name = columns[1].trim();
                    String department = columns[2].trim();
                    double marks = Double.parseDouble(columns[3].trim());

                    // Create Student object and add to list
                    students.add(new Student(id, name, department, marks));
                } catch (NumberFormatException e) {
                    System.out.println("Skipping row due to invalid data format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Print all students
        System.out.println("Student List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

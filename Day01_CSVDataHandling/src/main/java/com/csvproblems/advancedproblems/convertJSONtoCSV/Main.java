package com.csvproblems.advancedproblems.convertJSONtoCSV;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String jsonFile = "src/main/java/com/csvproblems/advancedproblems/convertJSONtoCSV/students.json";
        String csvFile = "src/main/java/com/csvproblems/advancedproblems/convertJSONtoCSV/students.csv";
        String jsonOutputFile = "src/main/java/com/csvproblems/advancedproblems/convertJSONtoCSV/students_output.json";

        // Convert JSON to CSV
        jsonToCsv(jsonFile, csvFile);

        // Convert CSV back to JSON
        csvToJson(csvFile, jsonOutputFile);
    }

    // Convert JSON to CSV
    public static void jsonToCsv(String jsonFilePath, String csvFilePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Student> students = Arrays.asList(objectMapper.readValue(new File(jsonFilePath), Student[].class));

            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
                // Write header
                String[] header = {"ID", "Name", "Age", "Grade"};
                writer.writeNext(header);

                // Write data rows
                for (Student student : students) {
                    String[] row = {String.valueOf(student.getId()), student.getName(), String.valueOf(student.getAge()), student.getGrade()};
                    writer.writeNext(row);
                }
                System.out.println("✅ JSON to CSV conversion successful!");
            }
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // Convert CSV to JSON
    public static void csvToJson(String csvFilePath, String jsonFilePath) {
        List<Student> students = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            csvReader.readNext(); // Skip header row

            String[] columns;
            while ((columns = csvReader.readNext()) != null) {
                if (columns.length < 4) {
                    System.out.println("⚠️ Skipping invalid row: " + Arrays.toString(columns));
                    continue;
                }

                try {
                    Student student = new Student(
                            Integer.parseInt(columns[0].trim()), // Ensure no spaces in numeric fields
                            columns[1].trim(),
                            Integer.parseInt(columns[2].trim()),
                            columns[3].trim()
                    );
                    students.add(student);
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Skipping malformed row: " + Arrays.toString(columns));
                }
            }

            // Convert list to JSON and save
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(jsonFilePath), students);
            System.out.println("✅ CSV to JSON conversion successful!");
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }catch (Exception g){
            System.out.println(g.getMessage());
        }
    }
}

// Student Model Class
class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    // Constructors
    public Student() {}

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}

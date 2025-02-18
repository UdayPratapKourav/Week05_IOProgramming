package com.csvproblems.basicproblems.writedata;


import java.io.BufferedWriter;

import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        String filePath="src/main/java/com/csvproblems/basicproblems/writedata/file.csv";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
            bw.write("ID,Name,Department,Salary\n");
            bw.write("104,Alice Williams,Finance,62000\n");
            bw.write("105,Bob Johnson,Sales,58000\n");
            System.out.println("CSV file written successfully!");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

package com.csvproblems.intermediateproblems.searchforarecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath= "src/main/java/com/csvproblems/intermediateproblems/searchforarecord/employees.csv";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the employee :");
        String employeeName=sc.nextLine();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line=br.readLine())!=null){
                String[] column=line.split(",");
                if(column[0].equals(employeeName)){
                    System.out.println("Name : "+column[0]+", Department : "+column[1]+", Salary : "+column[2]);
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

package com.csvproblems.basicproblems.readandprint;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/csvproblems/basicproblems/readandprint/file.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line ;
            while ((line=br.readLine())!=null){
                String[] columns=line.split(",");
                System.out.println("ID: " + columns[0] + ", Name: " + columns[1] +", Age : "+columns[2]+", Marks : "+columns[3]);


            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

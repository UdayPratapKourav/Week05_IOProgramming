package com.csvproblems.basicproblems.readandcountrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        String filePath="src/main/java/com/csvproblems/basicproblems/readandcountrows/file.csv";
        int count=0;
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
           String line;
           while ((line=br.readLine())!=null){
               count++;
           }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Total records are : "+(count-1));
    }
}

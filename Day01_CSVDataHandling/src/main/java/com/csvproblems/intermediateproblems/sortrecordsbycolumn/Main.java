package com.csvproblems.intermediateproblems.sortrecordsbycolumn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath="src/main/java/com/csvproblems/intermediateproblems/sortrecordsbycolumn/file.csv";
        List<String[]> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String header=br.readLine();
            if(header!=null){
                System.out.println("Top 5 Highest-Paid Employees:");
                System.out.println(header);
            }

            while ((line=br.readLine())!=null){
               list.add(line.split(","));

            }
            list.sort((a, b) -> Double.compare(Double.parseDouble(b[2]), Double.parseDouble(a[2])));
            for(int i=0;i<Math.min(5,list.size());i++){
                System.out.println(String.join(",", list.get(i)));
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

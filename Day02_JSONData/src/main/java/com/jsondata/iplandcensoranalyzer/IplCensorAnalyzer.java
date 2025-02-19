package com.jsondata.iplandcensoranalyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.*;

class Match {
    public int match_id;
    public String team1;
    public String team2;
    public Map<String, Integer> score;
    public String winner;
    public String player_of_match;

    // Apply censorship rules
    public void applyCensorship() {
        this.team1 = maskTeamName(team1);
        this.team2 = maskTeamName(team2);
        this.winner = maskTeamName(winner);
        this.player_of_match = "REDACTED";
    }

    private String maskTeamName(String team) {
        if (team.contains(" ")) {
            return team.substring(0, team.indexOf(" ")) + " ***";
        }
        return team;
    }
}

public class IplCensorAnalyzer {
    public static void main(String[] args) {
        String jsonInput="src/main/java/com/jsondata/iplandcensoranalyzer/file.json";
        String csvInput="src/main/java/com/jsondata/iplandcensoranalyzer/file1.csv";
        String jsonOutput="src/main/java/com/jsondata/iplandcensoranalyzer/output.json";
        String csvOutput="src/main/java/com/jsondata/iplandcensoranalyzer/output1.csv";

        processJson(jsonInput, jsonOutput);
        processCsv(csvInput, csvOutput);
    }

    // Process JSON File
    private static void processJson(String inputFile, String outputFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, Match.class);
            List<Match> matches = objectMapper.readValue(new File(inputFile), listType);

            for (Match match : matches) {
                match.applyCensorship();
            }

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), matches);
            System.out.println("Censored JSON saved as " + outputFile);
        } catch (IOException e) {
            System.out.println(" Error processing JSON: " + e.getMessage());
        }
    }

    // Process CSV File
    private static void processCsv(String inputFile, String outputFile) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            List<String[]> data = reader.readAll();
            List<String[]> censoredData = new ArrayList<>();
            censoredData.add(data.get(0)); // Keep header row

            for (int i = 1; i < data.size(); i++) {
                String[] row = data.get(i);
                row[1] = maskTeamName(row[1]);
                row[2] = maskTeamName(row[2]);
                row[5] = maskTeamName(row[5]);
                row[6] = "REDACTED";
                censoredData.add(row);
            }

            writer.writeAll(censoredData);
            System.out.println("Censored CSV saved as " + outputFile);
        } catch (IOException e) {
            System.out.println(" Error processing CSV: " + e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static String maskTeamName(String team) {
        if (team.contains(" ")) {
            return team.substring(0, team.indexOf(" ")) + " ***";
        }
        return team;
    }
}

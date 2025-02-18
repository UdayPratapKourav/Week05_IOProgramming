package com.csvproblems.advancedproblems.encryptanddecrypt;



import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Base64;

public class Main {

    private static final String SECRET_KEY = "1234567890123456"; // 16-byte key for AES-128

    public static void main(String[] args) {
        String csvFile ="src/main/java/com/csvproblems/advancedproblems/encryptanddecrypt/file1.csv";
        String encryptedCsvFile = "src/main/java/com/csvproblems/advancedproblems/encryptanddecrypt/efile.csv";
        String decryptedCsvFile = "src/main/java/com/csvproblems/advancedproblems/encryptanddecrypt/dfile.csv";

        // Encrypt the sensitive fields in the CSV
        encryptCsvData(csvFile, encryptedCsvFile);

        // Decrypt the encrypted CSV
        decryptCsvData(encryptedCsvFile, decryptedCsvFile);
    }

    // Encrypt CSV Data
    public static void encryptCsvData(String inputCsvPath, String outputCsvPath) {
        try (CSVReader csvReader = new CSVReader(new FileReader(inputCsvPath));
             CSVWriter csvWriter = new CSVWriter(new FileWriter(outputCsvPath))) {

            String[] header = csvReader.readNext();
            csvWriter.writeNext(header);  // Write header row

            String[] row;
            while ((row = csvReader.readNext()) != null) {
                // Encrypt sensitive fields (Salary, Email)
                row[3] = encrypt(row[3]); // Encrypt Salary
                row[4] = encrypt(row[4]); // Encrypt Email

                csvWriter.writeNext(row);  // Write encrypted row
            }

            System.out.println("CSV data encryption successful!");

        } catch (IOException e) {
            System.out.println("Error during encryption: " + e.getMessage());
        } catch (Exception f){
            System.out.println(f.getMessage());
        }
    }

    // Decrypt CSV Data
    public static void decryptCsvData(String inputCsvPath, String outputCsvPath) {
        try (CSVReader csvReader = new CSVReader(new FileReader(inputCsvPath));
             CSVWriter csvWriter = new CSVWriter(new FileWriter(outputCsvPath))) {

            String[] header = csvReader.readNext();
            csvWriter.writeNext(header);  // Write header row

            String[] row;
            while ((row = csvReader.readNext()) != null) {
                // Decrypt sensitive fields (Salary, Email)
                row[3] = decrypt(row[3]); // Decrypt Salary
                row[4] = decrypt(row[4]); // Decrypt Email

                csvWriter.writeNext(row);  // Write decrypted row
            }

            System.out.println("CSV data decryption successful!");

        } catch (IOException e) {
            System.out.println("Error during decryption: " + e.getMessage());
        } catch (Exception f){
            System.out.println(f.getMessage());
        }
    }

    // Encrypt method using AES
    public static String encrypt(String data) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);  // Return base64 encoded string
        } catch (Exception e) {
            throw new RuntimeException("Error during encryption: " + e.getMessage());
        }
    }

    // Decrypt method using AES
    public static String decrypt(String encryptedData) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));  // Decode base64 first
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error during decryption: " + e.getMessage());
        }
    }
}

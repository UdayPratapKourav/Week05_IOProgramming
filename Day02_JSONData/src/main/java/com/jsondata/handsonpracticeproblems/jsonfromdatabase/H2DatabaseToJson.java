package com.jsondata.handsonpracticeproblems.jsonfromdatabase;

import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.*;

public class H2DatabaseToJson {
    public static void main(String[] args) {
        try {
            // Connect to H2 database (in-memory mode)
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            Statement stmt = conn.createStatement();

            // Create table and insert sample data
            stmt.execute("CREATE TABLE employees (id INT PRIMARY KEY, name VARCHAR(50), email VARCHAR(50))");
            stmt.execute("INSERT INTO employees VALUES (1, 'John Doe', 'john@example.com')");
            stmt.execute("INSERT INTO employees VALUES (2, 'Jane Smith', 'jane@example.com')");

            // Fetch records
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

            // Convert to JSON
            JSONArray jsonArray = new JSONArray();
            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", rs.getInt("id"));
                jsonObject.put("name", rs.getString("name"));
                jsonObject.put("email", rs.getString("email"));
                jsonArray.put(jsonObject);
            }

            // Print JSON report
            System.out.println(jsonArray.toString(4));

            // Close resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

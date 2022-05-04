package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateNewTable {

    public static void NewTable() {
      
        String url = "jdbc:sqlite:C://sqlite/db/Keertana.db";
        
        
        String sql = "CREATE TABLE IF NOT EXISTS Movies (\n"
                + " Id integer PRIMARY KEY,\n"
                + " Movie_Name text NOT NULL,\n"
		+ " Lead_Actor text NOT NULL,\n"
		+ " Lead_Actress text NOT NULL,\n"
		+ " Director_Name text NOT NULL,\n"
		+ " Year_Of_Release integer NOT NULL\n"
                + ");";

        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public static void main(String[] args) {
        NewTable();
    }

}

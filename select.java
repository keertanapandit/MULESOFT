
package net.sqlitetutorial;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class QueryingData {

   
    private Connection connect() {
 
        String url = "jdbc:sqlite:D://sqlite/db/Keertana.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
     
    public void selectAll(){
        String sql = "SELECT * FROM Movies";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + "\t" + 
                                   rs.getString("Movie_Name") + "\t" +
				   rs.getString("Lead_Actor") + "\t" +
				   rs.getString("Lead_Actress") + "\t" +
				   rs.getString("Director_name") + "\t" +
                                   rs.getInt("Year_Of_Release"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        QueryingData data = new QueryingData();
        data.selectAll();
    }

}

package src.com.company.TestOfTables;

import src.com.company.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class GetAllRows {

    public static void main(String[] args) throws SQLException {
        Statement stmt = null;
        try {

            JDBC.connect();

            stmt = JDBC.connection.createStatement();

            String exampleQuery1 = "SELECT * FROM authors";
            System.out.println("Authors:");
            ResultSet rs1 = stmt.executeQuery(exampleQuery1);
            while (rs1.next()) {
                int id = rs1.getInt("authorID");
                String firstName = rs1.getString("firstName");
                String lastName = rs1.getString("lastName");
                System.out.println(id + "  |  " + "\t" + firstName + "  |  "+ "\t" + lastName+ "\t");
                System.out.println("*****************************");
            }

            String exampleQuery2= "SELECT * from authorisbn";
            System.out.println("Authors ISBN:");
            ResultSet rs2 = stmt.executeQuery(exampleQuery2);
            while (rs2.next()){
                int authorID = rs2.getInt("authorID");
                String isbn = rs2.getString("isbn");
                System.out.println(authorID + "  |  "+ "\t" + isbn+ "\t");
                System.out.println("---------------------------");

            }
            String exampleQuery3= "SELECT * from publishers";
            System.out.println("Publishers:");
            ResultSet rs3 = stmt.executeQuery(exampleQuery3);
            while (rs3.next()){
                int publisherID = rs3.getInt("publisherID");
                String publisherName = rs3.getString("publisherName");
                System.out.println(publisherID + "  |  " + "\t"  + publisherName + "\t");
                System.out.println("_._._._._._._._._._._._._._.");
            }

            String exampleQuery4= "SELECT * from titles";
            System.out.println("Titles:");
            ResultSet rs4 = stmt.executeQuery(exampleQuery4);
            while (rs4.next()){
                String isbn = rs4.getString("isbn");
                String title = rs4.getString("title");
                int editionNumber = rs4.getInt("editionNumber");
                String year = rs4.getString("year");
                int publisherID = rs4.getInt("publisherID");
                float price = rs4.getFloat("price");
                System.out.println(isbn + "  |  " + "\t" + title + "\t" + "  |  " + editionNumber + "  |  " + "\t" + year + "  |  "
                        + "\t" + publisherID  + "\t" +  price + "\t");
                System.out.println("-----------------------------------------------------------------------------------------");
            }
        } catch(SQLException se) {
        // Handle errors for JDBC
        se.printStackTrace();
    } finally {
        // Finally block, used to close resources
        JDBC.close();
    }
}
}



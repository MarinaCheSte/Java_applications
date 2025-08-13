package src.com.company.Query;

import src.com.company.Connection.JDBC;

import java.sql.*;

public class SortAuthors {

    public static void main(String[] args) throws SQLException {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
//Сделайте выборку по авторам, отсортировав по их Имени и Фамилии
            String sortByName = "SELECT * FROM authors Order by firstName  ";
            System.out.println("Sort by Author's name:");
            ResultSet rs1 = stmt.executeQuery(sortByName);
            while (rs1.next()) {
                int id = rs1.getInt("authorID");
                String firstName = rs1.getString("firstName");
                String lastName = rs1.getString("lastName");
                System.out.println(id + "  |  " + "\t" + firstName + "  |  "+ "\t" + lastName+ "\t");
                System.out.println("*****************************");
            }
            String sortBySurname = "SELECT lastName, firstName FROM authors Order by lastName";
            System.out.println("Sort by Author's Surname:");
            ResultSet rs2 = stmt.executeQuery(sortBySurname);
            while (rs2.next()) {
                String lastName = rs2.getString("lastName");
                String firstName = rs2.getString("firstName");
                System.out.println( lastName + "  |  "+ "\t" + firstName+ "\t");
                System.out.println("*****************************");
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
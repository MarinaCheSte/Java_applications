package src.com.company.Query;
import src.com.company.Connection.JDBC;

import java.sql.*;
import java.util.*;

import static java.lang.Math.random;

public class NewPublisher {

    public static void main(String[] argv) {
           try {
            JDBC.connect();
            Statement stmt = JDBC.connection.createStatement();
            insertPublisher(stmt);
            changePublisherName(stmt);
            booksSort(stmt);

        } catch(SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return;
        }
        JDBC.close();
    }

    //Добавьте нового Издателя (publusher).
    private static void insertPublisher(Statement stmt) throws SQLException {
        String publishers="Select * from publishers";
        ResultSet rs = stmt.executeQuery(publishers);
        int counterId=1;

        while (rs.next()) {
            counterId=counterId+1;
        }

        String publisherName = "NewName";
        String addPublisher = "Insert into publishers values ('" + counterId
                + "', '" + publisherName + "');";
        try {
            stmt.executeUpdate(addPublisher);
        } catch (SQLException e) {
            System.out.println("Execute Publisher Update Failed!");
            e.printStackTrace();
        }
    }


    //Сделайте выборку Издателей и измените имя определенного Издателя.

    private static void changePublisherName(Statement stmt) throws SQLException {
        String publishers="Select * from publishers";
        String changeName="update publishers set publisherName='UpdatedName' where publisherID=11";
        try {
            stmt.executeUpdate(changeName);
        } catch (SQLException e) {
            System.out.println("Change Publisher Name Failed!");
            e.printStackTrace();
        }
    }

    //4)	Предоставьте отсортированный список книг определенного издателя
    // (при этом id требуемого издателя можно менять в sql запросе)

    private static void booksSort(Statement stmt) throws SQLException {
        int ID=3;
        int ID2=1;
        String changeID="update titles set publisherID="+ID+" where publisherID="+ID2;
        try {
            stmt.executeUpdate(changeID);
        } catch (SQLException e) {
            System.out.println("Execute Publisher Update Failed!");
            e.printStackTrace();
        }
        String authorBooks = "select title from titles where publisherID=" +ID+ " order by title";
        System.out.println("Sort by the book title:");
        ResultSet rs = stmt.executeQuery(authorBooks);

        while(rs.next()){
            String bookTile=rs.getString("title");
            System.out.println("Book Title: "+bookTile);

        }
    }


    //7) Добавить новую Titles (При передаче VALUES publisherID – нужно сделать
    // подзапросом select*from publisher where publisherName =””)
    //Добавить authorISBN (при передачи VALUES необходимо параметр autorID
    // так же сделать подзапросом с указанием имени и фамилии)

    private static void addNewPublischer(Statement stmt) throws SQLException{

    }
}

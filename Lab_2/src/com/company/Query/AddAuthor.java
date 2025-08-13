package src.com.company.Query;

import src.com.company.Connection.JDBC;

import java.sql.SQLException;
import java.sql.Statement;

public class AddAuthor {
    public static void main(String[] argv) {
        try {
            JDBC.connect();
            Statement stmt = JDBC.connection.createStatement();
            insertAuthor(stmt);
            updateNameID(stmt);


        } catch(SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return;
        }
        JDBC.close();
    }

    //5)	Выполните добавление Нового автора в БД

    private static void insertAuthor(Statement stmt) throws SQLException{
        String newAuthorAdded="insert into authors values ('18', 'AddedName', 'Added Surname')";

        try {
            stmt.executeUpdate(newAuthorAdded);
        } catch (SQLException e) {
            System.out.println("New Author Adding Failed!");
            e.printStackTrace();
        }
    }

    //6)	Обновите Имя автора по определенному id
    private static void updateNameID(Statement stmt) throws SQLException {
    String updateName="update authors set firstName='ChangedName' where authorID=5";
    try {
        stmt.executeUpdate(updateName);
    } catch (SQLException e) {
        System.out.println("Name change Failed!");
        e.printStackTrace();
    }}

}

package lk.ijse.jdbc;

/*
    @author DanujaV
    @created 3/7/23 - 11:27 AM   
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementCRUDDemo {
    private static void insertCustomer() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ThogaKade",
                "root",
                "Danu25412541@"
        );

        Statement statement = connection.createStatement();
        String sql = "INSERT INTO Customer(id, name, address, salary)" +
                "VALUES(\"C025\", \"Dewmith\", \"Rathgama\", \"2000\")";

        int affectedRows = statement.executeUpdate(sql);
        System.out.println("affectedRows: " + affectedRows);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        insertCustomer();
    }
}

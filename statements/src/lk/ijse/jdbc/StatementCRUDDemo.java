package lk.ijse.jdbc;

/*
    @author DanujaV
    @created 3/7/23 - 11:27 AM   
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class StatementCRUDDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/ThogaKade";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "Danu25412541@");
    }

    private static void insertCustomer() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                URL,
                props
        );

        Statement statement = connection.createStatement();
        String sql = "INSERT INTO Customer(id, name, address, salary)" +
                "VALUES(\"C025\", \"Dewmith\", \"Rathgama\", \"2000\")";

        int affectedRows = statement.executeUpdate(sql);
        System.out.println("affectedRows: " + affectedRows);
    }

    private static void updateCustomer() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, props);
        Statement statement = connection.createStatement();

        String sql = "UPDATE Customer SET name = \"deshan\", address = \"Jaffna\", salary = 23223 WHERE id = \"C024\"";
        int affectedRows = statement.executeUpdate(sql);
        System.out.println(affectedRows > 0 ? "updated!!" : "not updated!");
    }

    private static void deleteCustomer() {
        // DELETE FROM Customer WHERE id = "C025";
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        insertCustomer();

        updateCustomer();

        deleteCustomer();
    }

}

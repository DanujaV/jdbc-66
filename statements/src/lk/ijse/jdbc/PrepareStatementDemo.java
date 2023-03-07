package lk.ijse.jdbc;

/*
    @author DanujaV
    @created 3/7/23 - 2:47 PM   
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class PrepareStatementDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/ThogaKade";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "Danu25412541@");
    }

    private static void deleteCustomer(String id) throws ClassNotFoundException, SQLException {
        // since jdk1.6 & jdbc4 this will be done by automatically
        //        Class.forName("com.mysql.cj.jdbc.Driver");

        // try-with-resource
        try (Connection connection = DriverManager.getConnection(URL, props);) {
            String sql = "DELETE FROM Customer WHERE id = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, id);

            int affectedRows = pstm.executeUpdate();
            System.out.println(affectedRows > 0 ? "deleted!!" : "not delete!");
        }

//        connection.close();   // we don't want anymore
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        deleteCustomer("C022");
    }
}

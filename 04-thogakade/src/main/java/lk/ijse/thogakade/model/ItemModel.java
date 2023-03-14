package lk.ijse.thogakade.model;

/*
    @author DanujaV
    @created 3/14/23 - 2:27 PM   
*/

import lk.ijse.thogakade.dto.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ItemModel {
    private static final String URL = "jdbc:mysql://localhost:3306/ThogaKade";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "Danu25412541@");
    }
    /*public static boolean save(String code, String description, double unitPrice, int qtyOnHand) throws SQLException {
        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "INSERT INTO Item(code, description, unitPrice, qtyOnHand) " +
                    "VALUES(?, ?, ?, ?)";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, code);
            pstm.setString(2, description);
            pstm.setDouble(3, unitPrice);
            pstm.setInt(4, qtyOnHand);

            int affectedRows = pstm.executeUpdate();
            if(affectedRows > 0) {
                return true;
            } else {
                return false;
            }
        }
    }*/

    public static boolean update(String code, String description, double unitPrice, int qtyOnHand) throws SQLException {
        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "UPDATE Item SET description = ?, unitPrice = ?, " +
                    "qtyOnHand = ? WHERE code = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, description);
            pstm.setDouble(2, unitPrice);
            pstm.setInt(3, qtyOnHand);
            pstm.setString(4, code);

            return pstm.executeUpdate() > 0;
        }
    }

    public static boolean delete(String code) throws SQLException {
        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "DELETE FROM Item WHERE code = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, code);

            return pstm.executeUpdate() > 0;
        }
    }

    public static boolean save(Item item) throws SQLException {
        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "INSERT INTO Item(code, description, unitPrice, qtyOnHand) " +
                    "VALUES(?, ?, ?, ?)";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, item.getCode());
            pstm.setString(2, item.getDescription());
            pstm.setDouble(3, item.getUnitPrice());
            pstm.setInt(4, item.getQtyOnHand());

            return pstm.executeUpdate() > 0;
        }
    }

    public static List<Item> getAll() throws SQLException {
        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "SELECT * FROM Item";
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet resultSet = pstm.executeQuery();

            List<Item> dataList = new ArrayList<>();

            while (resultSet.next()) {
                String code = resultSet.getString(1);
                String description = resultSet.getString(2);
                Double unitPrice = resultSet.getDouble(3);
                Integer qtyOnHand = resultSet.getInt(4);

                Item item = new Item(code, description, unitPrice, qtyOnHand);
                dataList.add(item);
            }
            return dataList;
        }
    }
}
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderRepo {
    private Connection connection;

    public OrderRepo(Connection connection) {
        this.connection = connection;
    }

    public void createOrder(int customerId, int qty, double total, String status) throws Exception {
        // Ambil tanggal saat ini
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        
        // Query untuk menghitung pesanan hari ini
        String countQuery = "SELECT COUNT(*) FROM orders WHERE DATE(date) = CURDATE()";
        PreparedStatement countStatement = connection.prepareStatement(countQuery);
        ResultSet countResult = countStatement.executeQuery();
        
        int orderNumber = 1; // Mulai dari 1 jika belum ada pesanan
        if (countResult.next()) {
            orderNumber = countResult.getInt(1) + 1; // Tambahkan 1 untuk nomor pesanan berikutnya
        }
        
        // Bentuk order_id dari tanggal + 3 digit nomor pesanan
        String orderId = formattedDate + String.format("%03d", orderNumber);

        // Masukkan pesanan ke database
        String insertQuery = "INSERT INTO orders (order_id, customer_id, date, qty, total, status) VALUES (?, ?, CURDATE(), ?, ?, ?)";
        PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
        insertStatement.setString(1, orderId);
        insertStatement.setInt(2, customerId);
        insertStatement.setInt(3, qty);
        insertStatement.setDouble(4, total);
        insertStatement.setString(5, status);
        
        insertStatement.executeUpdate();
    }
}

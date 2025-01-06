package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseManager {
    public static void addExpense(double amount, String category, String date, String description) {
        String sql = "INSERT INTO expenses (amount, category, date, description) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, amount);
            pstmt.setString(2, category);
            pstmt.setString(3, date);
            pstmt.setString(4, description);
            pstmt.executeUpdate();
            System.out.println("Expense added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding expense: " + e.getMessage());
        }
    }

    public static void editExpense(int id, double amount, String category, String date, String description) {
        String sql = "UPDATE expenses SET amount = ?, category = ?, date = ?, description = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, amount);
            pstmt.setString(2, category);
            pstmt.setString(3, date);
            pstmt.setString(4, description);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
            System.out.println("Expense updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating expense: " + e.getMessage());
        }
    }

    public static void deleteExpense(int id) {
        String sql = "DELETE FROM expenses WHERE id = ?";
        try (Connection conn = DatabaseUtil.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Expense deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting expense: " + e.getMessage());
        }
    }

    public static void viewExpenses() {
        String sql = "SELECT * FROM expenses";
        try (Connection conn = DatabaseUtil.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Amount: " + rs.getDouble("amount") +
                        ", Category: " + rs.getString("category") +
                        ", Date: " + rs.getDate("date") +
                        ", Description: " + rs.getString("description"));
            }
        } catch (SQLException e) {
            System.out.println("Error viewing expenses: " + e.getMessage());
        }
    }
}


package org.example;

import java.util.Scanner;

public class ExpenseApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nExpense Management System");
            System.out.println("1. Add Expense");
            System.out.println("2. Edit Expense");
            System.out.println("3. Delete Expense");
            System.out.println("4. View All Expenses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    ExpenseManager.addExpense(amount, category, date, description);
                }
                case 2 -> {
                    System.out.print("Enter expense ID to edit: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter new category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter new date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter new description: ");
                    String description = scanner.nextLine();
                    ExpenseManager.editExpense(id, amount, category, date, description);
                }
                case 3 -> {
                    System.out.print("Enter expense ID to delete: ");
                    int id = scanner.nextInt();
                    ExpenseManager.deleteExpense(id);
                }
                case 4 -> ExpenseManager.viewExpenses();
                case 5 -> {
                    System.out.println("Exiting application.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}


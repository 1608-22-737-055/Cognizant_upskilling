// JDBC Transaction Handling Example
import java.sql.*;
import java.util.Scanner;

class BankAccount {
    private final Connection conn;
    private final String url = "jdbc:mysql://localhost:3306/bank_db";
    private final String user = "root";
    private final String password = "password";

    public BankAccount() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection(url, user, password);
    }

    public void transfer(int fromAccount, int toAccount, double amount) throws SQLException {
        conn.setAutoCommit(false);
        try {
            // Check balance of source account
            if (!checkSufficientBalance(fromAccount, amount)) {
                throw new SQLException("Insufficient balance in account " + fromAccount);
            }

            // Debit from source account
            String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(debitSQL)) {
                pstmt.setDouble(1, amount);
                pstmt.setInt(2, fromAccount);
                pstmt.executeUpdate();
            }

            // Credit to destination account
            String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(creditSQL)) {
                pstmt.setDouble(1, amount);
                pstmt.setInt(2, toAccount);
                pstmt.executeUpdate();
            }

            // If everything is successful, commit the transaction
            conn.commit();
            System.out.println("Transfer successful!");
            displayBalance(fromAccount);
            displayBalance(toAccount);

        } catch (SQLException e) {
            System.out.println("Transaction failed! Rolling back...");
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    private boolean checkSufficientBalance(int accountId, double amount) throws SQLException {
        String sql = "SELECT balance FROM accounts WHERE account_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, accountId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance") >= amount;
            }
            throw new SQLException("Account " + accountId + " not found");
        }
    }

    private void displayBalance(int accountId) throws SQLException {
        String sql = "SELECT balance FROM accounts WHERE account_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, accountId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.printf("Account %d balance: $%.2f%n", 
                    accountId, rs.getDouble("balance"));
            }
        }
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}

public class Ex33 {
    public static void main(String[] args) {
        try {
            BankAccount bank = new BankAccount();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter source account ID: ");
            int fromAccount = scanner.nextInt();
            
            System.out.print("Enter destination account ID: ");
            int toAccount = scanner.nextInt();
            
            System.out.print("Enter amount to transfer: $");
            double amount = scanner.nextDouble();

            bank.transfer(fromAccount, toAccount, amount);
            bank.close();
            scanner.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

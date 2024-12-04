import java.util.ArrayList;
import java.util.List;

public class ATM {
    private Bank bank;
    private double balance = 0; // Default saldo awal
    private List<Transaction> transactions = new ArrayList<>(); // Daftar transaksi

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount)); // Catat transaksi deposit
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount)); // Catat transaksi withdraw
            return true;
        }
        return false;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
public class Transaction {
    private String type; // Jenis transaksi (e.g., "Deposit", "Withdraw")
    private double amount; // Jumlah uang
    private String date; // Tanggal transaksi

    // Konstruktor
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = java.time.LocalDateTime.now().toString(); // Tanggal sekarang
    }

    // Getter
    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    // Untuk mempermudah debugging
    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}

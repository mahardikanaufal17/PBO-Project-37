import javax.swing.*;
import java.awt.*;

public class TransactionHistoryGUI {
    public static void showTransactionHistory() {
        // Membuat frame utama
        JFrame frame = new JFrame("Riwayat Transaksi");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Mendapatkan ukuran layar
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
        frame.setLayout(null);

        // Panel utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setSize(screenSize.width, screenSize.height);
        mainPanel.setBackground(new Color(70, 130, 180));

        // Header
        JLabel headerLabel = new JLabel("RIWAYAT TRANSAKSI");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBounds(screenSize.width / 2 - 200, 20, 400, 50);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(headerLabel);

        // Nomor rekening
        JLabel accountLabel = new JLabel("REKENING : 1234560987");
        accountLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        accountLabel.setForeground(Color.WHITE);
        accountLabel.setBounds(screenSize.width / 2 - 200, 100, 400, 30);
        accountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(accountLabel);

        // Tabel transaksi
        JLabel tanggalLabel = new JLabel("Tanggal");
        tanggalLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        tanggalLabel.setForeground(Color.WHITE);
        tanggalLabel.setBounds(screenSize.width / 2 - 350, 200, 150, 30);
        tanggalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(tanggalLabel);

        JLabel jenisTransaksiLabel = new JLabel("Jenis Transaksi");
        jenisTransaksiLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        jenisTransaksiLabel.setForeground(Color.WHITE);
        jenisTransaksiLabel.setBounds(screenSize.width / 2 - 100, 200, 200, 30);
        jenisTransaksiLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(jenisTransaksiLabel);

        JLabel jumlahLabel = new JLabel("Jumlah (Rp)");
        jumlahLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        jumlahLabel.setForeground(Color.WHITE);
        jumlahLabel.setBounds(screenSize.width / 2 + 150, 200, 200, 30);
        jumlahLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(jumlahLabel);

        // Data transaksi (contoh statis)
        JLabel tanggalData = new JLabel("30/November/2024");
        tanggalData.setFont(new Font("Arial", Font.PLAIN, 18));
        tanggalData.setForeground(Color.WHITE);
        tanggalData.setBounds(screenSize.width / 2 - 350, 250, 150, 30);
        tanggalData.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(tanggalData);

        JLabel jenisTransaksiData = new JLabel("Tarik tunai");
        jenisTransaksiData.setFont(new Font("Arial", Font.PLAIN, 18));
        jenisTransaksiData.setForeground(Color.WHITE);
        jenisTransaksiData.setBounds(screenSize.width / 2 - 100, 250, 200, 30);
        jenisTransaksiData.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(jenisTransaksiData);

        JLabel jumlahData = new JLabel("200.000");
        jumlahData.setFont(new Font("Arial", Font.PLAIN, 18));
        jumlahData.setForeground(Color.WHITE);
        jumlahData.setBounds(screenSize.width / 2 + 150, 250, 200, 30);
        jumlahData.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(jumlahData);

        // Menambahkan panel ke frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}

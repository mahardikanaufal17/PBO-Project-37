import javax.swing.*;
import java.awt.*;

public class SetorTunaiGUI {

    public static void showDepositScreen(ATM atm) {
        JFrame depositFrame = new JFrame("Setor Tunai");

        // Mendapatkan ukuran layar
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        depositFrame.setSize(screenSize.width, screenSize.height);
        depositFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        depositFrame.setLayout(null);

        JPanel depositPanel = new JPanel();
        depositPanel.setLayout(null);
        depositPanel.setSize(screenSize.width, screenSize.height);
        depositPanel.setBackground(new Color(107, 163, 189)); // Warna sesuai gambar

        // Label header "SETOR TUNAI"
        JLabel headerLabel = new JLabel("SETOR TUNAI");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 36));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBounds(screenSize.width / 2 - 150, 50, 300, 50);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        depositPanel.add(headerLabel);

        // Label "MASUKKAN JUMLAH UANG YANG ANDA INGINKAN"
        JLabel amountLabel = new JLabel("MASUKKAN JUMLAH UANG YANG ANDA INGINKAN");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        amountLabel.setForeground(Color.WHITE);
        amountLabel.setBounds(screenSize.width / 2 - 300, 150, 600, 30);
        amountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        depositPanel.add(amountLabel);

        // Field input jumlah uang
        JTextField amountField = new JTextField(" ");
        amountField.setFont(new Font("Arial", Font.PLAIN, 18));
        amountField.setBounds(screenSize.width / 2 - 150, 200, 300, 50);
        amountField.setHorizontalAlignment(SwingConstants.CENTER);
        depositPanel.add(amountField);

        // Tombol "KEMBALI"
        JButton backButton = new JButton("KEMBALI");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBounds(screenSize.width / 2 - 160, 300, 140, 40);
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);
        depositPanel.add(backButton);

        // Tombol "ENTER"
        JButton enterButton = new JButton("ENTER");
        enterButton.setFont(new Font("Arial", Font.BOLD, 16));
        enterButton.setBounds(screenSize.width / 2 + 20, 300, 140, 40);
        enterButton.setBackground(Color.WHITE);
        enterButton.setForeground(Color.BLACK);
        depositPanel.add(enterButton);

        // Tambahkan event listener untuk tombol
        backButton.addActionListener(e -> depositFrame.dispose()); // Kembali ke menu utama

        enterButton.addActionListener(e -> {
            String amount = amountField.getText().trim();
            if (amount.isEmpty() || amount.equals("RP.")) {
                JOptionPane.showMessageDialog(depositFrame, "Jumlah uang tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(depositFrame, "Jumlah uang diterima: " + amount);
                depositFrame.dispose();

                // Panggil layar konfirmasi PIN
                KonfirmasiPIN.showPINConfirmationScreen(depositFrame);
            }
        });

        depositFrame.add(depositPanel);
        depositFrame.setVisible(true);
    }
}

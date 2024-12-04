import javax.swing.*;
import java.awt.*;

public class TarikTunaiGUI {
    public static JTextField amountField;

    public static void showWithdrawScreen() {
        JFrame withdrawFrame = new JFrame("SmartATM - Tarik Tunai");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        withdrawFrame.setSize(screenSize.width, screenSize.height);
        withdrawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        withdrawFrame.setLayout(null);

        JPanel withdrawPanel = new JPanel();
        withdrawPanel.setLayout(null);
        withdrawPanel.setSize(screenSize.width, screenSize.height);
        withdrawPanel.setBackground(new Color(100, 160, 180));

        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, screenSize.width, 75);
        headerPanel.setBackground(new Color(60, 120, 150));

        JLabel headerLabel = new JLabel("TARIK TUNAI");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.setLayout(new BorderLayout());
        headerPanel.add(headerLabel, BorderLayout.CENTER);
        withdrawPanel.add(headerPanel);

        JLabel instructionLabel = new JLabel("MASUKKAN JUMLAH PENARIKAN TUNAI YANG ANDA INGINKAN");
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        instructionLabel.setForeground(Color.WHITE);
        instructionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        instructionLabel.setBounds(screenSize.width / 2 - 400, 150, 800, 30);
        withdrawPanel.add(instructionLabel);

        amountField = new JTextField(" ");
        amountField.setFont(new Font("Arial", Font.PLAIN, 18));
        amountField.setHorizontalAlignment(SwingConstants.CENTER);
        amountField.setForeground(Color.GRAY);
        amountField.setBackground(Color.WHITE);
        amountField.setBounds(screenSize.width / 2 - 200, 200, 400, 50);
        withdrawPanel.add(amountField);

        JButton backButton = new JButton("KEMBALI");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);
        backButton.setBounds(screenSize.width / 2 - 250, 300, 200, 50);
        withdrawPanel.add(backButton);

        JButton enterButton = new JButton("ENTER");
        enterButton.setFont(new Font("Arial", Font.BOLD, 14));
        enterButton.setBackground(Color.WHITE);
        enterButton.setForeground(Color.BLACK);
        enterButton.setBounds(screenSize.width / 2 + 50, 300, 200, 50);
        withdrawPanel.add(enterButton);

        withdrawFrame.add(withdrawPanel);
        withdrawFrame.setVisible(true);

        backButton.addActionListener(e -> withdrawFrame.dispose());

        enterButton.addActionListener(e -> {
            String amount = amountField.getText();
            if (amount.isEmpty() || amount.equalsIgnoreCase("") || !amount.matches("\\d+")) {
                JOptionPane.showMessageDialog(withdrawFrame, "Masukkan jumlah uang yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                KonfirmasiPIN.showPINConfirmationScreen(withdrawFrame);
            }
        });
    }
}
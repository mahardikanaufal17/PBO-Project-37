import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmartATM {
        private static Bank bank; // Variabel kelas agar bisa diakses di semua metode
        
        public static void main(String[] args) {
            // Setup Bank dan ATM
            bank = new Bank();
            bank.addUser(new User(123456, 1234)); // Contoh data pengguna
            ATM atm = new ATM(bank);
    
            // Tampilkan layar login
            JFrame frame = new JFrame("SmartATM");
    
            // Mendapatkan ukuran layar
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setSize(screenSize.width, screenSize.height); // Ukuran frame sesuai layar
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null); // Manual layout

            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setSize(screenSize.width, screenSize.height); // Menyesuaikan ukuran dengan frame utama
            panel.setBackground(new Color(70, 130, 180)); // Warna biru lembut
    
            // Label utama
            JLabel welcomeLabel = new JLabel("<html>Welcome to<br><b>SmartATM</b></html>");
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Ukuran font besar
            welcomeLabel.setBounds(60, 20, 300, 60); // Posisi label
            welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            welcomeLabel.setForeground(Color.WHITE); // Warna teks putih
            panel.add(welcomeLabel);
    
            // Label dan field untuk nomor rekening
            JLabel accountLabel = new JLabel("No Rekening");
            accountLabel.setFont(new Font("Arial", Font.BOLD, 14));
            accountLabel.setBounds(40, 80, 120, 20);
            accountLabel.setForeground(Color.WHITE); // Warna teks putih
            panel.add(accountLabel);
    
            JTextField accountField = new JTextField();
            accountField.setFont(new Font("Arial", Font.PLAIN, 14));
            accountField.setBackground(Color.WHITE);
            accountField.setForeground(Color.GRAY);
            accountField.setBounds(40, 110, 320, 40);
            accountField.setMargin(new Insets(10, 10, 10, 10)); // Padding dalam
            accountField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Border putih
            panel.add(accountField);
    
            // Label dan field untuk password
            JLabel passwordLabel = new JLabel("Password");
            passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
            passwordLabel.setBounds(40, 170, 120, 20);
            passwordLabel.setForeground(Color.WHITE);
            panel.add(passwordLabel);
    
            JPasswordField passwordField = new JPasswordField();
            passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
            passwordField.setBackground(Color.WHITE);
            passwordField.setForeground(Color.GRAY);
            passwordField.setBounds(40, 200, 320, 40);
            passwordField.setMargin(new Insets(10, 10, 10, 10));
            passwordField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            panel.add(passwordField);
    
            // Tombol masuk
            JButton loginButton = new JButton("Masuk");
            loginButton.setFont(new Font("Arial", Font.BOLD, 14));
            loginButton.setBackground(new Color(30, 144, 255));
            loginButton.setForeground(Color.WHITE);
            loginButton.setBounds(150, 270, 100, 30);
            panel.add(loginButton);
    
            // Label untuk registrasi
            JLabel registerLabel = new JLabel("<html><span style='color:darkgray;'>Belum punya akun? </span>" + "<span style='color:#0000FF;'>Daftar disini.</span></html>");
            registerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            registerLabel.setBounds(110, 320, 200, 25);
            panel.add(registerLabel);
    
            frame.add(panel);
    
            // Listener untuk resize frame
            frame.addComponentListener(new java.awt.event.ComponentAdapter() {
                @Override
                public void componentResized(java.awt.event.ComponentEvent e) {
                    int frameWidth = frame.getWidth();
                    int frameHeight = frame.getHeight();
    
                    // Update ukuran dan posisi elemen berdasarkan ukuran frame
                    welcomeLabel.setBounds(frameWidth / 2 - 150, frameHeight / 10, 300, 60);
                    accountLabel.setBounds(frameWidth / 2 - 160, frameHeight / 4, 120, 20);
                    accountField.setBounds(frameWidth / 2 - 160, frameHeight / 4 + 30, 320, 40);
                    passwordLabel.setBounds(frameWidth / 2 - 160, frameHeight / 4 + 90, 120, 20);
                    passwordField.setBounds(frameWidth / 2 - 160, frameHeight / 4 + 120, 320, 40);
                    loginButton.setBounds(frameWidth / 2 - 50, frameHeight / 4 + 180, 100, 30);
                    registerLabel.setBounds(frameWidth / 2 - 100, frameHeight / 4 + 230, 200, 25);
                }
            });
    
            // ActionListener untuk tombol masuk
            loginButton.addActionListener(e -> {
                try {
                    int account = Integer.parseInt(accountField.getText());
                    int password = Integer.parseInt(new String(passwordField.getPassword()));
    
                    User user = new User(account, password);
                    if (bank.search(user)) {
                        JOptionPane.showMessageDialog(frame, "Login Berhasil!");
                        frame.dispose();
                        showMainMenu(atm);
                    } else {
                        JOptionPane.showMessageDialog(frame, "No Rekening atau Password salah!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Input tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
    
            // Event untuk klik pada "Daftar disini"
            registerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    frame.dispose(); // Menutup frame login
                    showRegistrationForm(); // Menampilkan frame pendaftaran
                }
            });
    
            frame.setVisible(true);
        }

    private static void showMainMenu(ATM atm) {
        JFrame mainMenuFrame = new JFrame("SmartATM - Menu Utama");

        // Mendapatkan ukuran layar
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainMenuFrame.setSize(screenSize.width, screenSize.height);
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setLayout(null);

        // Panel utama
        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(null);
        mainMenuPanel.setSize(screenSize.width, screenSize.height);
        mainMenuPanel.setBackground(new Color(70, 130, 180)); // Warna biru

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, screenSize.width, 75); // Lebar penuh, tinggi 75px
        headerPanel.setBackground(new Color(60, 120, 180)); // Warna biru lebih gelap

        // Label untuk Header
        JLabel headerLabel = new JLabel("SmartATM");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 36));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(headerLabel);

        mainMenuPanel.add(headerPanel);

        // Tombol Menu
        JButton withdrawButton = new JButton("TARIK TUNAI");
        JButton depositButton = new JButton("SETOR TUNAI");
        JButton checkBalanceButton = new JButton("INFORMASI SALDO");
        JButton transactionHistoryButton = new JButton("RIWAYAT TRANSAKSI");
        JButton transferButton = new JButton("TRANSFER");
        JButton changePinButton = new JButton("UBAH PIN");

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Color buttonColor = Color.WHITE;

        JButton[] buttons = {withdrawButton, depositButton, checkBalanceButton,
                transactionHistoryButton, transferButton, changePinButton};

        int buttonStartY = 150;
        int buttonSpacingY = 80;

        for (int i = 0; i < buttons.length; i++) {
            JButton button = buttons[i];
            button.setFont(buttonFont);
            button.setForeground(Color.BLACK);
            button.setBackground(buttonColor);
            button.setFocusPainted(false);
            button.setBounds(screenSize.width / 2 - 120, buttonStartY + i * buttonSpacingY, 240, 50);
            mainMenuPanel.add(button);
        }

        checkBalanceButton.addActionListener(e -> {
            new BalanceInformation(atm);
        });

        withdrawButton.addActionListener(e -> {
            TarikTunaiGUI.showWithdrawScreen();
        });        

        depositButton.addActionListener(e -> {
            SetorTunaiGUI.showDepositScreen(atm);
        });      
        
        transactionHistoryButton.addActionListener(e -> {
            TransactionHistoryGUI.showTransactionHistory();
        });        

        transferButton.addActionListener(e -> {
            TransferGUI.showTransferScreen(); // Memanggil GUI transfer
        });        

        //tambahan
        changePinButton.addActionListener(e -> new UbahPinPage());

        mainMenuFrame.add(mainMenuPanel);
        mainMenuFrame.setVisible(true);
    }

    private static void showRegistrationForm() {
        JFrame registerFrame = new JFrame("Form Pendaftaran");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        registerFrame.setSize(screenSize.width, screenSize.height);
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.setLayout(null);

        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(null);
        registerPanel.setSize(screenSize.width, screenSize.height);
        registerPanel.setBackground(new Color(70, 130, 180));

        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, screenSize.width, 75);
        headerPanel.setBackground(new Color(60, 120, 180));

        JLabel headerLabel = new JLabel("DAFTAR");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 36));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(headerLabel);

        registerPanel.add(headerPanel);

        JLabel nameLabel = new JLabel("Nama Lengkap");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setBounds(screenSize.width / 2 - 160, 140, 120, 20);
        nameLabel.setForeground(Color.WHITE);
        registerPanel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(screenSize.width / 2 - 160, 170, 320, 40);
        registerPanel.add(nameField);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        usernameLabel.setBounds(screenSize.width / 2 - 160, 230, 120, 20);
        usernameLabel.setForeground(Color.WHITE);
        registerPanel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(screenSize.width / 2 - 160, 260, 320, 40);
        registerPanel.add(usernameField);

        JLabel rekeningLabel = new JLabel("No Rekening");
        rekeningLabel.setFont(new Font("Arial", Font.BOLD, 14));
        rekeningLabel.setBounds(screenSize.width / 2 - 160, 320, 120, 20);
        rekeningLabel.setForeground(Color.WHITE);
        registerPanel.add(rekeningLabel);

        JTextField rekeningField = new JTextField();
        rekeningField.setBounds(screenSize.width / 2 - 160, 350, 320, 40);
        registerPanel.add(rekeningField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setBounds(screenSize.width / 2 - 160, 410, 120, 20);
        passwordLabel.setForeground(Color.WHITE);
        registerPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(screenSize.width / 2 - 160, 440, 320, 40);
        registerPanel.add(passwordField);

        JButton registerButton = new JButton("Daftar");
        registerButton.setBounds(screenSize.width / 2 - 60, 520, 120, 40);
        registerButton.setBackground(new Color(30, 144, 255));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Arial", Font.BOLD, 16));
        registerPanel.add(registerButton);

        registerButton.addActionListener(e -> {
            String namaLengkap = nameField.getText();
            String username = usernameField.getText();
            String noRekening = rekeningField.getText();
            String password = new String(passwordField.getPassword());
        
            if (namaLengkap.isEmpty() || username.isEmpty() || noRekening.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(registerFrame, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                User newUser = new User(Integer.parseInt(noRekening), Integer.parseInt(password), namaLengkap, username, 0.0);
                if (bank.addUser(newUser)) {
                    JOptionPane.showMessageDialog(registerFrame, "Pendaftaran berhasil!");
                    registerFrame.dispose();
                    main(new String[]{});
                } else {
                    JOptionPane.showMessageDialog(registerFrame, "Pendaftaran gagal! Periksa kembali data Anda.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });        

        registerFrame.add(registerPanel);
        registerFrame.setVisible(true);
    }
    
}

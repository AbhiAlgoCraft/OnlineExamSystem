import javax.swing.*;
import java.awt.event.*;

public class LoginUI extends JFrame {

    JTextField emailField;
    JPasswordField passwordField;
    JButton loginButton;

    public LoginUI() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 30, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 30, 150, 25);
        add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 70, 80, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 70, 150, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 110, 100, 30);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        UserDAO dao = new UserDAO();
        User user = dao.loginUser(email, password);

        if (user != null) {

            if (user.getRole().equals("admin")) {
                JOptionPane.showMessageDialog(null, "Welcome Admin!");
                new AdminUI();

            } else {
                JOptionPane.showMessageDialog(null, "Welcome Student!");
                new StudentUI(user.getId());  // ✅ correct way
            }

            dispose(); // close login window

        } else {
            JOptionPane.showMessageDialog(null, "Invalid Credentials!");
        }
    }
});

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginUI();
    }
}
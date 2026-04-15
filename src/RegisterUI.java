import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUI extends JFrame {

    JTextField nameField, emailField;
    JPasswordField passwordField;
    JButton registerButton;

    public RegisterUI() {
        setTitle("User Registration");
        setSize(300, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 80, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 20, 150, 25);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 60, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 60, 150, 25);
        add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 100, 80, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 100, 150, 25);
        add(passwordField);

        registerButton = new JButton("Register");
        registerButton.setBounds(100, 140, 100, 30);
        add(registerButton);

       
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                User user = new User(name, email, password, "student");
                UserDAO dao = new UserDAO();

               if (dao.registerUser(user)) {
    JOptionPane.showMessageDialog(null, "Registration Successful!");

    nameField.setText("");
    emailField.setText("");
    passwordField.setText("");

} else {
    JOptionPane.showMessageDialog(null, "Registration Failed!");
}
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterUI();
    }
}
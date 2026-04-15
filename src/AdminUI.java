import javax.swing.*;

public class AdminUI extends JFrame {

    public AdminUI() {
        setTitle("Admin Dashboard");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Welcome Admin");
        label.setBounds(130, 50, 200, 30);
        add(label);

        JButton addQBtn = new JButton("Add Question");
        addQBtn.setBounds(120, 100, 150, 30);
        add(addQBtn);

        addQBtn.addActionListener(e -> new AddQuestionUI());

        setVisible(true);
    }
}
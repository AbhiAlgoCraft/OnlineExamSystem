import javax.swing.*;

public class StudentUI extends JFrame {
    int userId;
    public StudentUI(int userId) {
        this.userId = userId;
        setTitle("Student Dashboard");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Welcome Student");
        label.setBounds(130, 50, 200, 30);
        add(label);

        JButton startExamBtn = new JButton("Start Exam");
        startExamBtn.setBounds(120, 100, 150, 30);
        add(startExamBtn);
        startExamBtn.addActionListener(e -> new ExamUI(userId));
        setVisible(true);
    }
}
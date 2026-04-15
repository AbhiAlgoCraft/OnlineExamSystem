import javax.swing.*;

public class StudentUI extends JFrame {

    public StudentUI() {
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
        startExamBtn.addActionListener(e -> new ExamUI());

        setVisible(true);
    }
}
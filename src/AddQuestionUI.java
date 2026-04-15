import javax.swing.*;
import java.awt.event.*;

public class AddQuestionUI extends JFrame {

    JTextField qField, o1, o2, o3, o4, correct;
    JButton addBtn;

    public AddQuestionUI() {
        setTitle("Add Question");
        setSize(400, 400);
        setLayout(null);

        JLabel qLabel = new JLabel("Question:");
        qLabel.setBounds(20, 20, 100, 25);
        add(qLabel);

        qField = new JTextField();
        qField.setBounds(120, 20, 200, 25);
        add(qField);

        o1 = createField("Option 1:", 60);
        o2 = createField("Option 2:", 100);
        o3 = createField("Option 3:", 140);
        o4 = createField("Option 4:", 180);
        correct = createField("Correct:", 220);

        addBtn = new JButton("Add Question");
        addBtn.setBounds(120, 270, 150, 30);
        add(addBtn);

        addBtn.addActionListener(e -> {
            Question q = new Question(
                qField.getText(),
                o1.getText(),
                o2.getText(),
                o3.getText(),
                o4.getText(),
                correct.getText()
            );

            UserDAO dao = new UserDAO();

            if (dao.addQuestion(q)) {
                JOptionPane.showMessageDialog(null, "Question Added!");

                qField.setText("");
                o1.setText("");
                o2.setText("");
                o3.setText("");
                o4.setText("");
                correct.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "Failed!");
            }
        });

        setVisible(true);
    }

    private JTextField createField(String label, int y) {
        JLabel l = new JLabel(label);
        l.setBounds(20, y, 100, 25);
        add(l);

        JTextField tf = new JTextField();
        tf.setBounds(120, y, 200, 25);
        add(tf);

        return tf;
    }
}
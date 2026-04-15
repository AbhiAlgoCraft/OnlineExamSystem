import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ExamUI extends JFrame {

    JLabel questionLabel;
    JRadioButton opt1, opt2, opt3, opt4;
    JButton nextBtn;

    ButtonGroup group;

    ArrayList<Question> questions;
    ArrayList<String> userAnswers = new ArrayList<>();
    int current = 0;

    public ExamUI() {
        setTitle("Exam");
        setSize(400, 300);
        setLayout(null);

        questionLabel = new JLabel();
        questionLabel.setBounds(20, 20, 350, 30);
        add(questionLabel);

        opt1 = new JRadioButton();
        opt1.setBounds(20, 60, 300, 25);
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(20, 90, 300, 25);
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(20, 120, 300, 25);
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(20, 150, 300, 25);
        add(opt4);

        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);

        nextBtn = new JButton("Next");
        nextBtn.setBounds(150, 200, 100, 30);
        add(nextBtn);

        // Load questions
        UserDAO dao = new UserDAO();
        questions = dao.getQuestions();

        loadQuestion();

        nextBtn.addActionListener(e -> {
                String selected = "";

            if (opt1.isSelected()) selected = opt1.getText();
            else if (opt2.isSelected()) selected = opt2.getText();
            else if (opt3.isSelected()) selected = opt3.getText();
            else if (opt4.isSelected()) selected = opt4.getText();

            userAnswers.add(selected);

            current++;
            if (current < questions.size()) {
                loadQuestion();
            } else {
               int score = 0;

            for (int i = 0; i < questions.size(); i++) {
                if (questions.get(i).getCorrect().equals(userAnswers.get(i))) {
                    score++;
                }
            }

            JOptionPane.showMessageDialog(null, "Your Score: " + score + "/" + questions.size());
            }
        });

        setVisible(true);
    }

    void loadQuestion() {
        Question q = questions.get(current);

        questionLabel.setText(q.getQuestion());
        opt1.setText(q.getOpt1());
        opt2.setText(q.getOpt2());
        opt3.setText(q.getOpt3());
        opt4.setText(q.getOpt4());

        group.clearSelection();
    }

    public static void main(String[] args) {
        new ExamUI();
    }
}
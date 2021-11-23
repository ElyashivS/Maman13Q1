import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.*;

public class Q1Controller {

    private int numOfQues = 0;
    private int numOfAnswer = 0;
    private int numOfCorrectAnswer = 0;
    private Questions q = new Questions();

    @FXML
    private Label lbl;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    public void initialize() {
        nextQuestion();
    }

    private void nextQuestion() {
        lbl.setText(q.getQuestion().get(numOfQues));
        btn1.setText(q.getAnswers().get(numOfAnswer));
        btn2.setText(q.getAnswers().get(numOfAnswer + 1));
        btn3.setText(q.getAnswers().get(numOfAnswer + 2));
        btn4.setText(q.getAnswers().get(numOfAnswer + 3));

        btn1.setOnAction(this::handleButton);
        btn2.setOnAction(this::handleButton);
        btn3.setOnAction(this::handleButton);
        btn4.setOnAction(this::handleButton);

        numOfQues++;
        numOfAnswer+=4;
    }

    private void handleButton(ActionEvent event) {

        if (((Button) event.getSource()).getText().equals(q.getCorrectAnswers().get(numOfCorrectAnswer))) {
            JOptionPane.showMessageDialog(null, "Correct! :D");
            q.setNumOfCorrectQues(q.getNumOfCorrectQues() + 1);
        }
        else
            JOptionPane.showMessageDialog(null, "Wrong answer :(");
        numOfCorrectAnswer++;

        if (q.getQuestion().size() > numOfQues)
            nextQuestion();
        else {
            JOptionPane.showMessageDialog(null, infoUpdate());
            int chosen = JOptionPane.showConfirmDialog(null, "Another game?", "", JOptionPane.YES_NO_OPTION);
            if (chosen == 0) {
                reset();
            }
            else
                System.exit(0);
        }
    }

    private StringBuilder infoUpdate() {
        StringBuilder s = new StringBuilder("Game result:\n");
        s.append("\nNumber of questions: ").append(numOfQues);
        s.append("\nNumber of correct answer: ").append(q.getNumOfCorrectQues());
        s.append("\nScore: " ).append((double) q.getNumOfCorrectQues()/numOfQues * 100);
        return s;
    }

    private void reset() {
        numOfQues = 0;
        numOfAnswer = 0;
        numOfCorrectAnswer = 0;
        q = new Questions();
        nextQuestion();
    }
}

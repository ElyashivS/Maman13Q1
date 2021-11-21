import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Q1Controller {

    Questions q = new Questions();

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
        btn1.setText(q.getAnswers().get(1));
        btn2.setText(q.getAnswers().get(2));
        btn3.setText(q.getAnswers().get(3));
        btn4.setText(q.getAnswers().get(4));
    }
}

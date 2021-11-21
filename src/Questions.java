import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Questions {

    private ArrayList<String> answers = new ArrayList<>();
    private Map<String, ArrayList<String>> dictionary = new HashMap<>();
    private ArrayList<String> correctAnswers = new ArrayList<>();
    private int lineNumber = 0;

    public Questions() {
        Scanner input;
        try {
            input = new Scanner(new File("Exam.txt"));
            while (input.hasNextLine()) {
                String s = input.nextLine();
                System.out.println(s); // REMOVE THIS
                answers.add(s);
                lineNumber++;

                if (lineNumber % 5 == 2) {
                    correctAnswers.add(s);
                }
            }

            Collections.shuffle(answers); // Shuffle the answers
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }
}
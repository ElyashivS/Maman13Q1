import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Questions {

    private Map<String, ArrayList<String>> dictionary = new HashMap<>();
    private ArrayList<String> answers = new ArrayList<>();
    private ArrayList<String> correctAnswers = new ArrayList<>();
    private String question;
    private int lineNumber = 0;

    public Questions() {
        Scanner input;
        try {
            input = new Scanner(new File("Exam.txt"));
            while (input.hasNextLine()) {
                lineNumber++;
                String s = input.nextLine();

                if (lineNumber % 5 == 1) // Enter question to string
                    question = s;
                if (lineNumber % 5 != 1) // Enter ALL answers to ArrayList
                    answers.add(s);
                if (lineNumber % 5 == 2) // Enter CORRECT answer to ArrayList
                    correctAnswers.add(s);

                dictionary.put(question, answers);
            }

            for (int i = 0; i < answers.size(); i+=4) { // Shuffle all answer separately
                Collections.shuffle(answers.subList(i, i + 4));
            }

            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }
}

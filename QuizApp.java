import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String text;
    List<String> options;
    int correctAnswer;

    public Question(String text, List<String> options, int correctAnswer) {
        this.text = text;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

class Quiz {
    List<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public void runQuiz() {
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);

            System.out.println("Question " + (i + 1) + ": " + question.text);
            for (int j = 0; j < question.options.size(); j++) {
                System.out.println((j + 1) + ". " + question.options.get(j));
            }

            int userAnswer = getUserInput(question.options.size());
            if (userAnswer == question.correctAnswer) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was " + question.correctAnswer + ".\n");
            }
        }

        System.out.println("Your final score is: " + score + "/" + questions.size());
    }

    private int getUserInput(int numOptions) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter your choice (1-" + numOptions + "): ");
                int userInput = Integer.parseInt(scanner.nextLine());

                if (userInput >= 1 && userInput <= numOptions) {
                    return userInput;
                } else {
                    System.out.println("Invalid input. Please enter a number within the specified range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Question question1 = new Question("Which element has the chemical symbol 'O'?", List.of("Oxygen", "Gold", "Iron", "Carbon"), 1);
        Question question2= new Question("Who painted the Mona Lisa?", List.of("Vincent van Gogh", "Leonardo da Vinci", "Pablo Picasso", "Claude Monet"), 2);
        Question question3 = new Question("What is the currency of Japan?", List.of("Yuan", "Euro", "Yen", "Dollar"), 3);
        Question question4 = new Question("Which planet is known as the 'Morning Star' or 'Evening Star'?", List.of("Mars", "Venus", "Jupiter", "Mercury"), 2);
        Question question5 = new Question("In which year did the Titanic sink?", List.of("1912", "1905", "1920", "1898"), 1);
        Question question6 = new Question("What is the largest desert in the world?", List.of("Gobi Desert", "Sahara Desert", "Arabian Desert", "Antarctica"), 2);
        Question question7 = new Question("Who wrote 'Romeo and Juliet'?", List.of("Charles Dickens", "William Shakespeare", "Jane Austen", "F. Scott Fitzgerald"), 2);
        


        // Create quiz and add questions
        Quiz quiz = new Quiz();
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);
        quiz.addQuestion(question4);
        quiz.addQuestion(question5);
        quiz.addQuestion(question6);
        quiz.addQuestion(question7);


        // Run the quiz
        quiz.runQuiz();
    }
}

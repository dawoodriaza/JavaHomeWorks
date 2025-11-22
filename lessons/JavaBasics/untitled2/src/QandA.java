import java.util.Scanner;

public class QandA {

    public static int total_question_asked = 0;

    public static void Questions(Scanner input, String prompt) {


        String question = prompt.toLowerCase();

        if (question.contains("who")) {
            total_question_asked += 1;
            System.out.println("We're the Java class.");
            System.out.println("Ask Again. Type exit or quit to leave.");

        } else if (question.contains("what")) {
            total_question_asked += 1;
            System.out.println("We're learning Java.");
            System.out.println("Ask Again. Type exit or quit to leave.");

        } else if (question.contains("why")) {
            total_question_asked += 1;
            System.out.println("It is the best language to learn in the world.");
            System.out.println("Ask Again. Type exit or quit to leave.");

        } else if (question.contains("when")) {
            total_question_asked += 1;
            System.out.println("At this very moment.");

        } else if (question.contains("where")) {
            total_question_asked += 1;
            System.out.println("BIBF.");

        } else if (question.contains("exit") || question.contains("quit")) {
            System.out.print("Are you sure you want to quit? (y/n): ");
            String confirm = input.nextLine().trim();

            if (confirm.equalsIgnoreCase("y")) {
                System.out.println("bye bye");
                System.out.println("Total questions asked: " + total_question_asked);
                System.exit(0);
            } else if (confirm.equalsIgnoreCase("n")) {
                System.out.println("Sad to see you go :'( ");
            } else {
                System.out.println("Invalid input, please enter 'y' or 'n'.");
            }

        } else {
            total_question_asked += 1;
            System.out.println("I don't know how to answer that question.");
            System.out.println("Ask Again. Type exit or quit to leave.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String prompt;

        String grinningFace = "\uD83D\uDE04";
        System.out.println("Ask Anything"+ grinningFace+ " Type exit or quit to leave.");
        while (true) {
            prompt = input.nextLine().trim();
            if (prompt.isEmpty()) {
                System.out.println("Please enter a valid question.");
                continue;
            }
            Questions(input, prompt);
        }
    }
}

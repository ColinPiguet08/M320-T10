import java.util.Random;
import java.util.Scanner;

public class GuessNumberLogic {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    private void printWelcomeText() {
        System.out.println("Welcome to guess the number.");
    }

    public void handleUserInput() {
        int answer = random.nextInt(11);
        int guess;
        int tries = 10;

        printWelcomeText();

        while (tries >= 0) {
            System.out.println("You have " + tries + " more tries.");
            System.out.println("Guess a number between 0 and 10: ");

            guess = scanner.nextInt();
            scanner.nextLine();

            if (checkGuess(guess, answer)) {
                break;
            }

            tries--;

            if (tries == 0) {
                System.out.println("You are out of tries. The correct answer was " + answer);
            }
        }
        scanner.close();
    }

    private boolean checkGuess(int guess, int answer) {
        if (guess == answer) {
            System.out.println("You have won.");
            return true;
        } else {
            System.out.println("Your guess was wrong.");
            return false;
        }
    }
}
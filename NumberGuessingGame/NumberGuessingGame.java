import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 5;
        int score = 0;
        String playAgain;

        do {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int numberOfAttempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Guess a number between 1 and 100.");

            while (numberOfAttempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                numberOfAttempts++;

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number.");
                    score++;
                    hasGuessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("You've reached the maximum attempts. The number was " + numberToGuess);
            }

            System.out.println("Your score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thank you for playing! Final score: " + score);
        scanner.close();
    }
}

/* CODSOFT TASK 1 NUMBER GAME  */

import java.util.Scanner;
import java.util.Random;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 7;
        int rounds = 0;
        int totalAttempts = 0;

        boolean playAgain = true;
        while (playAgain) {
            rounds++;
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            System.out.println("Round " + rounds + ": Guess the number between " + lowerBound + " and " + upperBound);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                totalAttempts++;

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + attempts
                            + " attempts.");
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was "
                            + secretNumber + ".");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next();
            playAgain = playChoice.equalsIgnoreCase("yes");
        }

        System.out.println(
                "Thank you for playing! Your total rounds played: " + rounds + ", Total attempts: " + totalAttempts);
        scanner.close();
    }
}

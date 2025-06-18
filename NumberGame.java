import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random generator = new Random();

        final int maxChances = 5;
        final int min = 1;
        final int max = 100;

        int roundCount = 0;
        int userScore = 0;

        System.out.println(" Welcome to the Number Guess Challenge!");

        boolean continueGame;

        do {
            roundCount++;
            int targetNumber = generator.nextInt(max - min + 1) + min;
            int attemptsUsed = 0;
            boolean isGuessed = false;

            System.out.println("\n Round " + roundCount + " - Try to guess the number between " + min + " and " + max);

            while (attemptsUsed < maxChances) {
                System.out.print("Your guess: ");
                int guess = input.nextInt();
                attemptsUsed++;

                if (guess == targetNumber) {
                    System.out.println(" Awesome! You nailed it in " + attemptsUsed + " attempt(s).");
                    isGuessed = true;
                    userScore += (maxChances - attemptsUsed + 1); 
                    break;
                } else if (guess < targetNumber) {
                    System.out.println(" Too low. Try again.");
                } else {
                    System.out.println(" Too high. Try again.");
                }
            }

            if (!isGuessed) {
                System.out.println(" Oops! You've run out of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("\n🔁 Would you like to play another round? (yes/no): ");
            String reply = input.next();
            continueGame = reply.equalsIgnoreCase("yes");

        } while (continueGame);

        System.out.println("\n Game Over!");
        System.out.println("Rounds Played: " + roundCount);
        System.out.println("Final Score: " + userScore);
        
        input.close();
    }
}

    


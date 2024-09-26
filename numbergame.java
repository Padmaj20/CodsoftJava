import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 5;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;
        int totalRounds = 0;
        int totalScore = 0;
        
        do {
            totalRounds++;
            int targetNumber = random.nextInt(100) + 1;  // Random number between 1 and 100
            int attempts = 0;
            boolean isGuessed = false;
            
            System.out.println("Round " + totalRounds + ": Guess the number between 1 and 100. You have " + MAX_ATTEMPTS + " attempts.");
            
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the number correctly in " + attempts + " attempts.");
                    isGuessed = true;
                    break;
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }
            }
            
            if (!isGuessed) {
                System.out.println("Sorry! You've used all " + MAX_ATTEMPTS + " attempts. The correct number was: " + targetNumber);
            }
            
            totalScore += MAX_ATTEMPTS - attempts + 1;
            
            System.out.println("Your score for this round: " + (MAX_ATTEMPTS - attempts + 1));
            
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);
        
        System.out.println("Game Over! You played " + totalRounds + " rounds.");
        System.out.println("Your total score is: " + totalScore);
        
        scanner.close();
    }
}

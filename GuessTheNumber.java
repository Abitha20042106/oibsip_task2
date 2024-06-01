import javax.swing.*;
import java.util.Random;

public class GuessTheNumber {

    public static void main(String[] args) {
        Random random = new Random();
        int maxRounds = 3; // Number of rounds
        int maxAttempts = 10; // Maximum attempts per round
        int totalScore = 0;

        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number game!");

        for (int round = 1; round <= maxRounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessed = false;

            JOptionPane.showMessageDialog(null, "Round " + round + " of " + maxRounds + "\nI have picked a number between 1 and 100. Try to guess it!");

            while (attempts < maxAttempts && !guessed) {
                String guessStr = JOptionPane.showInputDialog("Enter your guess:");
                if (guessStr == null) {
                    JOptionPane.showMessageDialog(null, "Game cancelled. Exiting.");
                    System.exit(0);
                }

                int userGuess;
                try {
                    userGuess = Integer.parseInt(guessStr);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                    continue;
                }

                attempts++;

                if (userGuess == numberToGuess) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1); // Higher score for fewer attempts
                    guessed = true;
                } else if (userGuess < numberToGuess) {
                    JOptionPane.showMessageDialog(null, "Your guess is too low.");
                } else {
                    JOptionPane.showMessageDialog(null, "Your guess is too high.");
                }
            }

            if (!guessed) {
                JOptionPane.showMessageDialog(null, "Sorry, you did not guess the number. The correct number was " + numberToGuess);
            }

            JOptionPane.showMessageDialog(null, "Your score after round " + round + " is: " + totalScore);
        }

        JOptionPane.showMessageDialog(null, "Game Over! Your total score is: " + totalScore);
    }
}

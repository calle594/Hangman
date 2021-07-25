package Application;

import java.util.Scanner;

public class Hangman {

    boolean running = true;
    private RandomWord word = new RandomWord();
    private Scanner sc = new Scanner(System.in);
    private char tries;
    private int triesRemaining = 5;

    public void run() {

        do {
            displayWord();
            getUserInput();
            checkUserInput();
        } while (running);
    }

    private void checkUserInput() {

        boolean isCorrect = word.addGuess(tries);

        if (isCorrect) {
            if (word.isComplete()) {
                System.out.println("You have won!");
                System.out.println("The word is: " + word);
                running = false;
            }
        } else {
            triesRemaining--;

            if (triesRemaining == 0) {
                System.out.println("You have lost!");
                running = false;
            }
        }
    }

    private void getUserInput() {
        // Ask user to enter character
        // Get char as string
        // Pass character to randomWord as argument
        System.out.print("Enter input ");
        String guess = sc.nextLine();
        System.out.println("\n");
        tries = guess.charAt(0);

    };

    private void displayWord() {
        System.out.println("Tries remaining " + triesRemaining);
        System.out.println(word);
    };

    public void close() {
        sc.close();
    };
}

package Application;

import java.util.Random;

public class RandomWord {
    private String[] words = { "gandalf", "glorfindel", "sauron" };

    private String chosenWord;
    private Random random = new Random();
    private char[] characters;

    public RandomWord() {
        // select random word from word array using random method with upper bound being
        // the length of the array.
        chosenWord = words[random.nextInt(words.length)];
        // new char array of chosen word
        characters = new char[chosenWord.length()];
    }

    public boolean isComplete() {
        for (char i : characters) {
            if (i == '\u0000') {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder s1 = new StringBuilder();

        for (char i : characters) {
            if (i == '\u0000') {
                s1.append("_");
            }
            else {
                s1.append(i);
            }
            s1.append(" ");
        }
        return s1.toString();
    }

    public boolean addGuess(char c) {
        boolean correct = false;
        for (int i = 0; i < chosenWord.length(); i++) {
            if (c == chosenWord.charAt(i)) {
                characters[i] = c;
                correct = true;
            }
        }
        return correct;
    }
}

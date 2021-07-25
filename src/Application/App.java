package Application;

public class App {
    public static void main(String[] args) {
        final Hangman hangman = new Hangman();
        try {
            hangman.run();
            hangman.close();
        } catch(Exception e) {
            System.out.println("Something went wrong");
        }
    }
}

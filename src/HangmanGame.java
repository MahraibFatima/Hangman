import java.util.Scanner;
import java.util.HashSet;

public class HangmanGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"algorithm","binary","compiler",
    "debugging","developer","framework","function",
    "inheritance","iteration","java","destructor",
    "python","variable","recursion","exception",
    "array","pointer","syntax", "constructor",
    "software","hardware","frontend","backend",
    "database","compiler","interface","object",
    "class","encapsulation","polymorphism","overloading",
    "server","client","protocol","loop",
    "condition","stack","queue","thread",   
};

        String wordToGuess = words[(int) (Math.random() * words.length)];
        char[] guessedWord = new char[wordToGuess.length()];
        HashSet<Character> guessedLetters = new HashSet<>();

        // Fill guessedWord with underscores
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        int lives = 6; // wrong attempts
        boolean wordGuessed = false;

        System.out.println("Welcome to Hangman!");
        System.out.println("Guess the word:");

        while (lives > 0 && !wordGuessed) {
            System.out.println("\nLives left: " + lives);
            System.out.print("Word: ");
            System.out.println(guessedWord);
            System.out.print("Guess a letter: ");
            char guessedChar = scanner.nextLine().toLowerCase().charAt(0);

            if (guessedLetters.contains(guessedChar)) {
                System.out.println("You already guessed that letter!");
                continue;
            }

            guessedLetters.add(guessedChar);

            if (wordToGuess.indexOf(guessedChar) >= 0) {
                System.out.println("Good guess!");
                // Reveal guessed letters in the word
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guessedChar) {
                        guessedWord[i] = guessedChar;
                    }
                }
            } else {
                System.out.println("Wrong guess!");
                lives--;
            }

            // Check if the word has been completely guessed
            wordGuessed = String.valueOf(guessedWord).equals(wordToGuess);
        }

        if (wordGuessed) {
            System.out.println("\nCongratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("\nYou lost! The word was: " + wordToGuess);
        }

        scanner.close();
    }
}

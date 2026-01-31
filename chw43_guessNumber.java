
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

class Game {
    private int number;
    private int userInput;
    private int noOfGuesses = 0;
    private Scanner scanner;

    // 1. Constructor to generate random number
    public Game(Scanner scanner) {
        this.scanner = scanner;
        Random rand = new Random();
        number = rand.nextInt(100) + 1; // number between 1 and 100
    }

    // 2. Take user input
    public void takeUserInput() {
        while (true) {
            System.out.print("Enter your guess (1-100): ");
            try {
                userInput = scanner.nextInt();
                if (userInput < 1 || userInput > 100) {
                    System.out.println("⚠️  Please enter a number between 1 and 100.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter a valid integer.");
                scanner.next(); // Clear the invalid input from scanner
            }
        }
    }

    // 3. Check if number is correct
    public boolean isCorrectNumber() {
        noOfGuesses++;

        if (userInput == number) {
            System.out.println("🎉 Correct! You guessed it in " + noOfGuesses + " tries! 🎯");
            return true;
        } else if (userInput < number) {
            System.out.println("📉 Too low! Try a higher number.");
        } else {
            System.out.println("📈 Too high! Try a lower number.");
        }
        return false;
    }

    // 4. Getter
    public int getNoOfGuesses() {
        return noOfGuesses;
    }

    // 4. Setter
    public void setNoOfGuesses(int n) {
        this.noOfGuesses = n;
    }
}

public class chw43_guessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("   🎮 Welcome to Guess The Number! 🎮   ");
        System.out.println("==========================================");
        System.out.println("I have picked a number between 1 and 100.");
        System.out.println("Can you guess it?");
        System.out.println("------------------------------------------");

        Game game = new Game(scanner);
        boolean guessed = false;

        while (!guessed) {
            game.takeUserInput();
            guessed = game.isCorrectNumber();
        }

        System.out.println("==========================================");
        System.out.println("Thanks for playing! Come back soon! 👋");
        System.out.println("==========================================");

        scanner.close();
    }
}

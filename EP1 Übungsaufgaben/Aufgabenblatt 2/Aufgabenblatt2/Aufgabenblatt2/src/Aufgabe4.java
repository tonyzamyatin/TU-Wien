/*
    Aufgabe 4) "Guessing Game" und Verwendung von Methoden
*/

import java.util.Scanner;

public class Aufgabe4 {

    //TODO: Implementieren Sie hier Ihre Methoden
    public static int getRandom200() {
        return (int) (Math.random() * 200);
    }

    public static int getGuess() {
        Scanner myScanner = new Scanner(System.in);
        while (true) {
            if (myScanner.hasNextInt()) {
                int input = myScanner.nextInt();
                if (input >= 0 && input <= 200) {
                    return input;
                } else {
                    System.out.println("The number must not be smaller than 0 and greater than 200!");
                }
            } else {
                String input = myScanner.next();
                if (input.equals("q")) {
                    System.exit(0);
                } else {
                    System.out.println(input + " is not a number!");
                }
            }
        }
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {

        //TODO: Implementieren Sie hier Ihr "GuessingGame"
        String newGameMessage = "Welcome to a new round of the GuessingGame! You have 8 trails to guess my number between 0 and 200!";
        while (true) {
            String message = "Which number from the range 1 to 100 was chosen?";
            int number = getRandom200();
            int guess = -1;
            int trial = 1;
            int left = 8;
            System.out.println(newGameMessage);
            while (guess != number) {
                print(message);
                if (left == 0) {
                    print("You lost... Let's play again!\n");
                    break;
                }
                print("Try#: " + trial);
                guess = getGuess();
                if (guess < number) {
                    message = guess + " is too small.";
                } else if (guess > number) {
                    message = guess + " is too large.";
                } else {
                    message = guess + " Congratulation!";
                }
                trial++;
                left--;
            }
        }
    }
}
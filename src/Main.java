
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // choose a word
        String word = "teknik";

        boolean wordCompleted;
        String guess;

        //separate the string into a list of the letters
        String[] letters = word.split("");
        printList(letters);

        // and creat a list for the guessed word
        String[] guessedWord = new String[letters.length];
        int count = 0; // this is a counter
        while (count < guessedWord.length) {
            guessedWord[count] = "_";
            count++;
        }
        printList(guessedWord);

        // how many lives (tries) should our user have
        int lives = 3;

        //user input
        Scanner myScan = new Scanner(System.in);


        do {
            do {
                System.out.print("Guess a letter: ");
                guess = myScan.nextLine();
            } while (!guess.matches("[a-öA-Ö]+") || guess.length() != 1);


            wordCompleted = true;


            //check if guess is in the word
            boolean isInWord = false;
            for (int i = 0; i < letters.length; i++) {
                // if guess is correct print the letter
                if (guess.equalsIgnoreCase(letters[i])) {
                    guessedWord[i] = guess.toUpperCase();
                    isInWord = true;
                }

                if (guessedWord[i].equals("_")) {
                    wordCompleted = false;
                }
            }
            if (!isInWord) { // same as isInWord == false
                // if isInWord == true --> !isInWord == false
                // if isInWord == false --> !isInWord == true
                lives--;

            }
            printList(guessedWord);
            System.out.println(" you now have " + lives + " lives left");

        } while ((lives > 0) && (!wordCompleted));
    }


    public static void printList(String[] myList) {
        // Check the contents of a list
        for (String s : myList) {
            System.out.print(s);

        }
        System.out.println();//prints a linebreak
    }
}








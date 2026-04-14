import java.util.Scanner;

public class NumberReverser {
    public static int reverseNumber(int originalNumber, int reversedSoFar) {
        if (originalNumber == 0) { 
            return reversedSoFar;
        }
        int lastDigit = originalNumber % 10; 
        reversedSoFar = reversedSoFar * 10 + lastDigit; 
        return reverseNumber(originalNumber / 10, reversedSoFar); 
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String userChoice;

        do {
            int numberToReverse;

            do {
                System.out.print("Enter a number: ");
                numberToReverse = userInput.nextInt();
                if (numberToReverse < 0) {
                    System.out.println("Invalid input! Please enter a positive number.");
                }
            } while (numberToReverse < 0);

            int reversedNumber = reverseNumber(numberToReverse, 0); 
            System.out.println("Reversed number: " + reversedNumber);

            System.out.print("\nDo you want to try again? (yes/no): ");
            userInput.nextLine(); 
            userChoice = userInput.nextLine().trim().toLowerCase();

        } while (userChoice.equals("yes"));

        System.out.println("Thank you for using the program!");
    }
}

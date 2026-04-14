import java.util.Scanner;

public class QuotientCalculator {
    public static int findQuotient(int numOne, int numTwo) {
        if (numOne < numTwo) { 
            return 0;
        }
        return 1 + findQuotient(numOne - numTwo, numTwo); 
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String choice;

        do {
            int firstNum, secondNum;

            do {
                System.out.print("Enter first integer: ");
                firstNum = userInput.nextInt();
                if (firstNum <= 0) {
                    System.out.println("Invalid input! Input must be greater than 0.");
                }
            } while (firstNum <= 0);

            do {
                System.out.print("Enter second integer: ");
                secondNum = userInput.nextInt();
                if (secondNum <= 0) {
                    System.out.println("Invalid input! Input must be greater than 0.");
                }
            } while (secondNum <= 0);

            int quotient = findQuotient(firstNum, secondNum);
            System.out.println("Quotient of " + firstNum + "/" + secondNum + " is: " + quotient);

            System.out.print("\nDo you want to try again? (yes/no): ");
            userInput.nextLine();
            choice = userInput.nextLine().trim().toLowerCase();

        } while (choice.equals("yes"));

        System.out.println("Thank you for using the program!");
    }
}

import java.util.Scanner;

public class BinomialCoefficient {

    public static int binomialCoefficient(int numOne, int numTwo) {
        if (numTwo == 0 || numTwo == numOne) {
            return 1;
        }
        return binomialCoefficient(numOne - 1, numTwo - 1) + binomialCoefficient(numOne - 1, numTwo);
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String choice;

        do {
            int numOne, numTwo;

            do {
                System.out.print("Enter value of first number (must be >= 0): ");
                numOne = userInput.nextInt();
                if (numOne < 0) {
                    System.out.println("Invalid input! Number must be greater than 0.");
                }
            } while (numOne < 0);

            do {
                System.out.print("Enter value of second number (must be between 0 and " + numOne + "): ");
                numTwo = userInput.nextInt();
                if (numTwo < 0 || numTwo > numOne) {
                    System.out.println("Invalid input! Number must be between 0 and " + numOne + ".");
                }
            } while (numTwo < 0 || numTwo > numOne);

            System.out.println("\nUsing formula:");
            System.out.println("C(n, 0) = 1");
            System.out.println("C(n, n) = 1");
            System.out.println("C(n, k) = C(n-1, k-1) + C(n-1, k)\n");

            int result = binomialCoefficient(numOne, numTwo);
            System.out.println("C(" + numOne + ", " + numTwo + ") = " + result);

            System.out.print("\nDo you want to try again? (yes/no): ");
            userInput.nextLine(); 
            choice = userInput.nextLine().trim().toLowerCase();

        } while (choice.equals("yes"));

        System.out.println("Thank you for using the program!");
    }
}

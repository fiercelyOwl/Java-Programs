import java.util.Scanner;

public class BinaryConverter {

    public static void printBinary(int number) {
        if (number == 0) { 
            return;
        }
        printBinary(number / 2); 
        System.out.print(number % 2); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            int decimalNumber;

            do {
                System.out.print("Enter a number: ");
                decimalNumber = scanner.nextInt();
                if (decimalNumber < 0) {
                    System.out.println("Invalid input! Number must be positive.");
                }
            } while (decimalNumber < 0);

            System.out.print("Binary equivalent of " + decimalNumber + " is: ");
            
            if (decimalNumber == 0) {
                System.out.print("0"); 
            } else {
                printBinary(decimalNumber); 
            }

            System.out.println(); 

            System.out.print("\nDo you want to try again? (yes/no): ");
            scanner.nextLine(); 
            choice = scanner.nextLine().trim().toLowerCase();

        } while (choice.equals("yes"));

        System.out.println("Thank you for using the program!");
    }
}

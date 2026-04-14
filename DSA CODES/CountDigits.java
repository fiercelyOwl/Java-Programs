import java.util.Scanner;

public class CountDigits {

    // Recursive function to count digits
    public static int countDigits(long n) {
        if (n == 0)            // Base case
            return 0;
        else
            return 1 + countDigits(n / 10);  // Recursive call
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = userInput.nextLong();

        int digits = countDigits(number);
        System.out.println("Number of digits in " + number + " is " + digits);

    }
}

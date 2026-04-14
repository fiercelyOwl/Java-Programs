import java.util.Scanner;

public class PrimeCounter {
    public static boolean isPrime(int number, int divisor) {
        if (number < 2) {
            return false;
        }
        if (divisor == 1) {
            return true;
        }
        if (number % divisor == 0) {
            return false;
        }
        return isPrime(number, divisor - 1);
    }

    public static int countPrimes(int numOne, int numTwo) {
        if (numOne > numTwo) {
            return 0;
        }
        if (isPrime(numOne, numOne - 1)) {
            return 1 + countPrimes(numOne + 1, numTwo);
        } else {
            return countPrimes(numOne + 1, numTwo);
        }
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
		String choice;
		do{
        int firstNum, secondNum;

        do {
            System.out.print("Enter starting number: ");
            firstNum = userInput.nextInt();
            if (firstNum <= 0) {
                System.out.println("Invalid input! Input cannot be 0 or less than 0.");
            }
        } while (firstNum <= 0);

        do {
            System.out.print("Enter ending number: ");
            secondNum = userInput.nextInt();
            if (secondNum < firstNum) {
                System.out.println("Invalid input! Input cannot be 0 or less than 0.");
            }
        } while (secondNum < firstNum);

        int primeCount = countPrimes(firstNum, secondNum);
        System.out.println("Number of prime numbers between " + firstNum + " and " + secondNum + " is: " + primeCount);
		System.out.print("\nDo you want to try again? (yes/no): ");
		userInput.nextLine(); 
        choice = userInput.nextLine().trim().toLowerCase();
			
		} while(choice.equals("yes"));
		
		System.out.println("Thank you for using the program!");
	}
}

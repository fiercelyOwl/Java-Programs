import java.util.Scanner;

public class RemainderCalculator{
	public static int findRemainder(int dividend, int divisor){
		if(dividend < divisor){
			return dividend;
		}
		return findRemainder(dividend - divisor, divisor);
	}

	public static void main(String [] args){
		Scanner userInput = new Scanner(System.in);
		String userChoice;
		do{
			int dividend, divisor;
			do{
				System.out.print("Enter a number for dividend: ");
				dividend = userInput.nextInt();
				if (dividend <= 0){
					System.out.println("Invalid input! Number must be greater than 0.");
				}
			}while (dividend <= 0);
		
			do{
				System.out.print("Enter a number for divisor: ");
				divisor = userInput.nextInt();
				if(divisor <= 0){
					System.out.println("Invalid input! Number must be greater than 0.");
				}
			}while (divisor <= 0);
		
			int remainder = findRemainder(dividend, divisor);
			System.out.println("Remainder of " + dividend + "/" + divisor + " is: " + remainder);
		
			System.out.print("Do you want to try again? (yes/no): ");
			userInput.nextLine();
			userChoice = userInput.nextLine().trim().toLowerCase();
		
		}while(userChoice.equals("yes"));
		
		System.out.println("Thank you for using the program!");
	}
}


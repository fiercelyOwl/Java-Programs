import java.util.Scanner;

public class NumbersToWords{
	
	public static void displayInWords(int number){
		if (number == 0){
			return;
		}
		int digit = number % 10;
		displayInWords(number / 10);
		printWord(digit);
	}
	
	public static void printWord(int digit){
		switch (digit){
			case 0:
				System.out.print("zero ");
				break;
			case 1:
				System.out.print("one ");
				break;
			case 2:
				System.out.print("two ");
				break;
			case 3:
				System.out.print("three ");
				break;
			case 4:
				System.out.print("four ");
				break;
			case 5:
				System.out.print("five ");
				break;
			case 6:
				System.out.print("six ");
				break;
			case 7:
				System.out.print("seven ");
				break;
			case 8:
				System.out.print("eight ");
				break;		
			case 9:
				System.out.print("nine ");
				break;				
				
		}
	}
	public static void main(String [] args){
		Scanner userInput = new Scanner(System.in);
		String userChoice;
		do{
			int userNumber;
			do{
				System.out.print("Enter a number: ");
				userNumber = userInput.nextInt();
				if(userNumber < 0){
					System.out.println("Invalid input! Enter positive numbers only.");
				}
			}while (userNumber < 0);
			System.out.println("Number in words: ");
			if (userNumber == 0){
				System.out.print("zero");
			}else {
				displayInWords(userNumber);
			}
			System.out.println("\n");
			
			System.out.print("Do you want to try again? (yes/no): ");
			userInput.nextLine();
			userChoice = userInput.nextLine().trim().toLowerCase();
		}while (userChoice.equals("yes"));
		
		System.out.println("Thank you for using the program!");
	}
}
import java.util.*;

public class MesinaMidtermRandomNumberGame {
	public static void main (String [] args){
	// how you get the random number 	
	Random randomNumber = new Random ();
	int guessNumber = randomNumber.nextInt(50) + 1; //allows to guess 1-50
	int attempt = 0; // to keep track of attempts
	Scanner userInput = new Scanner (System.in);
	
		while (true){
			System.out.print("Guess a number" + "(attempt # " + ++attempt + "):" );
			int playerGuess =  userInput.nextInt();
			
			if (playerGuess < 1 || playerGuess > 50){
				System.out.println("Invalid input!");
				break;
			}
			
			if (playerGuess == guessNumber){
				System.out.println("Congratulations! You got it right after " + attempt + " attempts!" );
				break;
			} else if(guessNumber > playerGuess){ //if the player guess is greater than the guess number
				System.out.println("The guess number is higher than " + playerGuess + ", guess again.");
			} else {//if the player guess is less than the guess number
				System.out.println("The guess number is lower than " + playerGuess + ", guess again.");
			}
		}
		
		
	}

}
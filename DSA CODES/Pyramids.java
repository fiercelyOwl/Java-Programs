
public class Pyramids{
	public static void printNumbers (int current, int limit){
		if (current > limit){
			return;
		}
		System.out.print(current + " ");
		printNumbers(current + 1, limit);
	}
	
	public static void printLetters(char letter, int count){
		if (count == 0){
			return;
		}
		System.out.print(letter);
		printLetters((char)(letter + 1), count - 1);
		
	}
	public static void printSpaces(int count){
		if (count == 0){
			return;
		}
		System.out.print(" ");
		printSpaces(count - 1);
	}
	public static void printPyramids(int currentRow, int totalRow){
		if (currentRow > totalRow){
			return;
		}
		printNumbers(1, currentRow);
		
		int spaces = (totalRow - currentRow + 1) * 2;
		printSpaces(spaces);
		
		printLetters('a', totalRow - currentRow + 1);
		
		System.out.println();
		
		printPyramids(currentRow + 1, totalRow);
		
	}
	
	public static void main (String [] args){
		int totalRow = 4;
		System.out.println("\n Pyramid Pattern: ");
		printPyramids(1, totalRow);
		System.out.println("\nThank you for using the program!");
	}
}
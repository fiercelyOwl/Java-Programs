import java.util.Scanner;
public class ArrayAddition {
    public static void main (String [] args){
        Scanner meow = new Scanner (System.in);
        int [] [] nums = new int [3][3];
        System.out.println(" Enter 6 numbers: ");
        for (int i = 0; i < 3; i++) {  
            for( int j = 0; j < 3; j++) 
                nums [i][j] = meow.nextInt();
        }    
        for (int i = 0; i< 3; i++){
            int sumRow = 0;
            for (int j = 0; j < 3; j++){
                sumRow += nums[i][j];
            }
        System.out.println("the sum of Row" + ( i + 1) + " is: "  +sumRow);
}
        for (int j = 0; j < 3; j++){
            int sumCol = 0;
            for (int i = 0; i < 3; i++){
                    sumCol += nums [i][j];
            }
        System.out.println("the sum of Column" + ( j + 1 ) + " is: "  +sumCol);
        }
}
}

        
        
        
        
        
    
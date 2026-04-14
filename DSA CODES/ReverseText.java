import java.io.IOException;

public class ReverseText {
    public static void reverse() throws IOException {
        char letter = (char) System.in.read(); 
        if ( letter == '\n') { 
            return; 
        }
        reverse(); 
        System.out.print(letter); 
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a line of text:");
        reverse(); 
        System.out.println("\nText reversed!");
    }
}

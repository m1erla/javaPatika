package Entrance;
import java.util.Scanner;
public class Averages {
    public static void main(String[] args) {
     // Create Variables
     int math,physics,history,chemistry,musics,turkish;

     // Defined the scanner class
     Scanner input = new Scanner(System.in);

        // Get input to user

        System.out.print("Please enter your math note :");
        math = input.nextInt();


        System.out.println("Please enter your physics note : ");
        physics = input.nextInt();

        System.out.println("Please enter your history note : ");
        history = input.nextInt();

        System.out.println("Please enter your chemistry note : ");
        chemistry = input.nextInt();

        System.out.println("Please enter your turkish note : ");
        turkish = input.nextInt();

        System.out.println("Please enter your musics note : ");
        musics = input.nextInt();

        int total = (math + chemistry + physics + turkish + musics + history);
        double result = total / 6.0;

        System.out.println("Your Averages : " + result);
        System.out.print(result >= 50 ? "Passed" : " Faıled to pass");
    }
}

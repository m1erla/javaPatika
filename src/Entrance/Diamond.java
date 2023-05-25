package Entrance;

import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        // Defined Variables
        int number;
        // Get Input From User
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter A Number :  ");
        number = input.nextInt();
        // Loop
       /* for (int i = 0; i <= number; i++){
            for (int j = 0; j < (number - i); j++){
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i + 1); k++){
                System.out.print("*");
            }
            System.out.println();

        }*/
        // Output
        for (int i = 1; i <= number; i++){
            for (int j = 0; j < i; j++){
                System.out.print(" ");
            }
            for (int k = (2 * (number - i))+ 1; k > 0; k--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

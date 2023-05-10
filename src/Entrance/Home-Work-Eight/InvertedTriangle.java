package Entrance;

import java.util.Scanner;

public class InvertedTriangle {
    public static void main(String[] args) {
        /*** INVERTED TRIANGLE   ***/
        // Defined Variables
        int digitsNumber;

        // Get Input From User
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter A Digits Number : ");
        digitsNumber = input.nextInt();

        // Loops and Output
        for (int i = 1; i <= digitsNumber; i++){
            for (int j = 0; j < i; j++){
                System.out.print(" ");
            }
            for (int k = (2 * (digitsNumber - i))+ 1; k > 0; k--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

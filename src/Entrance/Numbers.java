package Entrance;

import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        /*** MULTIPLES OF NUMBERS ***/
        // Defined Variables
        int number;

        // Get Input From User

        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter a number : ");
        number =scan.nextInt();

        // Conditions and Output
        for (int i = 1; i <= number;i*=4){
            System.out.println("Multiples of 4 : " + i);
        }
        System.out.println("-------------------------");
        for (int i = 1; i <= number;i*=5){
            System.out.println("Multiples of 5 : " + i);
        }

    }
}


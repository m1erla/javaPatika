package Entrance;

import java.util.Scanner;

public class HarmonicNumber {
    public static void main(String[] args) {
        // Defined Variables
        int number;
        double result = 0.0;
        // Get Input From User
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter A Number :  ");
        number = input.nextInt();
        // Loop
        for (int i = 1; i<=number; i++){
            result += (1.0/i);
        }
        // Output
        System.out.println(result);
    }
}

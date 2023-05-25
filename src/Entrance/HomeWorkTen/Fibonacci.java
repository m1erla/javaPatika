package Entrance.HomeWorkTen;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        /*** FIBONACCI NUMBER ***/
        // Defined Variables
        int fiboNumber, firstTerm = 0, secondTerm = 1;

        // Get Input From User
        Scanner input = new Scanner(System.in);
        System.out.print("Enter A Number : ");
        fiboNumber = input.nextInt();

        // Loops And Output
        for (int i = 1; i <= fiboNumber; i++){
            System.out.print(firstTerm + ", ");

           // compute the next term
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }

    }
}

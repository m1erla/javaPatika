package Entrance;

import java.util.Scanner;

public class SumOfNumber {
    public static void main(String[] args) {
        // Defined Variables
        int number, total=0, digitsNumber;
        // Get Input From User
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter A Number : ");
        number = input.nextInt();
        // Loop
        while (number != 0){
            digitsNumber = number % 10;
            number /= 10;
            total += digitsNumber;
        }
        // Output
        System.out.println("Sum Number  :" + total);
    }
}

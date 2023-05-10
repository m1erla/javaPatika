package Entrance;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        /*** A PERFECT NUMBER APP  
         You can find out if the numbers you entered are perfect numbers
        ***/
        
        // Defined Variables
        int number, i = 1, total = 0;

        // Get Input From User
        Scanner input = new Scanner(System.in);
        System.out.print("Enter A First Number : ");
        number = input.nextInt();

        // Loops and Output
        for (i = 1; i <= number/2; i++){
            if (number % i == 0){
                total += i;
            }
        }
        if (total == number){
            System.out.println(number + " A Perfect Number. ");
        }
        else {
            System.out.println(number + " Not A Perfect Number.");
        }
    }
}

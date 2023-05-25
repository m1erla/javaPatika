package Entrance;

import java.util.Scanner;

public class FindNumber {
    public static void main(String[] args) {
        /***  FIND NUMBER  ***/
        // Defined Variables
        int counter=0, number,sum=0;
        double average;

        // Get Input From User
        Scanner input =new Scanner(System.in);
        System.out.print("Please enter a number: ");
        number = input.nextInt();

        // Output
        for (int i = 1; i <number ; i++) {

            if (i%3==0 && i%4==0){
                sum +=i;
                counter++;

            }
        }
        System.out.println("The sum of the numbers dividing by 3 and 4 until the number you entered : "+sum);

        if (counter == 0) {
            System.out.println("There is no number that is divisible by 3 and 4 until the number you entered.");
        } else {
            average =  (double) sum   / counter;
            System.out.println("Average of numbers divided by 3 and 4 up to the number you entered:" + average);
        }
    }

}







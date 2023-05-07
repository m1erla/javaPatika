package Entrance;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        /***       BASIC CALCULATOR MACHINE      ***/

        // Defined Variables
        int n1,n2,selected;

        // Get input from user
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the first number :");
        n1 = input.nextInt();

        System.out.print("Please enter the second number : ");
        n2 = input.nextInt();

        System.out.println("1 -- Sum \n2 -- Minus \n3 -- Multiplication\n4 -- Division");
        System.out.print("Your Selection : ");
        selected = input.nextInt();


        // Output
        switch (selected){
            case 1:
                System.out.println("Sum Result: " + (n1 + n2));
                System.out.println("Transaction completed ! ");
                break;
            case 2 :
                System.out.printf("Minus Result: " + (n1 - n2));
                System.out.println("Transaction completed !");
                break;
            case 3 :
                System.out.println("Multiplication Result: " + (n1 * n2));
                System.out.println("Transaction completed !");
                break;
            case 4 :
                System.out.println("Division Result: " +(n2 != 0 ? (n1 / n2) : "Error : A Number Cannot Be Divided By Zero Please Try Again" ) );
                System.out.println("Transaction not completed !");
                break;
            default:
                // Warning Message
                System.out.printf("Error : Please Select One Of The Available Numbers!");
                break;
        }

    }
}

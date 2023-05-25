package WeekTwo.FirstHomeWork;

import java.util.Scanner;

public class RecursivePower {
    // Defined Static Recursive Method
    static int pow(){
        // Defined Variables
        int result = 1, exponent, base;
        // Get Input From User
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter A Base Value : ");
        base = scan.nextInt();
        System.out.print("Enter An Exponent Value : ");
        exponent = scan.nextInt();
        // Transaction of Pow
        for (int i = 1; i <= exponent; i++){
            result *= base;
        }
        // Return Value
       return  result;
    }
    public static void main(String[] args) {
        // Output
        System.out.print("Result : " + pow());

    }
}

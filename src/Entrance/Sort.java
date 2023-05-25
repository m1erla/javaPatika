package Entrance;

import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        /***       SORT NUMBERS FROM SMALLEST TO LARGEST    ***/

        // Defined Variables
        int a,b,c;

        // Get input from user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter The First Number : ");
        a = input.nextInt();
        System.out.print("Enter The Second Number : ");
        b = input.nextInt();
        System.out.print("Enter The Third Number : ");
        c = input.nextInt();


        // Output
        if ((a < b) && (a < c)){
            if (b < c){
                System.out.println("a < b < c");
            }else {
                System.out.printf("a < c < b");
            }
        } else if ((b < a) && (b < c)) {
            if (a < c){
                System.out.printf("b < a < c");
            }else {
                System.out.printf("b < c < a");
            }
        }
    }
}

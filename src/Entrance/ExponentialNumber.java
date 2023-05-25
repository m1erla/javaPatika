package Entrance;

import java.util.Scanner;

public class ExponentialNumber {
    public static void main(String[] args) {
        /***  EXPONENTIAL NUMBER ***/
        //Defined Variables
        int n,k, total =1, i =1;
        // Get Input From User
        Scanner inp = new Scanner(System.in);
        System.out.print("Üssü alınacak sayı :");
        n = inp.nextInt();
        System.out.print("Üs olucak sayı ");
        k = inp.nextInt();

        // Use For Loop, Output
        for (i = 1; i <= k; i++){
            total *= n;
        }
        System.out.println("Result : " + total);
    }
}

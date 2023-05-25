package Entrance;

import java.util.Scanner;

public class Combination {
    public static void main(String[] args) {
        // Defined Variables
        int n, r, i, minus, combination, nFac = 1, rFac =1, cFac = 1;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number of n : ");
        n = input.nextInt();
        System.out.print("Please enter r : ");
        r = input.nextInt();

        minus = n - r;
        for (i = 1; i<= n; i++)
            nFac = nFac * i;
        for (i = 1; i <  r; i++)
            rFac = rFac * i;
        for (i = 1; i < minus; i++)
            cFac = cFac * i;
        combination = nFac / (rFac * cFac);
        System.out.println("Combination : " + combination);
    }



}

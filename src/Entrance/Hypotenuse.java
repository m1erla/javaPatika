package Entrance;

import java.util.Scanner;

public class Hypotenuse {
    public static void main(String[] args) {
        // Defined Variables
        int a,b;
        double c,u,area, perimeter;

        // Defined the scanner class
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the A side of the triangle : ");
        a = input.nextInt();
        System.out.print("Please enter the B side of the triangle : ");
        b = input.nextInt();
 /*
      Also you can get input from user for the C side if you want.

      System.out.print("Please enter the C side of the triangle : ");
      c = input.nextInt();

  */
        // Formulas
        c = Math.sqrt((a*a) + (b*b));
        u = (a + b + c) / 2;
        perimeter = 2*u;
        area = u * (u-a) * (u-b) * (u-c);

        // Outputs
        System.out.println("Hypotenuse : "  + c);
        System.out.println("Perimeter of triangle : " + perimeter);
        System.out.println("Area of triangle : " + area);
    }
}

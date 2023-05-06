package Entrance;

import java.util.Scanner;

public class Beginning {
    public static void main(String[] args) {
      int shortCut = 20, longTerm = 40;
      int field = shortCut * longTerm;
      int envrimont = 2 * (shortCut + longTerm);
        System.out.println(field);
        System.out.println(envrimont);
        int numberOne, numberTwo = 2, numberThree;

        numberOne = 1;
        numberThree = numberOne + numberTwo;
        System.out.println(numberThree);
        int number = 5, number2 = 5;
        boolean result = number != number2;
        System.out.println(result);

        int test1 = 5, test2 = 6;
        boolean result2 = test1 >= test2;
        boolean result4 = test1 == test2;
        boolean resulter = !((test1 <= test2 || test1 >= test2));


        System.out.println(resulter);
        String str = (resulter) ? "Correct" : "Wrong";
        System.out.println(str);

        int d;
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your price : ");
        d = input.nextInt();
        System.out.println(d);
        System.out.print("Please enter your price : ");
        double f = input.nextDouble();
        System.out.println(f);

      int a,b;
      double c;

      Scanner secondPut = new Scanner(System.in);
      System.out.print("Please enter the first side of the triangle : ");
      a = input.nextInt();
      System.out.print("Please enter the second side of the triangle : ");
      b = input.nextInt();

      c = Math.sqrt((a*a) + (b*b));
      System.out.printf("Hypotenuse : "  + c);

    }
}


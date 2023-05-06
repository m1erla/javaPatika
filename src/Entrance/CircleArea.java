package Entrance;

import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {

        // Calculator of circle area app
        // Defined variables
        int r,alpha;
        double pi = 3.14 , area,perimeter, circleArea;

        // Get input from user
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter radius :  ");
        r = input.nextInt();
        System.out.print("Please enter the center angle of the part you want to calculate : ");
        alpha = input.nextInt();
        // formulas
        area = pi * r *r;
        perimeter = 2 * pi *r;
        circleArea = (pi * (r*r) * alpha)/360;
        System.out.println("Center angel of circle  : " + circleArea);
        System.out.println("Area of circle : " + area);
        System.out.println("Perimeter of circle : " + perimeter);
    }
}

package Entrance;

import java.util.Scanner;

public class HwBodyMassIndex {
    public static void main(String[] args) {
        /***       CALCULATOR OF BODY MASS INDEX       ***/

        // Defined Variables
        int weight;
        double  height,bodyMassIndex;

        // Get input from user
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your height (in meters) :");
        height = input.nextFloat();
        System.out.print("Please enter your weight (in kg) : ");
        weight = input.nextInt();

        // Body mass index formul
        bodyMassIndex = weight / (height * height);

        // Output
        System.out.print("Your Body Mass Index : " + bodyMassIndex);
    }
}

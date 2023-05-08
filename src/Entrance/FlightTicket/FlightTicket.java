package Entrance;

import java.util.Scanner;

public class FlightTicket {
    public static void main(String[] args) {
        /****     FLIGHT TICKET CALCULATOR   ****/
        
        // Defined Variables
        int km, age, typeOfTravel;
        double perDistance = 0.10,
                normalAmount,
                ageOff,
                ageOffFirst,
                childOffRate = 0.50,
                youngOffRate = 0.10,
                adultOffRAte = 0.30,
                discountedAmount,
                totalAmount,
                typeOff;


        // Get Input From User
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Distance (In Km) : ");
        km = input.nextInt();
        System.out.print("Enter Your Age : ");
        age = input.nextInt();
        System.out.printf("Please Choice One Of These : " +
                "\n1 => One-Way " +
                "\n2 => Round-Trip = ");
        typeOfTravel = input.nextInt();

        // Formulas
        normalAmount = km * perDistance;
        ageOffFirst = normalAmount * childOffRate;
        discountedAmount = normalAmount - ageOffFirst;


        // Output
        if (age < 12){
            if (typeOfTravel == 1){
                normalAmount = km * perDistance;
                ageOff = normalAmount * childOffRate;
                System.out.println("Total Cost : " + ageOff);
            } else if (typeOfTravel == 2 ) {
                normalAmount = km * perDistance;
                ageOff = normalAmount * childOffRate;
                discountedAmount = normalAmount - ageOff;
                typeOff = discountedAmount * 0.20;
                totalAmount = (discountedAmount - typeOff) * 2;
                System.out.println("Total Cost : " + totalAmount);
            }
              else {
                System.out.println("You Entered Wrong Data");
            }
        }
        if (age >= 12 && age <= 24){
            if (typeOfTravel == 1){
                normalAmount = km * perDistance;
                ageOff = normalAmount * youngOffRate;
                discountedAmount = normalAmount - ageOff;
                System.out.println("Total Cost : " + discountedAmount);
            } else if (typeOfTravel == 2 ) {
                normalAmount = km * perDistance;
                ageOff = normalAmount * youngOffRate;
                discountedAmount = normalAmount - ageOff;
                typeOff = discountedAmount * 0.20;
                totalAmount = (discountedAmount - typeOff) * 2;
                System.out.println("Total Cost : " + totalAmount);
            }
            else {
                System.out.println("You Entered Wrong Data");
            }
        }
        if (age > 24 && age < 65){
            if (typeOfTravel == 1){
                normalAmount = km * perDistance;
                System.out.println("Total Cost : " + normalAmount);
            } else if (typeOfTravel == 2 ) {
                normalAmount = km * perDistance;
                typeOff = discountedAmount * 0.20;
                totalAmount = (discountedAmount - typeOff) * 2;
                System.out.println("Total Cost : " + totalAmount);
            }
            else {
                System.out.println("You Entered Wrong Data");
            }
        }
        if (age >= 65){
            if (typeOfTravel == 1){
                normalAmount = km * perDistance;
                ageOff = normalAmount * adultOffRAte;
                discountedAmount = normalAmount - ageOff;
                System.out.println("Total Cost : " + discountedAmount);
            } else if (typeOfTravel == 2 ) {
                normalAmount = km * perDistance;
                ageOff = normalAmount * youngOffRate;
                discountedAmount = normalAmount - ageOff;
                typeOff = discountedAmount * 0.20;
                totalAmount = (discountedAmount - typeOff) * 2;
                System.out.println("Total Cost : " + totalAmount);
            }
            else {
                System.out.println("You Entered Wrong Data");
            }
        }

    }
}

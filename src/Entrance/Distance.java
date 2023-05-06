package Entrance;
import java.util.Scanner;


public class Distance {
    public static void main(String[] args) {
        // Defined Variables
        int km, openPrice = 10, fixedPrice = 20;
        double perKm = 2.20,amountToBePaid;
        // Defined The Scanner Class
        Scanner distance = new Scanner(System.in);

        System.out.println("Welcome to my taxi, open price is " + openPrice + "$");
        System.out.print("Please enter your total distance : ");
        // Get Input From User
        km = distance.nextInt();
        // Output Formulas
        amountToBePaid = (km * perKm);
        amountToBePaid += openPrice;
        amountToBePaid = (amountToBePaid < 20) ? fixedPrice : amountToBePaid;
        System.out.printf("Total Amount : " + amountToBePaid);

    }
}

package Entrance;

import java.util.Scanner;

public class KdvCalculate {
    public static void main(String[] args) {
        // Defined Variables
        double userPrice,
                vat = 0.18,
                vatCost,
                totalPrice,
                vatOff = 0.08,
                vatRate,
                costVat,
                biggerPrice;

        // Defined The Scanner Class
        Scanner input = new Scanner(System.in);
        // Get input from user
        System.out.print("Please enter your price : ");
        userPrice = input.nextDouble();

        vatCost = userPrice * vat;
        vatRate = userPrice * vatOff;
        totalPrice =userPrice + vatCost;
        costVat = userPrice * vatOff;
        biggerPrice = userPrice + costVat;

        // Used Condition For Vat Rate
        if (userPrice <= 1000 ){
            System.out.println("Without KDV price : " + userPrice);
            System.out.println("Price of KDV : " + vatCost);
            System.out.println("KDV rate : " + vat);
            System.out.println("Total price with VAT : " + totalPrice);
        }else{
            System.out.println("Without KDV price : " + userPrice);
            System.out.println("Price of KDV : " + vatRate);
            System.out.println("KDV rate : " + vatOff);
            System.out.println("Total price with VAT : " + biggerPrice);
        }

    }

}

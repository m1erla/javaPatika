package Entrance;

import java.util.Scanner;

public class Grocery {
    public static void main(String[] args) {
        /***       GROCERY CASHIER PROGRAM       ***/

        // Defined Variables
        double
                totalAmount,
                kgAubergine, kgPear, kgBanana,kgTomato,kgApple,
                userAubergine,userPear,userBanana, userApple, userTomato ,
                pear = 2.14, banana = 0.95, apple = 3.67, tomato = 1.11 , aubergine = 5.00;

        // Get input from user
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the weight of aubergine in kilogram :");
        userAubergine = input.nextDouble();
        System.out.print("Please enter the weight of pear in kilogram : ");
        userPear = input.nextDouble();
        System.out.print("Please enter the weight of banana in kilogram : ");
        userBanana = input.nextDouble();
        System.out.print("Please enter the weight of tomato in kilogram : ");
        userTomato = input.nextDouble();
        System.out.print("Please enter the weight of apple in kilogram : ");
        userApple = input.nextDouble();

        // formula
        kgAubergine = userAubergine * aubergine;
        kgPear = userPear * pear;
        kgTomato = userTomato * tomato;
        kgBanana = userBanana * banana;
        kgApple = userApple * apple;
        totalAmount = (kgApple + kgBanana + kgAubergine + kgPear + kgTomato);

        // Output
        System.out.println("How many kilos a banana ? : " + (userBanana == 0 ? 0 : userBanana) + " kg ");
        System.out.println("How many kilos a pear ? : " + (userPear == 0 ? 0 : userPear) +  " kg ");
        System.out.println("How many kilos a apple ? : " + (userApple == 0 ? 0 : userApple) +  " kg ");
        System.out.println("How many kilos a tomato ? : " + (userTomato == 0 ? 0 : userTomato) +  " kg ");
        System.out.println("How many kilos a aubergine ? : " + (userAubergine == 0 ? 0 : userAubergine) + " kg ");
        System.out.println("Total Price : " + totalAmount + " $");
    }
}

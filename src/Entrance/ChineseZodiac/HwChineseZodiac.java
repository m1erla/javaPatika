package Entrance;

import java.util.Scanner;

public class HwChineseZodiac {
    public static void main(String[] args) {
        /***      CHINESE ZODIAC SIGN           ***/
        // Defined Variables
        int birthYear;
        String  Monkey = "Monkey",
                Cockerel = "Cockerel" ,
                Dog = "Dog" ,
                Pig = "Pig",
                Mouse = "Mouse" ,
                Ox = "Ox",
                Tiger = "Tiger",
                Rabbit = "Rabbit",
                Dragon = "Dragon",
                Snake = "Snake",
                Horse = "Horse",
                Sheep = "Sheep"
                        ;

        double result;

        // Get Input From User
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your year of birth : ");
        birthYear = input.nextInt();

        // Formulas
        result = birthYear % 12;

        // Output
        if ((result == 0)){
            System.out.printf("Your Chinese Zodiac Sign : "
                    + Monkey);
        } else if (result == 1) {
            System.out.print("Your Chinese Zodiac Sign : "
                    + Cockerel );
        } else if (result == 2) {
            System.out.print("Your Chinese Zodiac Sign : "
                    + Dog);
        }else if (result == 3) {
            System.out.print("Your Chinese Zodiac Sign : "
                    + Pig);
        }else if (result == 4) {
            System.out.print("Your Chinese Zodiac Sign : "
                    + Mouse);
        }else if (result == 5) {
            System.out.print("Your Chinese Zodiac Sign : "
                    + Ox);
        }else if (result == 6) {
            System.out.print("Your Chinese Zodiac Sign : "
                    + Tiger);
        }else if (result == 7) {
            System.out.print("Your Chinese Zodiac Sign : "
                    + Rabbit);
        }else if (result == 8) {
            System.out.print("Your Chinese Zodiac Sign : "
                    + Dragon);
        }else if (result == 9) {
            System.out.print("Your Chinese Zodiac Sign : "
                    + Snake);
        }else if (result == 10) {
            System.out.print("Your Chinese Zodiac Sign : "
                    + Horse);
        }else if (result == 11) {
            System.out.print("Your Chinese Zodiac Sign : "
                    + Sheep);
        }
    }
}

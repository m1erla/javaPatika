package Entrance;

import java.util.Scanner;

public class Weather {
    public static void main(String[] args) {
        int temperature;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Temperature : ");
        temperature = input.nextInt();

        if (temperature <=5){
            System.out.printf("Recommended Skiing");
        } else if (temperature > 5 && temperature < 15) {
            System.out.println("Recommended Theater");
        } else if (temperature >15 && temperature < 25) {
            System.out.println("Recommended Picnic");
        }
        else {
            System.out.printf("Recommended Swim");
        }
    }
}

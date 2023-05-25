package Entrance;

import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        /*
        Scanner input = new Scanner(System.in);

            System.out.print("Please Enter A Number : ");
            int number = input.nextInt();
            int result =0, basPow, basValue, basNumber = 0;
            int tempNumber = number;

            while (tempNumber !=0){
                tempNumber /= 10;
                basNumber++;

            }
            tempNumber = number;
            while (tempNumber != 0){
                basValue = tempNumber % 10;
                basPow =1;
                for (int i = 1; i <= basNumber; i++){
                    basPow *= basValue;
                }
                result += basPow;
                tempNumber /= 10;

            }
            if (result == number){
                System.out.println(result + " Number");
            }
            else {
                System.out.println(result + " Not");
            }
            */
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter A Number : ");
        int number = input.nextInt();
        int result =0, basPow, basValue, basNumber =0;
        int tempNumber = number;


        while (number > 0){
            basValue = number % 10;
            number /= 10;
            result += basValue;
        }
        System.out.println(result);

        if (result == number){
            System.out.println(result + " correct");
        }else {
            System.out.println(result + " test");
        }
    }
}

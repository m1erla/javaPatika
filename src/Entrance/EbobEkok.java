package Entrance;

import java.util.Scanner;

public class EbobEkok {
    public static void main(String[] args) {
        int numberFirst ,numberSecond, ebob = 1, ekok = 1, i = 1;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter A First Number : ");
        numberFirst = input.nextInt();
        System.out.print("Enter A Second Number : ");
        numberSecond = input.nextInt();

        while(i <= numberFirst){
            i++;
            if (numberFirst % i == 0 && numberSecond % i == 0){
                ebob = i;
            }
            ekok = (numberFirst * numberSecond) / ebob;
        }
        System.out.println("Ebob : " + ebob);
        System.out.println("Ekok : " + ekok);
    }
}

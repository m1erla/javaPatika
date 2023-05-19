package WeekTwo.PractiseMinMax;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] list = {45, 12, 77, 7, 435 ,22, 23};
        System.out.println("List : " + Arrays.toString(list));

        System.out.print("Please Enter A Number : ");
        int number = input.nextInt();
        int min = number;
        int max = number;
        Arrays.sort(list);
        System.out.println("Sort Of List : " + Arrays.toString(list));

        for (int bigger : list){
            if (bigger > number){
                max = bigger;
                break;
            }
        }

        for (int smaller = list.length - 1; smaller >= 0; smaller--){
            if (list[smaller] < number){
                min = list[smaller];
                break;
            }
        }
        System.out.println("Nearest Major Number : " + max);
        System.out.println("Nearest Small Number : " + min);

        for (int cost : list){
         if (cost < min){
                min = cost;
        }
         if (cost > max){
              max = cost;
          }
       }
        System.out.println("Maximum Value : " + max);
        System.out.println("Minimum Value : " + min);

    }
}

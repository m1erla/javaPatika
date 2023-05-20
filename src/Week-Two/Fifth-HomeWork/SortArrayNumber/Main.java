package WeekTwo.SortArrayNumber;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Get Input From User
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter Array Length : ");
        int arrayLength = input.nextInt();

        // Defined Array Method
        int[] list = new int[arrayLength];


        // Get Input From User and Use for Loop
        System.out.println("Please Enter The Elements of The Array ");
        for (int i = 0; i < list.length; i++){
            System.out.print((i + 1 ) + " . Enter The Element : ");
            list[i] = input.nextInt();
        }

        // Outputs and Sort The Array
        System.out.println("Array : " + Arrays.toString(list));
        Arrays.sort(list);
        System.out.println("Sort : " + Arrays.toString(list));

    }
}

package Entrance;

import java.util.Scanner;

public class MinMaxValue {
    public static void main(String[] args) {
        /*** MAX MIN VALUE ***/

        // Defined Variables
        int number,max = 0,min = 0;
        // Get Input From User
        Scanner input = new Scanner(System.in);
        System.out.print("How Many Numbers Will You Enter : ");
        number = input.nextInt();
        // Loops
            for (int i = 1; i <= number; i++) {
                System.out.print(i + ". Enter The Number : ");
                number = input.nextInt();
                if (number > max)
                    max = number;
                if (number < min || min == 0)
                    min = number;
            }
            // Output
        System.out.println("Maximum Value : " + max);
        System.out.println("Minimum Value : " + min);

    }
}

package WeekTwo.SecondHomeWork;

import java.util.Scanner;

public class RecursivePattern {
    /*** DECREASONG AND INCREASING NUMBER ***/
    // Defined Static Method And Variables
    static void decreasongNumber(int number, int tempNumber){
        // Condition And Formula
        if (number > 0){
            System.out.print(number + " ");
            number -= 5;
            decreasongNumber(number, tempNumber);

        }else {
            increasingNumber(number, tempNumber);
        }
    }
    // Defined Static Method And Variables
    static void increasingNumber(int number, int tempNumber){
        // Condition And Formula
        if (number < tempNumber){
            System.out.print(number + " ");
            number += 5;
            increasingNumber(number, tempNumber);
        }
    }
    public static void main(String[] args) {
        // Defined Variables
        int number, tempNumber;
        // Get Input From User
        Scanner input = new Scanner(System.in);
        System.out.print("Enter N Number : ");
        number = input.nextInt();
        // Initiliazed tempNumber
        tempNumber = number;
        // Output
        decreasongNumber(number, tempNumber);
    }
}

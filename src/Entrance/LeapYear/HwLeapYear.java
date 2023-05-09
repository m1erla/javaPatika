package Entrance;

import java.util.Scanner;

public class HwLeapYear {
    public static void main(String[] args) {
        /***      LEAP YEAR         ***/
        // Defined Variables
        int inputYear;
        double quadruple;
        // Get Input From User
            Scanner input = new Scanner(System.in);
            System.out.print("Enter A Year : ");
            inputYear = input.nextInt();

        // Formula
         quadruple = inputYear % 4;

        // Output
        if( (inputYear>100) &&  (inputYear % 400 == 0) && (inputYear % 100==0)) {
            System.out.println(inputYear + " A Leap Year ");
        }
        else if(inputYear%100!=0 && quadruple==0 ) {
            System.out.println(inputYear + " A Leap Year ");
        }
        else {
            System.out.println(inputYear + " This Year Is Not Leap Year!");
        }
    }
    }


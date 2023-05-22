package WeekTwo.NumberPredictGame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random passing = new Random();
        Scanner input = new Scanner(System.in);


        int number = passing.nextInt(100);
        int selected;
        int correct = 0;
        int[] wrongNumber = new int[5];
        boolean isWin = false;

        System.out.println(number);
        System.out.println("*** You Have Five Rights To Enter Numbers!! *** ");
        System.out.println();
        while (correct < 5){
            System.out.print("Please Enter Your Number of Predict : ");
            selected = input.nextInt();
            if (selected < 0 || selected > 100){
                System.out.println("Please Enter A Number 0 to 100");
                continue;
            }
            if (selected == number){
                System.out.println("Congratulations You Won! Your Number of Predict = > " + number);
                wrongNumber[correct] = selected;
                isWin = true;
                break;
            }else {
                System.out.println("Wrong Number! Please Try Again!");
                if (selected > number){
                    System.out.println("Your Predict is Bigger Than Number ");
                }else {
                    System.out.println("Your Predict is Smaller Than Number ");
                }
                wrongNumber[correct++] = selected;
                System.out.println("Your Remaining Right : " + (5 - correct));

            }

        }
        // int number =(int) (Math.random() * 100);
        System.out.println();
        if (!isWin){
            System.out.println("Sorry You Lost!");
        }
        System.out.println("Your Predicts = > " + Arrays.toString(wrongNumber));
    }
}

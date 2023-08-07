package WeekFive.PatikaStore;

import java.util.Scanner;

import static WeekFive.PatikaStore.Methods.*;
public class ControlPanel {
    static Scanner input = new Scanner(System.in);

    public static void entrancePanel(){
        System.out.println("-".repeat(20) + "PatikaStore Product Manager Panel !"+"-".repeat(20));

        System.out.print(
                 "-".repeat(20) + "TRANSACTIONS"+ "-".repeat(20) + "\n"
                + "   __________________         _____________________  \n"
                + "   | 1-Phone Actions|         | 2-Notebook Actions|  \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯         ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯   \n"
                + "   ___________________           __________   \n"
                + "   | 3-List of Brands |          | 4-Exit |   \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯           ¯¯¯¯¯¯¯¯¯¯   \n"
                + "Please select the transaction you want to do : ");
        int choose = input.nextInt();
        boolean isSelect = true;

        do {
            switch (choose){
                case 1 : addPhone();
                isSelect = false;
                break;
                case 3 :

                    isSelect = false;
                    break;
                default:
                    System.out.println("Wrong choose. Please try again ! ");
                    choose = input.nextInt();
            }
        }while (isSelect);
    }
}

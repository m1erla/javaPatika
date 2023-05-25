package WeekTwo.ThirdHomeWork;

import java.util.Scanner;

public class RecursivePrime {
    /*** RECURSIVE METHOD WITH PRIME NUMBER ***/
    // Defined Static Method Without Variables
    static void primeNumber(){
        // Defined Variables
        int counter = 0, primeNumber, control;

        // Get Input From User
        Scanner input = new Scanner(System.in);
        System.out.print("Enter A Number : ");
        primeNumber = input.nextInt();

            // Using for Loop And if Condition With Formulas
            for (int i = 2; i < primeNumber; i ++){
                if (primeNumber % i == 0){
                    counter++;
                }
            }
                if (counter == 0){
                    System.out.print(primeNumber + " Prime number !");
                }
                else {
                    System.out.print(primeNumber + " Not A Prime Number !");
                }

    }

    public static void main(String[] args) {
        // Output
        primeNumber();
    }
}

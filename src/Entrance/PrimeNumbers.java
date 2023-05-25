package Entrance;

public class PrimeNumbers {
    public static void main(String[] args) {
        /*** PRIME NUMBER BETWEEN 1 - 100 ***/
        // Defined Variables
        int counter = 0, primeNumber, control;

        // Loops and Output
        for (primeNumber = 2; primeNumber <= 100; primeNumber++){
            control = 0;
            for (int i = 2; i < primeNumber; i++){
                if (primeNumber % i == 0){
                    control = 1;
                    break;
                }
            }
            if (control == 0){
                System.out.print(primeNumber  + " ");
                counter++;
            }
        }
    }
}

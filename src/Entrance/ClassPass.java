package Entrance;

import java.util.Scanner;

public class ClassPass {
    public static void main(String[] args) {
        /***       PASS THE CLASS     ***/

        // Defined Variables
        int math, physics, chemistry, history, turkish, counter = 0;
        double average = 0;

        // Get input from user
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter your math note : ");
        math = input.nextInt();
        System.out.print("Please Enter your physics note : ");
        physics = input.nextInt();
        System.out.print("Please Enter your chemistry note : ");
        chemistry = input.nextInt();
        System.out.print("Please Enter your history note : ");
        history = input.nextInt();
        System.out.print("Please Enter your turkish note : ");
        turkish = input.nextInt();


        // Output
        if ((math >= 0 && math <= 100)){
            average +=math;
            counter += 1;
        }
        if ((physics >= 0 && physics <= 100)){
            average +=physics;
            counter += 1;
        }
        if ((chemistry >= 0 && chemistry <= 100)){
            average +=chemistry;
            counter += 1;
        }
        if ((history >= 0 && history <= 100)){
            average +=history;
            counter += 1;
        }
        if ((turkish >= 0 && turkish <= 100)){
            average +=turkish;
            counter += 1;
        }
        average = average / counter;

        if (average >= 55){
            System.out.println("Congratulations You Passed The Class\nYour Average Note : " + average);
        }else {
            System.out.println("Sorry You Can Not Pass The Class\nYour Average Note : " + average);
        }
        System.out.println("Correct Note : " + counter +"\nIncorrect Note : " + (5-counter));
    }
    }


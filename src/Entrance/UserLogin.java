package Entrance;

import java.util.Scanner;

public class UserLogin {
    public static void main(String[] args) {
        /***       USER LOGIN     ***/

        // Defined Variables
        String userName, password, resetPassword, fixedPassword = "java1234";
        boolean control = true;

        // Get input from user
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your user name :");
        userName = input.nextLine();

        System.out.print("Please enter your password : ");
        password = input.nextLine();



        // Output
        if (userName.equals("java-Patika") && password.equals("java1234")) {
            System.out.println("Login Successful");
        }else if (!password.equals("java1234") && !userName.equals("java-Patika")) {
            System.out.println("User not found");
        }   else if (!password.equals("java1234") && userName.equals("java-Patika")) {
                // Check-in reset current password
                System.out.println("You entered your password incorrectly. " +
                        "\nWould you like to reset your password?\n" +
                        "if you want to please write YES or you dont want to write NO ");
                resetPassword = input.nextLine();
                if (resetPassword.equals("YES")) {
                    while (control){
                        System.out.print("Please try diffrent password: ");
                        resetPassword = input.next();
                        if (resetPassword.equals(fixedPassword) || resetPassword.equals(password)){
                            System.out.printf("You can not enter your previous password!  ");
                        }else {
                            System.out.printf("Password Created");
                            control =false;
                        }
                    }
                }else if (resetPassword.equals("NO")) {
                    // If write no, you will logout of the app
                    System.out.println("Logging out ");
                    System.exit(0);
            }
        }
    }
}

package Entrance;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class AtmProject {
    public static void main(String[] args) {
        String userName, password;
        int right = 3, balance = 4500, select;

        Scanner input = new Scanner(System.in);
        while(right > 0 ){
            System.out.print("Enter Your Username : ");
            userName = input.next();
            System.out.print("Enter Your Password : ");
            password = input.next();
            if (userName.equals("patika-Dev") && password.equals("patika1234")){
                System.out.println("Welcome To The PatikaBank");
                do {
                    System.out.println("\nWelcome Again, Please Select The Action You Want To Make : ");
                    System.out.println("1 - Deposit\n" +
                            "2 - Withdraw \n" +
                            "3 - Check Balance\n" +
                            "4 - Exit  ");
                    select = input.nextInt();
                    if (select == 1) {
                        System.out.print("Balance : ");
                        int price = input.nextInt();
                        balance += price;
                    } else if (select == 2) {
                        System.out.print("Balance : ");
                        int price = input.nextInt();
                        if (price > balance) {
                            System.out.println("You Have Insufficient Balance");
                        } else {
                            balance -= price;
                        }
                    } else if (select == 3) {
                        System.out.print("Balance : " + balance);
                    }
                    }while (select != 4) ;
                    System.out.println("See You Again, Have A Great Day ");
                    break;
                }else {
                        right--;
                        System.out.println("Your Username or Password Is Not Correct Please Try Again");
                        if (right == 0){
                            System.out.println("Your Account Has Been Blocked! Please Contact Your Bank " );
                        }else {
                            System.out.println("Your Remaining Right " + right);
                        }
                    }
                }
        }
    }


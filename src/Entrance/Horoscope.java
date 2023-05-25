package Entrance;

import java.util.Scanner;

public class Horoscope {
    public static void main(String[] args) {
        // Defined Variables
        int month, day;
        // Get Input From User
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your birthday month :");
        month = input.nextInt();
        System.out.print("Ënter your birthday day : ");
        day = input.nextInt();
        // Output
        if (month == 12 && day >=22 || (month ==1 && day <=21)){
            System.out.print("January -- Capricorn");
        }
         else if (month == 1 && day >=20 || (month ==2 && day <= 20)){
            System.out.print("Februrary -- Aquarius");
        }
         else if (month == 2 && day >=20 || (month ==3 && day <= 20)){
            System.out.print("March -- Pisces");
        }
         else if (month == 3 && day >=21 || (month ==4 && day <= 20)){
            System.out.print("April -- Aries");
        }
         else if (month == 4 && day >=21 || (month ==5 && day <= 21)){
            System.out.print("May -- Taurus");
        }
         else if (month == 5 && day >=22 || (month ==6 && day <= 22)){
            System.out.print("June -- Gemini");
        }
         else if (month == 6 && day >=23 || (month ==7 && day <= 22)){
            System.out.print("July -- Cancer");
        }
         else if (month == 7 && day >=23 || (month ==8 && day <= 22)){
            System.out.print("August -- Leo");
        }
         else if (month == 8 && day >=23 || (month ==9 && day <= 22)){
            System.out.print("September -- Virgo");
        }
         else if (month == 9 && day >=23 || (month ==10 && day <= 22)){
            System.out.print("October -- Libra");
        }
         else if (month == 10 && day >=23 || (month ==11 && day <= 21)){
            System.out.print("November -- Scorpio");
        }
         else if (month == 11 && day >=22 || (month ==12 && day <= 21)){
            System.out.print("December -- Sagittarius");
        }else {
            System.out.print("Incorrectly Login");
        }

    }
}

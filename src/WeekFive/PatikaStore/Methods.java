package WeekFive.PatikaStore;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Methods {
    static Scanner input = new Scanner(System.in);
    static Map<String, Phone> phoneList = new HashMap<>();
    static Set<Map.Entry<String, Phone>> phoneDetails = phoneList.entrySet();
    static Set<java.lang.String> idNo = phoneList.keySet();

    public static void addPhone(){

        System.out.println("-".repeat(20) + "Addition Phone Page" + "-".repeat(20));

        int id = 0;
        double price = 0.0;
        String phoneName = "";
        String brandName = "";
        int storage = 0;
        double inc = 0.0;
        int camera = 0;
        int battery = 0;
        int ram = 0;
        String color = "";

        boolean validInput = false;

        while (!validInput){
            System.out.println("Please enter the id of phone you want to add");
            id = input.nextInt();
            System.out.println("Please enter the name of phone you want to add");
            phoneName = input.nextLine().trim();
            try {
                if (id >=0){
                    validInput = true;
                }else {
                    System.out.println("The id number you entered does not meet the required criteria. Please try again ");
                }
            }catch (NumberFormatException e ){
                System.out.println("You can not entered zero number. Please try again");
            }

            if (phoneName.isEmpty() || phoneName.contains(" ") || !phoneName.matches("[A-Za-z]+")){
                System.out.println("The Product Name you entered does not meet the required criteria. Please try again ");
                continue;
            }
            validInput = true;
        }

    }
    public static void listOfProducts(){
        System.out.printf("%-20s %-19s %-19s %-19s %-19s %-15s\n", "ID", "Product Name", "Brand Name", "Price", "Stock");
        System.out.println("-".repeat(120));

    }
}

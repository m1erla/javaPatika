package FinalProject.controller;

import FinalProject.Client;
import FinalProject.account.MemberAccount;
import FinalProject.bill.Invoice;
import FinalProject.exception.InsufficientBalanceException;
import FinalProject.services.InvoiceService;
import FinalProject.services.MemberAccountService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleController {
    private Invoice invoice;
    private MemberAccount memberAccount;
    private MemberAccountService memberAccountService;
    private InvoiceService invoiceService;
    private static final Scanner input = new Scanner(System.in);

    public ConsoleController(MemberAccount accountController, MemberAccountService accountServiceController, Invoice billController, InvoiceService billServiceController){
        this.memberAccount = accountController;
        this.memberAccountService = accountServiceController;
        this.invoice = billController;
        this.invoiceService = billServiceController;
    }
    public void menu() throws InsufficientBalanceException {
        String str =
                "-".repeat(20) + "Patika Invoice Payment System"+ "-".repeat(20) + "\n"
                        + "   _____________________     _______________________  \n"
                        + "   | 1-Bill Transaction |    | 2-Member Account |  \n"
                        + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯     ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯  \n"
                        + "                      __________   \n"
                        + "                      | 0-Exit |   \n"
                        + "                      ¯¯¯¯¯¯¯¯¯¯   \n"
                        +  "-".repeat(75) ;
        System.out.println(str);
        int preference = getChoice(0,4, "Please select the transaction you want to do : ");

        switch (preference){
            case 1 -> billTransaction();
            case 2 -> memberAccounts();
            case 0 -> exitSystem();
        }
    }
    private void billTransaction() throws InsufficientBalanceException {
        String str =  "---------------------------------\n" +
                "Patika Invoice Payment Bill Transactions!\n" +
                "1- List All Bills,\n" +
                "2- Bill Payment,\n" +
                "3- Bill Inquiry,\n" +
                "4- Bill Cancellation,\n" +
                "0- Back To Main Menu!\n" +
                "---------------------------------";
        System.out.println(str);
        int preference = getChoice(0,4,"Your choice: ");
        switch (preference){
            case 1 -> billList();
            case 2 -> billPayment();
            case 0 -> menu();
        }
    }
    private int getChoice(int min, int max, String message){
        int selection;
        while (true){
            System.out.println(message);
            try {
                selection = input.nextInt();
                if (selection >= min && selection <= max)
                    break;
                else System.out.println("Invalid entry");
            }catch (InputMismatchException exception){
                System.out.println(exception.getMessage());
            }
        }
        return selection;
    }
    private MemberAccount getChoice(MemberAccount memberCode, String description){
        MemberAccount selection = new MemberAccount();
        while (true){
            System.out.println(memberCode);
            try {
                selection = memberAccount.getMemberAccount();
                if (selection.equals(memberCode))
                    break;
                else System.out.println("Invalid entry");
            }catch (InputMismatchException exception){
                System.out.println(exception.getMessage());
            }
        }
        return selection;
    }
    private void exitSystem(){
        System.out.println("Exit the system!, See you next time!");
    }

    private void memberAccounts() throws InsufficientBalanceException {
        String str =  "---------------------------------\n" +
                "Patika Member Account Transactions!\n" +
                "1- List All Member Accounts,\n" +
                "2- Create a new account,\n" +
                "3- Get member account by member code,\n" +
                "4- Delete member account,\n" +
                "0- Back To Main Menu!\n" +
                "---------------------------------";
        System.out.println(str);
        int preference = getChoice(0,4,"Your choice: ");
        switch (preference){
            case 1 -> memberAccountList();
            case 2 -> createMemberAccount();
            case 3 -> getMemberAccountByCode();
            case 4 -> deleteAccount();
            case 0 -> menu();
        }
    }

    private void memberAccountList() throws InsufficientBalanceException {
        MemberAccount memberAccount = new MemberAccount();
        MemberAccountService memberAccountService1 = new MemberAccountService(memberAccount);
        System.out.println("Member Account Information: ");
        System.out.println("Id -> " + memberAccount.getId());
        System.out.println("Full Name -> " + memberAccount.getName() + " " + memberAccount.getSurname());
        System.out.println("Member Code -> " + memberAccount.getMemberCode());
        System.out.println("Balance -> " + memberAccount.getBalance());
        memberAccounts();

    }

    private void billList() throws InsufficientBalanceException {
        Invoice invoice = new Invoice();
        System.out.println("- ".repeat(20) + "BILLS" + " -".repeat(20) );
        System.out.println("Bill List: ");
        System.out.println("Bill Type -> " + invoice.getInvoiceType());
        System.out.println("Bill Amount -> " + invoice.getAmount());
        System.out.println("Bill Expiration Date -> " + invoice.getProcessDate());
        System.out.println("-".repeat(20));
        billTransaction();
    }
  private void billPayment() throws InsufficientBalanceException {
        Client client = new Client();

        double balance = memberAccount.getBalance();
        int select = 1;
        String str = "";

            System.out.println("Welcome to the bill payment! please select bill you want to pay!");
            switch (select){
                case 1: str = "TELEPHONE";
                    client.processInvoice(1,"123Jo",150.0,"04-11-2023");
                    break;
                case 2:
                    str = "WATER_BILL";
                    client.processInvoice(2,"123Jo",80.0,"04-11-2023");
                    break;
                case 3:
                    str = "INTERNET";
                    client.processInvoice(3,"123Jo",280.0,"04-11-2023");
                    break;
                default:
                    System.out.println("You should check your decision!");
                    break;
            }

  }
  public void createMemberAccount() throws InsufficientBalanceException {
      System.out.print("Please enter your id -> ");
      String id = input.nextLine().trim();

      System.out.print("Please enter your name -> ");
      String name = input.nextLine().trim();

      System.out.print("Please enter your sur name -> ");
      String surname = input.nextLine().trim();

      System.out.print("Please enter your balance -> ");
      double balance = input.nextDouble();

      System.out.print("Please enter your member code -> ");
      String memberCode = input.nextLine().trim();
      if (memberAccount.getId() != null && memberAccount.getMemberCode() != null){
          System.out.println("Id ("+ id+ ") is already exist");
      }else {
          memberAccount.setId(id);
          memberAccount.setName(name);
          memberAccount.setSurname(surname);
          memberAccount.setBalance(balance);
          memberAccount.setMemberCode(memberCode);

          System.out.println("New Member Account --> " +
                  "Id -> ("+id+") -- " +
                  "Name -> ("+name+") " +
                  "Surname -> ("+surname+") " +
                  "Balance -> ("+balance+") " +
                  "Member code -> ("+memberCode+")");
      }
      memberAccounts();

  }
  public void deleteAccount() throws InsufficientBalanceException {
      List<MemberAccount> accounts = (List<MemberAccount>) memberAccount.getMemberAccount();
      String memberCode = memberAccount.getMemberCode();
      for (MemberAccount account : accounts){
          System.out.printf("| %1$-4d| %2$-20s|%n", account.getId(), account.getName(), account.getSurname(), account.getBalance(), account.getMemberCode());
      }
      System.out.println("-".repeat(20));

      MemberAccountService memberAccount1 = null;

  }

  public void getMemberAccountByCode() throws InsufficientBalanceException {

  }

}

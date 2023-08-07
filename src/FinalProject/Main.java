package FinalProject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter invoice type (1-Telephone, 2-Internet, 3-Water Bill : )");
        int invoiceType = scanner.nextInt();

        System.out.println("Enter member code : ");
        String memberCode = scanner.next();

        System.out.println("Enter Amount : ");
        double amount = scanner.nextDouble();

        System.out.println("Enter invoice date : ");
        String processDate = scanner.next();

        client.processInvoice(invoiceType,memberCode,amount,processDate);


                // Create a MemberAccountService object
                MemberAccountService memberAccountService = new MemberAccountService();

                // Create new member accounts
                memberAccountService.createMemberAccount("456", "John", "Doe", 1000);
                memberAccountService.createMemberAccount("765", "Jane", "Smith", 1500);

                // Example usage of CRUD operations
                String code = "456Jo"; // Assuming this is a valid member code
                MemberAccount memberAccount = memberAccountService.getMemberAccountByCode(code);
                System.out.println("Enter member code : ");
                String coder = scanner.next();
                if (memberAccount != null && memberAccount.getMemberCode().equals(coder)) {
                    System.out.println("Account found!" + memberAccount.getName()+ " - " + memberAccount.getSurname());
                    System.out.println("Member Code: " + memberAccount.getMemberCode());
                    System.out.println("Balance: " + memberAccount.getBalance());

                    // Update balance
                    memberAccountService.updateMemberAccountBalance(memberCode, 1200);
                    System.out.println("Updated Balance: " + memberAccount.getBalance());

                    // Delete account
                    memberAccountService.deleteMemberAccount(memberCode);
                    System.out.println("Account deleted.");
                } else {
                    System.out.println("Account not found for the given member code.");
                }
            }
    }

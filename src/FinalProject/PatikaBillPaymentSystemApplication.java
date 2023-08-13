package FinalProject;

import FinalProject.account.MemberAccount;
import FinalProject.bill.Invoice;
import FinalProject.controller.ConsoleController;
import FinalProject.exception.InsufficientBalanceException;
import FinalProject.services.InvoiceService;
import FinalProject.services.MemberAccountService;

public class PatikaBillPaymentSystemApplication {
    public static void main(String[] args) throws InsufficientBalanceException {
//        Client client = new Client();
//        Scanner scanner = new Scanner(System.in);
//        MemberAccountService memberAccountService = new MemberAccountService();
//
//
//        System.out.println("Enter invoice type (1-Telephone, 2-Internet, 3-Water Bill : )");
//        int invoiceType = scanner.nextInt();
//
//        System.out.println("Enter member code : ");
//        String memberCode = scanner.next();
//
//        System.out.println("Enter Amount : ");
//        double amount = scanner.nextDouble();
//
//        System.out.println("Enter invoice date : ");
//        String processDate = scanner.next();
//
//        client.processInvoice(invoiceType,memberCode,amount,processDate);
//        String code = "123Jo";
//        MemberAccount memberAccount = memberAccountService.getMemberAccountByCode(code);
//        System.out.println("Enter member code : ");
//        String coder = scanner.next();
//        if (memberAccount != null && memberAccount.getMemberCode().equals(coder)) {
//            System.out.println("Account found!" + memberAccount.getName()+ " - " + memberAccount.getSurname());
//            System.out.println("Member Code: " + memberAccount.getMemberCode());
//            System.out.println("Balance: " + memberAccount.getBalance());
//
//            // Update balance
////            memberAccountService.updateMemberAccountBalance(memberCode, 1200);
//            System.out.println("Updated Balance: " + memberAccount.getBalance());
//
//            // Delete account
//            memberAccountService.deleteMemberAccount(memberCode);
//            System.out.println("Account deleted.");
//        } else {
//            System.out.println("Account not found for the given member code.");
//        }
//    }
//                // Create a MemberAccountService object
//
//
//                // Create new member accounts
////                memberAccountService.createMemberAccount("456", "John", "Doe", 1000);
////                memberAccountService.createMemberAccount("765", "Jane", "Smith", 1500);
//
//                // Example usage of CRUD operations
//               // Assuming this is a valid member code
        MemberAccount memberAccount = new MemberAccount();
        MemberAccountService memberAccountService = new MemberAccountService(memberAccount);
        InvoiceService invoiceService = new InvoiceService();
        Invoice invoice = new Invoice();
        Client client = new Client();
        ConsoleController patikaSystem = new ConsoleController(memberAccount, memberAccountService, invoice, invoiceService);
        patikaSystem.menu();


    }
}

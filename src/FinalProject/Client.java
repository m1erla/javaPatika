package FinalProject;

import FinalProject.account.MemberAccount;
import FinalProject.bill.Invoice;
import FinalProject.exception.InsufficientBalanceException;
import FinalProject.services.InvoiceService;

public class Client extends InvoiceService {
    private MemberAccount memberAccount;
    public void processInvoice(int invoiceType, String memberCode, double amount, String processDate){

        Invoice invoice = new Invoice(invoiceType, amount, processDate);
        memberAccount.setMemberCode(memberCode);
        if (memberAccount != null) {
            try {
                switch (invoiceType) {
                    case 1:
                        paymentTelephone(memberAccount, invoice);
                        break;
                    case 2:
                        paymentInternet(memberAccount, invoice);
                        break;
                    case 3:
                        paymentWaterBill(memberAccount, invoice);
                        break;
                    default:
                        System.out.println("Invalid invoice type.");
                }
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Member account not found for the given member code.");
        }
    }
    public void paymentTelephone(MemberAccount memberAccount, Invoice invoice) throws InsufficientBalanceException {
        double totalAmount = invoice.getAmount();
        payment(memberAccount, totalAmount, invoice.getProcessDate(), "Telephone", 1, memberAccount.getMemberCode());
    }

    public void paymentInternet(MemberAccount memberAccount, Invoice invoice) throws InsufficientBalanceException {
        double totalAmount = invoice.getAmount();
        payment(memberAccount, totalAmount, invoice.getProcessDate(), "Internet",2, memberAccount.getMemberCode());
    }

    public void paymentWaterBill(MemberAccount memberAccount, Invoice invoice) throws InsufficientBalanceException {
        double totalAmount = invoice.getAmount();
        payment(memberAccount, totalAmount, invoice.getProcessDate(), "Water Bill",3, memberAccount.getMemberCode());
    }
/*
public void processInvoice(int invoiceType, String memberCode, double amount, String processDate) {
        MemberAccount memberAccount = findMemberAccountByCode(memberCode);
        Invoice invoice = new Invoice(amount, processDate, invoiceType);

        if (memberAccount != null) {
            try {
                switch (invoiceType) {
                    case 1:
                        paymentTelephone(memberAccount, invoice);
                        break;
                    case 2:
                        paymentInternet(memberAccount, invoice);
                        break;
                    case 3:
                        paymentWaterBill(memberAccount, invoice);
                        break;
                    default:
                        System.out.println("Invalid invoice type.");
                }
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Member account not found for the given member code.");
        }
    }

    public void paymentTelephone(MemberAccount memberAccount, Invoice invoice) throws InsufficientBalanceException {
        double totalAmount = invoice.getAmount();
        payment(memberAccount, totalAmount, invoice.getProcessDate(), "Telephone");
    }

    public void paymentInternet(MemberAccount memberAccount, Invoice invoice) throws InsufficientBalanceException {
        double totalAmount = invoice.getAmount();
        payment(memberAccount, totalAmount, invoice.getProcessDate(), "Internet");
    }

    public void paymentWaterBill(MemberAccount memberAccount, Invoice invoice) throws InsufficientBalanceException {
        double totalAmount = invoice.getAmount();
        payment(memberAccount, totalAmount, invoice.getProcessDate(), "Water Bill");
    }


*/

}

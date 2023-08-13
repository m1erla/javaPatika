package FinalProject.services;

import FinalProject.account.MemberAccount;
import FinalProject.exception.InsufficientBalanceException;

public class InvoiceService {

    public void payment(MemberAccount memberAccount, double amount, String processDate, String billTypeDescription, int invoiceType, String memberCode) throws InsufficientBalanceException {
        if (memberAccount.getBalance() >= amount) {
            memberAccount.setBalance(memberAccount.getBalance() - amount);
            System.out.println("Payment successful for " + billTypeDescription + " bill on " + processDate + ". New balance: " + memberAccount.getBalance());
        } else {
            throw new InsufficientBalanceException("Insufficient balance in the account.");
        }
    }

    public void inquiry(MemberAccount memberAccount, double amount, String processDate, String billTypeDescription) {
        System.out.println("Invoice Inquiry for " + billTypeDescription + " bill on " + processDate + ". Amount: " + amount);
    }

    public void paymentCancellation(MemberAccount memberAccount, double amount, String processDate, String billTypeDescription, int invoiceType, String memberCode) {
        memberAccount.setBalance(memberAccount.getBalance() + amount);
        System.out.println("Payment cancellation successful for " + billTypeDescription + " bill on " + processDate + ". New balance: " + memberAccount.getBalance());
    }

}

package FinalProject;

import java.lang.reflect.Member;

public class InvoiceService {

    public void payment(MemberAccount memberAccount, Invoice invoice) throws InsufficientBalanceException{
             if (memberAccount.getBalance() >= invoice.getAmount()){
                 memberAccount.setBalance(memberAccount.getBalance());
                 System.out.println("Payment succesful for " + invoice.getProcessDate()
                         + ". New balance : " + memberAccount.getBalance() );
             }else {
                 throw new InsufficientBalanceException("Insufficient balance in the account.");
             }
    }

    public void inquiry(MemberAccount memberAccount, Invoice invoice){
        System.out.println("Invoice Inquiry : " + invoice.getProcessDate() + ". Amount : " + invoice.getAmount());

    }

    public void paymentCancellation(MemberAccount memberAccount, Invoice invoice){
        memberAccount.setBalance(memberAccount.getBalance() + invoice.getAmount());
        System.out.println("Payment cancellation successful for " + invoice.getProcessDate() + ". New balance : " + memberAccount.getBalance());
    }
}

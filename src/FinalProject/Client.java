package FinalProject;

public class Client extends InvoiceService{
    public void processInvoice(int invoiceType, String memberCode, double amount, String processDate){
        MemberAccount memberAccount = findMemberAccountByCode(memberCode);
        Invoice invoice = new Invoice(invoiceType, amount, processDate);



        if (memberAccount != null){
            try {
                switch (invoiceType){
                    case 1 :
                        payment(memberAccount, invoice);
                        break;
                    case 2:
                        payment(memberAccount, invoice);
                        break;
                    case 3:
                        payment(memberAccount, invoice);
                        break;
                    default:
                        System.out.println("Invalid invoice type.");
                }
            }catch (InsufficientBalanceException exception){
                System.out.println(exception.getMessage());
            }
        }else {
            System.out.println("Member account not found for the given member code.");
        }
    }


    private MemberAccount findMemberAccountByCode(String memberCode){
        MemberAccountService memberAccountService = new MemberAccountService();
        String code = "456Jo"; // Assuming this is a valid member code
        MemberAccount memberAccount = memberAccountService.getMemberAccountByCode(code);
        MemberAccount[] memberAccounts = {
                new MemberAccount("123", "John", "Doe", 1000),
                new MemberAccount("333", "Emma", "Stone", 4400)
        };
        for (MemberAccount account : memberAccounts){
            if (account.getMemberCode().equals(memberCode)){
                return account;
            }
        }
        return null;
    }
}

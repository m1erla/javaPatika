package FinalProject.services;

import FinalProject.account.MemberAccount;

import java.util.ArrayList;
import java.util.List;

public class MemberAccountService{
private MemberAccount memberAccount;

//    private static List<MemberAccount> memberAccounts;
//
//    public  MemberAccountService(){
//        memberAccounts = new ArrayList<>();
//    }
//    public  void addMemberAccount(MemberAccount memberAccount){
//        memberAccounts.add(memberAccount);
//    }
//
//    public static MemberAccount findByMemberCode(String memberCode){
//        for (MemberAccount account : memberAccounts){
//            if (account.getMemberCode().equals(memberCode)){
//                return account;
//            }
//        }
//        return null;
//    }
//
//    public void updateMemberAccount(MemberAccount updateMemberAccount){
//        MemberAccount existingAccount = findByMemberCode(updateMemberAccount.getMemberCode());
//        if (existingAccount == null){
//            throw  new IllegalArgumentException("Member account not found!");
//        }
//        // update account details
//
//        existingAccount.setId(updateMemberAccount.getId());
//        existingAccount.setName(updateMemberAccount.getName());
//        existingAccount.setBalance(updateMemberAccount.getBalance());
//    }
//
//    public void deleteMemberAccount(String memberCode){
//        MemberAccount accountDelete = findByMemberCode(memberCode);
//        if (accountDelete == null){
//            throw new IllegalArgumentException("Member account not found!");
//        }
//        // delete account
//        memberAccounts.remove(accountDelete);
//    }


        private static List<MemberAccount> memberAccounts;

        public MemberAccountService(MemberAccount memberAccount) {
            memberAccounts = new ArrayList<>();
            this.memberAccount = memberAccount;
            defaultMemberAccounts();
        }

        // Create a new member account
        public void createMemberAccount(String id, String name, String surname,String memberCode ,double balance) {
            System.out.println("-".repeat(20) + "Welcome to the create member account service!" + "-".repeat(20));

            MemberAccount newMember = new MemberAccount(id, name, surname, memberCode, balance);
            memberAccounts.add(newMember);
            System.out.println("New Member Account added!");
        }

        // Read member account by member code
        public MemberAccount getMemberAccountByCode(String memberCode) {
            for (MemberAccount account : memberAccounts) {
                if (account.getMemberCode().equals(memberCode)) {
                    return account;
                }
            }
            return null;
        }

        // Update member account balance
        public void updateMemberAccountBalance(MemberAccount updateMemberAccount) {
            MemberAccount account = getMemberAccountByCode(updateMemberAccount.getMemberCode());
            if (account != null) {
                account.setId(updateMemberAccount.getId());
                account.setName(updateMemberAccount.getName());
                account.setSurname(updateMemberAccount.getSurname());
                account.setBalance(updateMemberAccount.getBalance());
                System.out.println("Member account has been updated!");
            } else {
                System.out.println("Member account not found.");
            }
        }

        // Delete member account by member code
        public void deleteMemberAccount(String memberCode) {
            MemberAccount account = getMemberAccountByCode(memberCode);
            if (account != null) {
                memberAccounts.remove(account);
            } else {
                System.out.println("Member account not found for the given member code.");
            }
        }
    public static MemberAccount findMemberAccountByCode(String memberCode){
        // Assuming this is a valid member code
        MemberAccount memberAccount = new MemberAccount();
        memberAccount.getMemberCode();
        String memberCode1 = memberAccount.getId() + memberAccount.getMemberCode();
        for (MemberAccount account : memberAccounts){
            if (account.getMemberCode().equals(memberCode1)){
                return account;
            }
        }
        return null;
    }
  private void defaultMemberAccounts(){
      memberAccounts.add(new MemberAccount("123", "John", "Doe", "123Jo",1000));
      memberAccounts.add(new MemberAccount("456", "Jane", "Smith", "456Ja",1500));
      memberAccounts.add(new MemberAccount("321","Emma","Stone","321Em",3500));
  }
}

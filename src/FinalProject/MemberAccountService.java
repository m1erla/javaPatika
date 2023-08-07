package FinalProject;

import java.util.ArrayList;
import java.util.List;

public class MemberAccountService {
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


        private List<MemberAccount> memberAccounts;

        public MemberAccountService() {
            memberAccounts = new ArrayList<>();
        }

        // Create a new member account
        public void createMemberAccount(String id, String name, String surname, double balance) {
            MemberAccount newMember = new MemberAccount(id, name, surname, balance);
            memberAccounts.add(newMember);
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
        public void updateMemberAccountBalance(String memberCode, double newBalance) {
            MemberAccount account = getMemberAccountByCode(memberCode);
            if (account != null) {
                account.setBalance(newBalance);
            } else {
                System.out.println("Member account not found for the given member code.");
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
}

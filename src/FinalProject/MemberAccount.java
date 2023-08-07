package FinalProject;



public class MemberAccount {
    private String id;
    private String name;
    private String surname;
    private String memberCode;
    private double balance;

    public MemberAccount(String id, String name,String surname, double balance){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.memberCode = id + name.substring(0,2).toUpperCase();
        this.balance= balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

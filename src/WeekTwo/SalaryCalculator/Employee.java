package WeekTwo.SalaryCalculator;

public class Employee {
    
    // Defined Attributes
    String name;
    double salary;
    int workHours;
    int hireYear;
    double totalAmountSalary;
    double increaseSalary;
    double includeSalary;
    
    // Create Instance
    public Employee(String name, double salary, int workHours, int hireYear){
         this.name = name;
         this.salary = salary;
         this.hireYear = hireYear;
         this.workHours = workHours;
         this.totalAmountSalary = 0;
         this.increaseSalary = 0;
         this.includeSalary = 0;
    }
    
    // Defined Methods
    public double tax(){
        if (salary > 1000 ){
            return salary * 0.03;
        }else {
            return 0;
        }
    }
    public double bonus(){
        if (workHours > 40){
            int extraSalary = workHours - 40;
            return extraSalary * 30;
        }else
            return 0;
    }
    public void raiseSalary(){
        if (2023 - hireYear < 10)
            this.increaseSalary = (this.salary * 0.05);
        if (2023 - hireYear >= 10 && 2023 - this.hireYear < 20)
            this.increaseSalary = (this.salary * 0.10);
        if (2023 - hireYear >= 20)
            this.increaseSalary = (this.salary * 0.15);
        totalAmountSalary = (salary + bonus() + increaseSalary - tax());
        includeSalary = salary + bonus() - tax();
    }

    // For Output
    public String toString(){
        return  " Name : " + this.name +
                "\n Salary : " + salary + "$"+
                "\n Weekly Working Hour : " + workHours + " hours a week"+
                "\n Hire Year :  " + hireYear +
                "\n Tax : " + tax() + "$"+
                "\n Bonus Fee : " + bonus()  + "$"+
                "\n Raise Salary : " + increaseSalary + "$"+
                "\n Salary Including Tax And Bonus Fee : " +  includeSalary +"$"+
                "\n Total Amount Salary : " + totalAmountSalary + "$";
    }
}

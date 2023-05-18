package WeekTwo.SalaryCalculator;

public class Main {
    public static void main(String[] args) {
        // Defined New Object
        Employee worker = new Employee("Tom Hardy ", 5600, 45, 1992);

        worker.raiseSalary();
        // Output Coming From Employee Class
        System.out.println(worker.toString());
    }
}

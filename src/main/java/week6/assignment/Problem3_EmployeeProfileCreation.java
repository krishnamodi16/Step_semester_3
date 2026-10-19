package week6.assignment;

class Employee {
    private int empId;
    private String empName;
    private double salary;
    private boolean isIntern;

    public Employee(int empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public Employee(int empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.printf("ID: %d | Name: %s | Salary: %.2f | Intern: %b%n",
                empId, empName, salary, isIntern);
    }
}

public class Problem3_EmployeeProfileCreation {
    public static void main(String[] args) {
        Employee fullTime = new Employee(101, "Rohit", 45000);
        Employee intern = new Employee(102, "Meena");

        fullTime.printProfile();
        intern.printProfile();
    }
}

package week6.assignment;

class CompanyEmployee {
    private String empName;
    private double salary;
    static String companyName = "Tech Solutions";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public void printEmployee() {
        System.out.printf("Employee: %s | Salary: %.2f%n", empName, salary);
    }

    public static void printCompanyInfo() {
        System.out.println("Company: " + companyName);
        System.out.println("Employees created: " + employeeCount);
    }
}

public class Problem5_EmployeeAndCompanyInformationManagement {
    public static void main(String[] args) {
        CompanyEmployee e1 = new CompanyEmployee("Aisha", 42000);
        CompanyEmployee e2 = new CompanyEmployee("Rohit", 46000);
        CompanyEmployee e3 = new CompanyEmployee("Meena", 44000);

        e1.printEmployee();
        e2.printEmployee();
        e3.printEmployee();
        CompanyEmployee.printCompanyInfo();
    }
}

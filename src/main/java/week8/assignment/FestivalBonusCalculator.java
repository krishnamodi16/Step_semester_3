import java.util.*;

abstract class Employee {
    String name; double salary;
    Employee(String name, double salary) { this.name = name; this.salary = salary; }
    abstract double bonus();
}
class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) { super(name, salary); }
    double bonus() { return salary * 0.10; }
}
class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) { super(name, salary); }
    double bonus() { return salary * 0.05; }
}
class InternEmployee extends Employee {
    InternEmployee(String name, double salary) { super(name, salary); }
    double bonus() { return 2000; }
}
public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String name = p[1]; double salary = Double.parseDouble(p[2]);
            switch (p[0]) {
                case "FULLTIME": employees.add(new FullTimeEmployee(name, salary)); break;
                case "PARTTIME": employees.add(new PartTimeEmployee(name, salary)); break;
                case "INTERN": employees.add(new InternEmployee(name, salary)); break;
                default: throw new IllegalArgumentException("Unknown employee type");
            }
        }
        double total = 0;
        for (Employee e : employees) {
            double b = e.bonus();
            System.out.printf("%s: %.2f%n", e.name, b); total += b;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}

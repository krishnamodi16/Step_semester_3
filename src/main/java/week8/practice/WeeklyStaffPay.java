import java.util.*;

abstract class StaffMember {
    String name;
    StaffMember(String name) { this.name = name; }
    abstract double pay();
}
class FullTimeStaff extends StaffMember {
    double salary;
    FullTimeStaff(String name, double salary) { super(name); this.salary = salary; }
    double pay() { return salary; }
}
class HourlyStaff extends StaffMember {
    double hours, rate;
    HourlyStaff(String name, double hours, double rate) { super(name); this.hours = hours; this.rate = rate; }
    double pay() { return Math.min(hours, 40) * rate + Math.max(0, hours - 40) * rate * 1.5; }
}
class InternStaff extends StaffMember {
    double stipend;
    InternStaff(String name, double stipend) { super(name); this.stipend = stipend; }
    double pay() { return stipend; }
}
public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<StaffMember> staff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            switch (p[0]) {
                case "FULLTIME": staff.add(new FullTimeStaff(p[1], Double.parseDouble(p[2]))); break;
                case "HOURLY": staff.add(new HourlyStaff(p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3]))); break;
                case "INTERN": staff.add(new InternStaff(p[1], Double.parseDouble(p[2]))); break;
                default: throw new IllegalArgumentException("Unknown staff type");
            }
        }
        double total = 0;
        for (StaffMember s : staff) {
            double amount = s.pay();
            System.out.printf("%s: %.2f%n", s.name, amount);
            total += amount;
        }
        System.out.printf("Total Payroll: %.2f%n", total);
    }
}

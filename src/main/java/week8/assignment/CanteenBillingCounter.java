import java.util.*;

abstract class CustomerBill {
    double amount;
    CustomerBill(double amount) { this.amount = amount; }
    abstract double finalAmount();
}
class StudentBill extends CustomerBill {
    StudentBill(double amount) { super(amount); }
    double finalAmount() { return amount * 0.90; }
}
class StaffBill extends CustomerBill {
    StaffBill(double amount) { super(amount); }
    double finalAmount() { return amount * 0.95; }
}
class GuestBill extends CustomerBill {
    GuestBill(double amount) { super(amount); }
    double finalAmount() { return amount + 10; }
}
public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<CustomerBill> bills = new ArrayList<>();
        List<String> types = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            types.add(p[0]);
            double a = Double.parseDouble(p[1]);
            switch (p[0]) {
                case "STUDENT": bills.add(new StudentBill(a)); break;
                case "STAFF": bills.add(new StaffBill(a)); break;
                case "GUEST": bills.add(new GuestBill(a)); break;
                default: throw new IllegalArgumentException("Unknown customer type");
            }
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double a = bills.get(i).finalAmount();
            System.out.printf("%s: %.2f%n", types.get(i), a);
            total += a;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

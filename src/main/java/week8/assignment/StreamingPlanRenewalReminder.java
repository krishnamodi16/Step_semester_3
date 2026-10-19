import java.util.*;
import java.time.LocalDate;

abstract class SubscriptionPlan {
    String name; LocalDate startDate;
    SubscriptionPlan(String name, LocalDate startDate) { this.name = name; this.startDate = startDate; }
    abstract int validityDays();
    LocalDate renewalDate() { return startDate.plusDays(validityDays()); }
}
class BasicPlan extends SubscriptionPlan {
    BasicPlan(String name, LocalDate date) { super(name, date); }
    int validityDays() { return 30; }
}
class StandardPlan extends SubscriptionPlan {
    StandardPlan(String name, LocalDate date) { super(name, date); }
    int validityDays() { return 90; }
}
class PremiumPlan extends SubscriptionPlan {
    PremiumPlan(String name, LocalDate date) { super(name, date); }
    int validityDays() { return 365; }
}
public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<SubscriptionPlan> plans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            LocalDate d = LocalDate.parse(p[2]);
            switch (p[0]) {
                case "BASIC": plans.add(new BasicPlan(p[1], d)); break;
                case "STANDARD": plans.add(new StandardPlan(p[1], d)); break;
                case "PREMIUM": plans.add(new PremiumPlan(p[1], d)); break;
                default: throw new IllegalArgumentException("Unknown plan type");
            }
        }
        for (SubscriptionPlan p : plans)
            System.out.printf("%s: %s%n", p.name, p.renewalDate());
    }
}

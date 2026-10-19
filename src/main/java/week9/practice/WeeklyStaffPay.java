package week9.practice;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 2: Weekly Staff Pay
 * Staff is abstract, so a generic staff member with no pay rule can never be created.
 * Every subclass is forced to define calculatePay().
 */
public class WeeklyStaffPay {

    static abstract class Staff {
        private final String name;

        Staff(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        abstract double calculatePay();
    }

    static class FullTimeStaff extends Staff {
        private final double weeklySalary;

        FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        double calculatePay() { return weeklySalary; }
    }

    static class HourlyStaff extends Staff {
        private static final double REGULAR_HOURS = 40;
        private static final double OVERTIME_MULTIPLIER = 1.5;

        private final double hours, rate;

        HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        double calculatePay() {
            if (hours <= REGULAR_HOURS) {
                return hours * rate;
            }
            double overtimeHours = hours - REGULAR_HOURS;
            return REGULAR_HOURS * rate + overtimeHours * rate * OVERTIME_MULTIPLIER;
        }
    }

    static class InternStaff extends Staff {
        private final double stipend;

        InternStaff(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        double calculatePay() { return stipend; }
    }

    static Staff createStaff(String[] p) {
        switch (p[0].toUpperCase()) {
            case "FULLTIME":
                return new FullTimeStaff(p[1], Double.parseDouble(p[2]));
            case "HOURLY":
                return new HourlyStaff(p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3]));
            case "INTERN":
                return new InternStaff(p[1], Double.parseDouble(p[2]));
            default:
                throw new IllegalArgumentException("Unknown staff type: " + p[0]);
        }
    }

    static String readLine(Scanner sc) {
        String line = sc.nextLine().trim();
        while (line.isEmpty()) {
            line = sc.nextLine().trim();
        }
        return line;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(readLine(sc));
        double total = 0;

        for (int i = 0; i < n; i++) {
            Staff staff = createStaff(readLine(sc).split("\\s+"));
            double pay = staff.calculatePay();
            System.out.printf(Locale.US, "%s: %.2f%n", staff.getName(), pay);
            total += pay;
        }
        System.out.printf(Locale.US, "Total Payroll: %.2f%n", total);
    }
}

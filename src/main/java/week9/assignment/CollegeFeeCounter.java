package week9.assignment;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 3: College Fee Counter
 * Student (abstract) has a name and a tuition rule.
 * UsesCollegeBus (interface) marks students who use the bus and holds the transport fee
 * in ONE place. The counter asks "is this student a bus user?" through the interface,
 * not by checking the student type by name.
 */
public class CollegeFeeCounter {

    interface UsesCollegeBus {
        double TRANSPORT_FEE = 12000;

        default double transportFee() {
            return TRANSPORT_FEE;
        }
    }

    static abstract class Student {
        static final double NORMAL_TUITION = 40000;

        private final String name;

        Student(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        abstract double tuition();

        // Extra charges other than tuition and transport (hostel fee, etc.)
        double extraCharges() {
            return 0;
        }

        double baseFee() {
            return tuition() + extraCharges();
        }
    }

    static class DayScholar extends Student implements UsesCollegeBus {
        DayScholar(String name) {
            super(name);
        }

        double tuition() { return NORMAL_TUITION; }
    }

    static class Hosteller extends Student {
        private static final double HOSTEL_FEE = 60000;

        Hosteller(String name) {
            super(name);
        }

        double tuition() { return NORMAL_TUITION; }

        @Override
        double extraCharges() { return HOSTEL_FEE; }
    }

    static class ScholarshipStudent extends Student implements UsesCollegeBus {
        ScholarshipStudent(String name) {
            super(name);
        }

        double tuition() { return NORMAL_TUITION / 2; }
    }

    static Student createStudent(String[] p) {
        switch (p[0].toUpperCase()) {
            case "DAY_SCHOLAR":
                return new DayScholar(p[1]);
            case "HOSTELLER":
                return new Hosteller(p[1]);
            case "SCHOLAR":
                return new ScholarshipStudent(p[1]);
            default:
                throw new IllegalArgumentException("Unknown student type: " + p[0]);
        }
    }

    static double totalFee(Student s) {
        double fee = s.baseFee();
        if (s instanceof UsesCollegeBus) {
            fee += ((UsesCollegeBus) s).transportFee();
        }
        return fee;
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
            Student s = createStudent(readLine(sc).split("\\s+"));
            double fee = totalFee(s);
            System.out.printf(Locale.US, "%s: %.2f%n", s.getName(), fee);
            total += fee;
        }
        System.out.printf(Locale.US, "Total Collected: %.2f%n", total);
    }
}

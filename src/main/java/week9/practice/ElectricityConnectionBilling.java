package week9.practice;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 4: Electricity Connection Billing
 * Connection holds the shared "units" property and declares an abstract calculateBill().
 */
public class ElectricityConnectionBilling {

    static abstract class Connection {
        protected final double units;

        Connection(double units) {
            this.units = units;
        }

        abstract String type();

        abstract double calculateBill();
    }

    static class HomeConnection extends Connection {
        private static final double FIRST_SLAB_UNITS = 100;
        private static final double FIRST_SLAB_RATE = 5;
        private static final double NEXT_SLAB_RATE = 7;

        HomeConnection(double units) {
            super(units);
        }

        String type() { return "HOME"; }

        double calculateBill() {
            if (units <= FIRST_SLAB_UNITS) {
                return units * FIRST_SLAB_RATE;
            }
            return FIRST_SLAB_UNITS * FIRST_SLAB_RATE + (units - FIRST_SLAB_UNITS) * NEXT_SLAB_RATE;
        }
    }

    static class ShopConnection extends Connection {
        private static final double RATE = 8;
        private static final double FIXED_CHARGE = 100;

        ShopConnection(double units) {
            super(units);
        }

        String type() { return "SHOP"; }

        double calculateBill() { return units * RATE + FIXED_CHARGE; }
    }

    static class FactoryConnection extends Connection {
        private static final double RATE = 6;
        private static final double MINIMUM_BILL = 1000;

        FactoryConnection(double units) {
            super(units);
        }

        String type() { return "FACTORY"; }

        double calculateBill() { return Math.max(units * RATE, MINIMUM_BILL); }
    }

    static Connection createConnection(String[] p) {
        double units = Double.parseDouble(p[1]);
        switch (p[0].toUpperCase()) {
            case "HOME":
                return new HomeConnection(units);
            case "SHOP":
                return new ShopConnection(units);
            case "FACTORY":
                return new FactoryConnection(units);
            default:
                throw new IllegalArgumentException("Unknown connection type: " + p[0]);
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
            Connection c = createConnection(readLine(sc).split("\\s+"));
            double bill = c.calculateBill();
            System.out.printf(Locale.US, "%s: %.2f%n", c.type(), bill);
            total += bill;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}

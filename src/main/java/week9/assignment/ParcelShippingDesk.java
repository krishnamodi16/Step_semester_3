package week9.assignment;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 2: Parcel Shipping Desk
 * "How much does shipping cost?" is answered by every parcel -> abstract method in Parcel.
 * "Can it be insured?" is only for some parcels -> separate Insurable interface.
 * Standard parcels do not implement Insurable, so making another type insurable later
 * never touches the parcel types that are not insured.
 */
public class ParcelShippingDesk {

    interface Insurable {
        double INSURANCE_RATE = 0.02;

        double getDeclaredValue();

        default double insurance() {
            return getDeclaredValue() * INSURANCE_RATE;
        }
    }

    static abstract class Parcel {
        protected final double weightKg;
        private final double declaredValue;

        Parcel(double weightKg, double declaredValue) {
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        public double getDeclaredValue() {
            return declaredValue;
        }

        abstract String type();

        abstract double shippingCharge();
    }

    static class StandardParcel extends Parcel {
        static final double BASE = 40;
        static final double PER_KG = 10;

        StandardParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        String type() { return "STANDARD"; }

        double shippingCharge() { return BASE + PER_KG * weightKg; }
    }

    static class ExpressParcel extends Parcel implements Insurable {
        ExpressParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        String type() { return "EXPRESS"; }

        double shippingCharge() { return 80 + 15 * weightKg; }
    }

    static class FragileParcel extends Parcel implements Insurable {
        private static final double HANDLING_FEE = 50;

        FragileParcel(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        String type() { return "FRAGILE"; }

        // Standard charge plus handling fee
        double shippingCharge() {
            return StandardParcel.BASE + StandardParcel.PER_KG * weightKg + HANDLING_FEE;
        }
    }

    static Parcel createParcel(String[] p) {
        double weight = Double.parseDouble(p[1]);
        double value = Double.parseDouble(p[2]);
        switch (p[0].toUpperCase()) {
            case "STANDARD":
                return new StandardParcel(weight, value);
            case "EXPRESS":
                return new ExpressParcel(weight, value);
            case "FRAGILE":
                return new FragileParcel(weight, value);
            default:
                throw new IllegalArgumentException("Unknown parcel type: " + p[0]);
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
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            Parcel parcel = createParcel(readLine(sc).split("\\s+"));
            double charge = parcel.shippingCharge();
            double insurance = 0;
            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel).insurance();
            }
            double total = charge + insurance;
            System.out.printf(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.type(), charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
    }
}

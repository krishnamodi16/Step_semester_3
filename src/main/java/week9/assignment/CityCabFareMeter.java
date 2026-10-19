package week9.assignment;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 4: City Cab Fare Meter
 * Cab (abstract) holds the shared minimum-fare rule.
 * NightService (interface) represents the ability to run night trips; only Sedan and SUV
 * implement it, so a Mini can never be given a night fare.
 */
public class CityCabFareMeter {

    interface NightService {
        double NIGHT_SURCHARGE = 0.20;

        default double nightFare(double dayFare) {
            return dayFare * (1 + NIGHT_SURCHARGE);
        }
    }

    static abstract class Cab {
        // The single place where the minimum fare is written
        static final double MINIMUM_FARE = 100;

        abstract String type();

        abstract double ratePerKm();

        double dayFare(double km) {
            return Math.max(km * ratePerKm(), MINIMUM_FARE);
        }
    }

    static class MiniCab extends Cab {
        String type() { return "MINI"; }

        double ratePerKm() { return 10; }
    }

    static class SedanCab extends Cab implements NightService {
        String type() { return "SEDAN"; }

        double ratePerKm() { return 14; }
    }

    static class SuvCab extends Cab implements NightService {
        String type() { return "SUV"; }

        double ratePerKm() { return 18; }
    }

    static Cab createCab(String type) {
        switch (type.toUpperCase()) {
            case "MINI":
                return new MiniCab();
            case "SEDAN":
                return new SedanCab();
            case "SUV":
                return new SuvCab();
            default:
                throw new IllegalArgumentException("Unknown cab type: " + type);
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
            String[] p = readLine(sc).split("\\s+");
            Cab cab = createCab(p[0]);
            double km = Double.parseDouble(p[1]);
            boolean night = p[2].equalsIgnoreCase("NIGHT");

            double fare = cab.dayFare(km);
            if (night) {
                if (cab instanceof NightService) {
                    fare = ((NightService) cab).nightFare(fare);
                } else {
                    System.out.println(cab.type() + ": night service not available");
                    continue;
                }
            }
            System.out.printf(Locale.US, "%s: %.2f%n", cab.type(), fare);
            total += fare;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}

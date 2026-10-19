package week9.assignment;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 5: Home Appliance Energy Report
 * Appliance (abstract) shares the units calculation, driven by each appliance's power rating.
 * SaverMode (interface) is only implemented by the AC and the Washer, so the report can ask
 * "does this appliance support saver mode?" with a single instanceof check.
 */
public class HomeApplianceEnergyReport {

    static final double COST_PER_UNIT = 8;

    interface SaverMode {
        double SAVER_REDUCTION = 0.25;

        default double saverUnits(double normalUnits) {
            return normalUnits * (1 - SAVER_REDUCTION);
        }
    }

    static abstract class Appliance {
        abstract String name();

        abstract double powerWatts();

        double units(double hours) {
            return powerWatts() * hours / 1000;
        }
    }

    static class Fridge extends Appliance {
        String name() { return "FRIDGE"; }

        double powerWatts() { return 150; }
    }

    static class AirConditioner extends Appliance implements SaverMode {
        String name() { return "AC"; }

        double powerWatts() { return 1500; }
    }

    static class Tv extends Appliance {
        String name() { return "TV"; }

        double powerWatts() { return 100; }
    }

    static class WashingMachine extends Appliance implements SaverMode {
        String name() { return "WASHER"; }

        double powerWatts() { return 500; }
    }

    static Appliance createAppliance(String name) {
        switch (name.toUpperCase()) {
            case "FRIDGE":
                return new Fridge();
            case "AC":
                return new AirConditioner();
            case "TV":
                return new Tv();
            case "WASHER":
                return new WashingMachine();
            default:
                throw new IllegalArgumentException("Unknown appliance: " + name);
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
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] p = readLine(sc).split("\\s+");
            Appliance appliance = createAppliance(p[0]);
            double hours = Double.parseDouble(p[1]);
            boolean saverRequested = p.length > 2 && p[2].equalsIgnoreCase("SAVER");

            double units = appliance.units(hours);
            if (saverRequested) {
                if (appliance instanceof SaverMode) {
                    units = ((SaverMode) appliance).saverUnits(units);
                } else {
                    System.out.println(appliance.name() + ": saver mode not supported");
                    continue;
                }
            }
            double cost = units * COST_PER_UNIT;
            System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", appliance.name(), units, cost);
            totalCost += cost;
        }
        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
    }
}

package week9.practice;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 5: Travel Booking with a Common Fee
 * The booking fee lives in ONE place (Booking.BOOKING_FEE). Subclasses only define baseFare().
 * If the fee changes, only that one line changes.
 */
public class TravelBookingCommonFee {

    static abstract class Booking {
        // The single place where the booking fee is written
        static final double BOOKING_FEE = 50;

        protected final double distanceKm;

        Booking(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        abstract String mode();

        abstract double baseFare();

        // Shared logic: every booking adds the same fee
        double totalFare() {
            return baseFare() + BOOKING_FEE;
        }
    }

    static class BusBooking extends Booking {
        BusBooking(double distanceKm) {
            super(distanceKm);
        }

        String mode() { return "BUS"; }

        double baseFare() { return 2 * distanceKm; }
    }

    static class TrainBooking extends Booking {
        TrainBooking(double distanceKm) {
            super(distanceKm);
        }

        String mode() { return "TRAIN"; }

        double baseFare() { return 1.5 * distanceKm; }
    }

    static class FlightBooking extends Booking {
        FlightBooking(double distanceKm) {
            super(distanceKm);
        }

        String mode() { return "FLIGHT"; }

        double baseFare() { return 2500 + 4 * distanceKm; }
    }

    static Booking createBooking(String[] p) {
        double km = Double.parseDouble(p[1]);
        switch (p[0].toUpperCase()) {
            case "BUS":
                return new BusBooking(km);
            case "TRAIN":
                return new TrainBooking(km);
            case "FLIGHT":
                return new FlightBooking(km);
            default:
                throw new IllegalArgumentException("Unknown mode: " + p[0]);
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

        for (int i = 0; i < n; i++) {
            Booking b = createBooking(readLine(sc).split("\\s+"));
            System.out.printf(Locale.US, "%s: %.2f%n", b.mode(), b.totalFare());
        }
    }
}

package week9.assignment;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 1: Movie Ticket Counter
 * Ticket is abstract (a plain ticket can never be sold). The convenience fee and the
 * amount calculation are written once in Ticket; subclasses only supply the seat price.
 */
public class MovieTicketCounter {

    static abstract class Ticket {
        // The single place where the convenience fee is written
        static final double CONVENIENCE_FEE = 20;

        private final int count;

        Ticket(int count) {
            this.count = count;
        }

        abstract String seatType();

        abstract double pricePerTicket();

        double amount() {
            return count * (pricePerTicket() + CONVENIENCE_FEE);
        }
    }

    static class RegularTicket extends Ticket {
        RegularTicket(int count) {
            super(count);
        }

        String seatType() { return "REGULAR"; }

        double pricePerTicket() { return 150; }
    }

    static class PremiumTicket extends Ticket {
        PremiumTicket(int count) {
            super(count);
        }

        String seatType() { return "PREMIUM"; }

        double pricePerTicket() { return 250; }
    }

    static class ReclinerTicket extends Ticket {
        ReclinerTicket(int count) {
            super(count);
        }

        String seatType() { return "RECLINER"; }

        double pricePerTicket() { return 400; }
    }

    static Ticket createTicket(String[] p) {
        int count = Integer.parseInt(p[1]);
        switch (p[0].toUpperCase()) {
            case "REGULAR":
                return new RegularTicket(count);
            case "PREMIUM":
                return new PremiumTicket(count);
            case "RECLINER":
                return new ReclinerTicket(count);
            default:
                throw new IllegalArgumentException("Unknown seat type: " + p[0]);
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
            Ticket t = createTicket(readLine(sc).split("\\s+"));
            System.out.printf(Locale.US, "%s: %.2f%n", t.seatType(), t.amount());
            total += t.amount();
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}

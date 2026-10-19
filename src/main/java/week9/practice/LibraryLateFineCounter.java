package week9.practice;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 3: Library Late Fine Counter
 * LibraryItem mandates a calculateFine() method; each item type supplies its own rule.
 */
public class LibraryLateFineCounter {

    static abstract class LibraryItem {
        private final String title;
        protected final int daysLate;

        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        String getTitle() {
            return title;
        }

        abstract double calculateFine();
    }

    static class Book extends LibraryItem {
        private static final double FINE_PER_DAY = 2;

        Book(String title, int daysLate) {
            super(title, daysLate);
        }

        double calculateFine() { return daysLate * FINE_PER_DAY; }
    }

    static class Dvd extends LibraryItem {
        private static final double FINE_PER_DAY = 5;
        private static final double MAX_FINE = 50;

        Dvd(String title, int daysLate) {
            super(title, daysLate);
        }

        double calculateFine() { return Math.min(daysLate * FINE_PER_DAY, MAX_FINE); }
    }

    static class Magazine extends LibraryItem {
        private static final double FINE_PER_DAY = 1;

        Magazine(String title, int daysLate) {
            super(title, daysLate);
        }

        double calculateFine() { return daysLate * FINE_PER_DAY; }
    }

    static LibraryItem createItem(String[] p) {
        int daysLate = Integer.parseInt(p[2]);
        switch (p[0].toUpperCase()) {
            case "BOOK":
                return new Book(p[1], daysLate);
            case "DVD":
                return new Dvd(p[1], daysLate);
            case "MAGAZINE":
                return new Magazine(p[1], daysLate);
            default:
                throw new IllegalArgumentException("Unknown item type: " + p[0]);
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
            LibraryItem item = createItem(readLine(sc).split("\\s+"));
            double fine = item.calculateFine();
            System.out.printf(Locale.US, "%s: %.2f%n", item.getTitle(), fine);
            total += fine;
        }
        System.out.printf(Locale.US, "Total Fines: %.2f%n", total);
    }
}

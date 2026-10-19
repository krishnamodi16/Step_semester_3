package week9.practice;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 1: Garden Plot Area Report
 * Abstract base class Plot holds the shared owner; each shape supplies its own area.
 * The report loop only talks to Plot, so a new shape never changes the report code.
 */
public class GardenPlotAreaReport {

    static abstract class Plot {
        private final String owner;

        Plot(String owner) {
            this.owner = owner;
        }

        String getOwner() {
            return owner;
        }

        abstract String shape();

        abstract double area();
    }

    static class CirclePlot extends Plot {
        private final double radius;

        CirclePlot(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        String shape() { return "CIRCLE"; }

        double area() { return Math.PI * radius * radius; }
    }

    static class RectanglePlot extends Plot {
        private final double length, width;

        RectanglePlot(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        String shape() { return "RECTANGLE"; }

        double area() { return length * width; }
    }

    static class TrianglePlot extends Plot {
        private final double base, height;

        TrianglePlot(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        String shape() { return "TRIANGLE"; }

        double area() { return 0.5 * base * height; }
    }

    static Plot createPlot(String[] p) {
        switch (p[0].toUpperCase()) {
            case "CIRCLE":
                return new CirclePlot(p[1], Double.parseDouble(p[2]));
            case "RECTANGLE":
                return new RectanglePlot(p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3]));
            case "TRIANGLE":
                return new TrianglePlot(p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3]));
            default:
                throw new IllegalArgumentException("Unknown shape: " + p[0]);
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
            Plot plot = createPlot(readLine(sc).split("\\s+"));
            System.out.printf(Locale.US, "%s (%s): %.2f%n", plot.getOwner(), plot.shape(), plot.area());
            total += plot.area();
        }
        System.out.printf(Locale.US, "Total Area: %.2f%n", total);
    }
}

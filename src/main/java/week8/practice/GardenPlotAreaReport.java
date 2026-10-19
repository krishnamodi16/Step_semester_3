import java.util.*;

abstract class Plot {
    String owner;
    Plot(String owner) { this.owner = owner; }
    abstract double area();
    abstract String shape();
}
class CirclePlot extends Plot {
    double radius;
    CirclePlot(String owner, double radius) { super(owner); this.radius = radius; }
    double area() { return Math.PI * radius * radius; }
    String shape() { return "CIRCLE"; }
}
class RectanglePlot extends Plot {
    double length, width;
    RectanglePlot(String owner, double length, double width) {
        super(owner); this.length = length; this.width = width;
    }
    double area() { return length * width; }
    String shape() { return "RECTANGLE"; }
}
class TrianglePlot extends Plot {
    double base, height;
    TrianglePlot(String owner, double base, double height) {
        super(owner); this.base = base; this.height = height;
    }
    double area() { return 0.5 * base * height; }
    String shape() { return "TRIANGLE"; }
}
public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            switch (p[0]) {
                case "CIRCLE": plots.add(new CirclePlot(p[1], Double.parseDouble(p[2]))); break;
                case "RECTANGLE": plots.add(new RectanglePlot(p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3]))); break;
                case "TRIANGLE": plots.add(new TrianglePlot(p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3]))); break;
                default: throw new IllegalArgumentException("Unknown plot type");
            }
        }
        double total = 0;
        for (Plot p : plots) {
            double a = p.area();
            System.out.printf("%s (%s): %.2f%n", p.owner, p.shape(), a);
            total += a;
        }
        System.out.printf("Total Area: %.2f%n", total);
    }
}

import java.util.*;

abstract class Connection {
    double units;
    Connection(double units) { this.units = units; }
    abstract double bill();
}
class HomeConnection extends Connection {
    HomeConnection(double units) { super(units); }
    double bill() { return Math.min(units, 100) * 5 + Math.max(0, units - 100) * 7; }
}
class ShopConnection extends Connection {
    ShopConnection(double units) { super(units); }
    double bill() { return units * 8 + 100; }
}
class FactoryConnection extends Connection {
    FactoryConnection(double units) { super(units); }
    double bill() { return Math.max(units * 6, 1000); }
}
public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Connection> connections = new ArrayList<>();
        List<String> types = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            double units = Double.parseDouble(p[1]);
            types.add(p[0]);
            switch (p[0]) {
                case "HOME": connections.add(new HomeConnection(units)); break;
                case "SHOP": connections.add(new ShopConnection(units)); break;
                case "FACTORY": connections.add(new FactoryConnection(units)); break;
                default: throw new IllegalArgumentException("Unknown connection type");
            }
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double b = connections.get(i).bill();
            System.out.printf("%s: %.2f%n", types.get(i), b);
            total += b;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

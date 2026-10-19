import java.util.*;

abstract class HostelRoom {
    int units;
    HostelRoom(int units) { this.units = units; }
    abstract double bill();
}
class SingleRoom extends HostelRoom {
    SingleRoom(int units) { super(units); }
    double bill() { return units * 8.0; }
}
class SharedRoom extends HostelRoom {
    int occupants;
    SharedRoom(int units, int occupants) { super(units); this.occupants = occupants; }
    double bill() { return units * 6.0 / occupants; }
}
class ACRoom extends HostelRoom {
    ACRoom(int units) { super(units); }
    double bill() { return units * 10.0 + 200; }
}
public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<HostelRoom> rooms = new ArrayList<>();
        List<String> types = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            types.add(p[0]); int units = Integer.parseInt(p[1]);
            switch (p[0]) {
                case "SINGLE": rooms.add(new SingleRoom(units)); break;
                case "SHARED": rooms.add(new SharedRoom(units, Integer.parseInt(p[2]))); break;
                case "AC": rooms.add(new ACRoom(units)); break;
                default: throw new IllegalArgumentException("Unknown room type");
            }
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double b = rooms.get(i).bill();
            System.out.printf("%s: %.2f%n", types.get(i), b); total += b;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

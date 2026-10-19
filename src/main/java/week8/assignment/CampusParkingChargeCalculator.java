import java.util.*;

abstract class ParkedVehicle {
    int hours;
    ParkedVehicle(int hours) { this.hours = hours; }
    abstract double charge();
}
class Bike extends ParkedVehicle {
    Bike(int hours) { super(hours); }
    double charge() { return hours * 10.0; }
}
class Car extends ParkedVehicle {
    Car(int hours) { super(hours); }
    double charge() { return 30 + (hours - 1) * 20.0; }
}
class Truck extends ParkedVehicle {
    Truck(int hours) { super(hours); }
    double charge() { return Math.max(hours * 50.0, 100.0); }
}
public class CampusParkingChargeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<ParkedVehicle> vehicles = new ArrayList<>();
        List<String> types = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            int h = Integer.parseInt(p[1]); types.add(p[0]);
            switch (p[0]) {
                case "BIKE": vehicles.add(new Bike(h)); break;
                case "CAR": vehicles.add(new Car(h)); break;
                case "TRUCK": vehicles.add(new Truck(h)); break;
                default: throw new IllegalArgumentException("Unknown vehicle type");
            }
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double c = vehicles.get(i).charge();
            System.out.printf("%s: %.2f%n", types.get(i), c); total += c;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

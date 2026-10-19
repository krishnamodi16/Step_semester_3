import java.util.*;

abstract class TravelBooking {
    static final double BOOKING_FEE = 50.0;
    double distance;
    TravelBooking(double distance) { this.distance = distance; }
    abstract double baseFare();
    double totalFare() { return baseFare() + BOOKING_FEE; }
}
class BusBooking extends TravelBooking {
    BusBooking(double distance) { super(distance); }
    double baseFare() { return distance * 2.0; }
}
class TrainBooking extends TravelBooking {
    TrainBooking(double distance) { super(distance); }
    double baseFare() { return distance * 1.5; }
}
class FlightBooking extends TravelBooking {
    FlightBooking(double distance) { super(distance); }
    double baseFare() { return 2500 + distance * 4.0; }
}
public class TravelBookingCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<TravelBooking> bookings = new ArrayList<>();
        List<String> modes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            double d = Double.parseDouble(p[1]);
            modes.add(p[0]);
            switch (p[0]) {
                case "BUS": bookings.add(new BusBooking(d)); break;
                case "TRAIN": bookings.add(new TrainBooking(d)); break;
                case "FLIGHT": bookings.add(new FlightBooking(d)); break;
                default: throw new IllegalArgumentException("Unknown travel mode");
            }
        }
        for (int i = 0; i < n; i++)
            System.out.printf("%s: %.2f%n", modes.get(i), bookings.get(i).totalFare());
    }
}

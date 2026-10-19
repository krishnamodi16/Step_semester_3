import java.util.*;

abstract class LibraryItem {
    String title;
    int daysLate;
    LibraryItem(String title, int daysLate) { this.title = title; this.daysLate = daysLate; }
    abstract double fine();
}
class BookItem extends LibraryItem {
    BookItem(String title, int daysLate) { super(title, daysLate); }
    double fine() { return daysLate * 2.0; }
}
class DVDItem extends LibraryItem {
    DVDItem(String title, int daysLate) { super(title, daysLate); }
    double fine() { return Math.min(daysLate * 5.0, 50.0); }
}
class MagazineItem extends LibraryItem {
    MagazineItem(String title, int daysLate) { super(title, daysLate); }
    double fine() { return daysLate; }
}
public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            int days = Integer.parseInt(p[2]);
            switch (p[0]) {
                case "BOOK": items.add(new BookItem(p[1], days)); break;
                case "DVD": items.add(new DVDItem(p[1], days)); break;
                case "MAGAZINE": items.add(new MagazineItem(p[1], days)); break;
                default: throw new IllegalArgumentException("Unknown item type");
            }
        }
        double total = 0;
        for (LibraryItem item : items) {
            double f = item.fine();
            System.out.printf("%s: %.2f%n", item.title, f);
            total += f;
        }
        System.out.printf("Total Fines: %.2f%n", total);
    }
}

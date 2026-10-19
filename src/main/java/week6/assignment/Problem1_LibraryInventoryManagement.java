package week6.assignment;

class BookInventory {
    private String title;
    private String author;
    private int copiesAvailable;

    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public void printEntry() {
        System.out.printf("Title: %s | Author: %s | Copies available: %d%n",
                title, author, copiesAvailable);
    }
}

public class Problem1_LibraryInventoryManagement {
    public static void main(String[] args) {
        BookInventory[] books = {
            new BookInventory("Clean Code", "Robert C. Martin", 4),
            new BookInventory("Effective Java", "Joshua Bloch", 3),
            new BookInventory("Java: The Complete Reference", "Herbert Schildt", 5),
            new BookInventory("Head First Java", "Kathy Sierra", 2)
        };

        for (BookInventory book : books) {
            book.printEntry();
        }
    }
}

package week6.practice;

class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public void printCard() {
        System.out.println("Name: " + name + ", Books issued: " + booksIssued);
    }
}

public class Problem4_LibraryIdCardReferenceManagement {
    public static void main(String[] args) {
        IdCard first = new IdCard("Aisha", 2);
        IdCard second = first; // Both variables refer to the same object.

        second.booksIssued = 4;
        System.out.println("After modifying through second reference:");
        first.printCard();
        System.out.println("first == second: " + (first == second));

        IdCard third = new IdCard("Aisha", 4);
        System.out.println("first == third: " + (first == third));
    }
}

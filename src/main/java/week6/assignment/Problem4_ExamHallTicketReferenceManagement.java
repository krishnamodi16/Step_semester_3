package week6.assignment;

class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public void printTicket() {
        System.out.println("Student: " + studentName + ", Seat number: " + seatNumber);
    }
}

public class Problem4_ExamHallTicketReferenceManagement {
    public static void main(String[] args) {
        HallTicket first = new HallTicket("Aisha", 27);
        HallTicket alias = first;

        alias.seatNumber = 35;
        System.out.println("Ticket viewed through first reference:");
        first.printTicket();
        System.out.println("first == alias: " + (first == alias));

        HallTicket separate = new HallTicket("Aisha", 35);
        System.out.println("first == separate: " + (first == separate));
    }
}

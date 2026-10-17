package week1.assigment_problems;

public class ExamHallSeatDuplicationChecker {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;
        System.out.print("Duplicate seat numbers: ");
        for (int i = 0; i < seatNumbers.length; i++) {
            boolean appearedEarlier = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    appearedEarlier = true;
                    break;
                }
            }
            if (appearedEarlier) continue;

            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.print(seatNumbers[i] + " ");
                    found = true;
                    break;
                }
            }
        }
        if (!found) System.out.print("No Duplicate Seats Found");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] seats = {101, 102, 103, 102, 105};
        checkDuplicateSeats(seats);
    }
}

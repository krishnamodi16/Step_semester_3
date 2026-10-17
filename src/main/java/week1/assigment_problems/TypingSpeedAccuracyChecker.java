package week1.assigment_problems;

import java.util.Scanner;

public class TypingSpeedAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        int total = Math.max(original.length(), typed.length());
        if (total == 0) {
            System.out.println("Matched: 0/0 | Accuracy: 100.00% | No Mismatches");
            return;
        }

        int matched = 0;
        int firstMismatch = -1;
        int limit = Math.min(original.length(), typed.length());

        for (int i = 0; i < limit; i++) {
            if (original.charAt(i) == typed.charAt(i)) matched++;
            else if (firstMismatch == -1) firstMismatch = i;
        }

        double accuracy = matched * 100.0 / total;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%%n", matched, total, accuracy);

        if (firstMismatch == -1 && original.length() == typed.length()) {
            System.out.println("No Mismatches");
        } else if (firstMismatch != -1) {
            System.out.println("First Mismatch at position " + (firstMismatch + 1)
                    + " ('" + original.charAt(firstMismatch) + "' vs '"
                    + typed.charAt(firstMismatch) + "')");
        } else {
            System.out.println("First mismatch is caused by different text lengths at position "
                    + (limit + 1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Original passage: ");
        String original = sc.nextLine();
        System.out.print("Typed passage: ");
        String typed = sc.nextLine();
        checkTypingAccuracy(original, typed);
        sc.close();
    }
}

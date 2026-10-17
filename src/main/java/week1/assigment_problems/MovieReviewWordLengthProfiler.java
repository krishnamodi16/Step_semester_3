package week1.assigment_problems;

import java.util.Scanner;

public class MovieReviewWordLengthProfiler {
    public static void classifyWordLengths(String review) {
        int shortWords = 0, mediumWords = 0, longWords = 0;
        String trimmed = review.trim();

        if (!trimmed.isEmpty()) {
            String[] words = trimmed.split("\\s+");
            for (String word : words) {
                int length = word.replaceAll("[^a-zA-Z0-9]", "").length();
                if (length >= 1 && length <= 4) shortWords++;
                else if (length <= 8) mediumWords++;
                else longWords++;
            }
        }

        System.out.println("Short: " + shortWords + " | Medium: "
                + mediumWords + " | Long: " + longWords);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a movie review: ");
        String review = sc.nextLine();
        classifyWordLengths(review);
        sc.close();
    }
}

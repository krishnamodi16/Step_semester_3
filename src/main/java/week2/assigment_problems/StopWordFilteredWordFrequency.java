import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StopWordFilteredWordFrequency {
    public static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.split("\\s+");

        Set<String> stopWords = Set.of("the", "was", "and", "a", "is", "of", "in");
        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty() || stopWords.contains(word)) {
                continue;
            }
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a,
                               Map.Entry<String, Integer> b) {
                return b.getValue().compareTo(a.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter feedback paragraph: ");
        printFilteredWordFrequency(sc.nextLine());
        sc.close();
    }
}

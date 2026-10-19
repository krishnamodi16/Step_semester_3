package week5.assignment;

public class Problem4_MatchDayGridAnalyzer {
    private static double rowAverage(int[] row) {
        if (row.length == 0) return 0.0;
        int sum = 0;
        for (int runs : row) sum += runs;
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            if (i > 0) result.append(" | ");
            String label = rowAverage(runsPerOver[i]) >= threshold ? "Power Surge" : "Normal";
            result.append("Match ").append(i).append(": ").append(label);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runs = {{4, 6, 8}, {10, 12, 14}, {2, 3, 1}};
        System.out.println(classifyMatches(runs, 8));
    }
}

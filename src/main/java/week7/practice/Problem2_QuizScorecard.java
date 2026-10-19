package week7.practice;

class Scorecard {
    private final boolean[] results;
    private int answersRecorded;

    public Scorecard(int totalQuestions) {
        if (totalQuestions < 0) {
            totalQuestions = 0;
        }
        results = new boolean[totalQuestions];
        answersRecorded = 0;
    }

    public void recordAnswer(boolean correct) {
        if (answersRecorded >= results.length) {
            System.out.println("Cannot record more answers: scorecard is full.");
            return;
        }
        results[answersRecorded] = correct;
        answersRecorded++;
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < answersRecorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }
}

public class Problem2_QuizScorecard {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        sc.recordAnswer(true); // Extra answer is rejected.
        System.out.println("Score: " + sc.getScore());
    }
}

package week1.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) return "Draw";

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equals("Scissors"))
                || (playerMove.equalsIgnoreCase("Paper") && computerMove.equals("Rock"))
                || (playerMove.equalsIgnoreCase("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};
        int wins = 0, losses = 0, draws = 0;
        int round = 1;

        while (round <= 5) {
            System.out.print("Round " + round + " - Enter Rock, Paper, or Scissors: ");
            String player = sc.nextLine().trim();

            if (!player.equalsIgnoreCase("Rock") && !player.equalsIgnoreCase("Paper")
                    && !player.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            String computer = moves[random.nextInt(moves.length)];
            String result = playRound(player, computer);
            System.out.println("Player: " + player + " | Computer: " + computer
                    + " | Result: " + result);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
            round++;
        }

        System.out.println("\n--- Final Summary ---");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", wins * 100.0 / 5);
        sc.close();
    }
}

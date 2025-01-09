import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int machineScore;
        int playerScore;
        boolean playAgain;
        do {
            playerScore = playerCards();
            machineScore = machineCards();
            showWinner(playerScore, machineScore);
            playAgain = playAnotherGame();
        } while (playAgain);
        System.out.println("Goodbye!");
    }

    static int playerCards() {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int score = 0;

        do {
            System.out.println("Your score: " + score);
            System.out.println("Do you want another card? [Y/N]");
            String option = sc.nextLine();
            if (option.equals("Y"))
                score += rnd.nextInt(1, 10);
        } while (score < 21);

        return score;
    }

    static int machineCards() {
        Random rnd = new Random();
        int score = 0;
        while (score < 16) {
            score += rnd.nextInt(1, 10);
        }
        return score;
    }

    static void showWinner(int player, int machine) {

        if (player > 21 && machine > 16) {
            System.out.println("Draw!");
            System.out.println("Player score: " + player);
            System.out.println("Machine score: " + machine);
        } else if (player > 21) {
            System.out.println("Machine wins");
            System.out.println("Player score: " + player);
            System.out.println("Machine score: " + machine);
        } else if (machine > 16) {
            System.out.println("Player wins");
            System.out.println("Player score: " + player);
            System.out.println("Machine score: " + machine);
        }
    }

    static boolean playAnotherGame() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Play another game? [Y/N]");
        String option = sc.next();
        boolean play;
        play = option.equals("Y");
        return play;
    }

}

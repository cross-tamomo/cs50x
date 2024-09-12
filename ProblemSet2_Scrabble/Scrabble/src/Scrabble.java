import java.util.Scanner;

public class Scrabble {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String wordPlayer1, wordPlayer2;

    System.out.println("Player 1: ");
    wordPlayer1 = scanner.nextLine();

    System.out.println("Player2: ");
    wordPlayer2 = scanner.nextLine();

    System.out.println(winner(wordPlayer1, wordPlayer2));
  }

  public static int calculateScore(String word) {
    word = word.toUpperCase();
    int score = 0;

    for (int i = 0; i < word.length(); i++) {
      switch (word.charAt(i)) {
        case 'A', 'E', 'I', 'L', 'N', 'O', 'R', 'S', 'T', 'U' -> score += 1;
        case 'D', 'G' -> score += 2;
        case 'B', 'C', 'M', 'P' -> score += 3;
        case 'F', 'H', 'V', 'W', 'Y' -> score += 4;
        case 'K' -> score += 5;
        case 'J', 'X' -> score += 8;
        case 'Q', 'Z' -> score += 10;
      }
    }

    return score;
  }

  public static String winner (String wordPlayer1, String wordPlayer2) {
    int player1 = calculateScore(wordPlayer1);
    int player2 = calculateScore(wordPlayer2);

    if (player1 > player2) {
      return "Player 1 Score: " + player1 + "\n" +
          "Player 2 Score: " + player2 + "\n" +
          "Player 1 Wins!";
    } else if (player1 == player2) {
      return "Player 1 Score: " + player1 + "\n" +
          "Player 2 Score: " + player2 + "\n" +
          "Tie!";
    } else {
      return "Player 1 Score: " + player1 + "\n" +
          "Player 2 Score: " + player2 + "\n" +
          "Player 2 Wins!";
    }
  }
}

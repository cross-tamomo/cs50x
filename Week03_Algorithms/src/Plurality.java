import java.util.Scanner;

public class Plurality {

  private static String[] electionCandidates = {"Alice", "Bob", "Charlie"};
  private static int[] votes = new int[electionCandidates.length];

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String vote;

    System.out.println("Enter votes for candidates. Type 'done' to finish.");

    while (true) {
      System.out.print("Vote (type 'done' to finish): ");
      vote = scanner.nextLine();
      if (vote.equalsIgnoreCase("done")) {
        break;
      }
      addVote(vote);
    }

    printWinner();
    scanner.close();
  }

  public static void addVote(String candidateName) {
    for (int i = 0; i < electionCandidates.length; i++) {
      if (electionCandidates[i].equalsIgnoreCase(candidateName)) {
        votes[i]++;
        return;
      }
    }
    System.out.println("Invalid candidate: " + candidateName);
  }

  public static void printWinner() {
    int maxVotes = 0;
    String winner = "";

    for (int i = 0; i < electionCandidates.length; i++) {
      if (votes[i] > maxVotes) {
        maxVotes = votes[i];
        winner = electionCandidates[i];
      }
    }

    System.out.println("Election Results:");
    for (int i = 0; i < electionCandidates.length; i++) {
      System.out.println(electionCandidates[i] + ": " + votes[i] + " votes");
    }
    System.out.println("Winner: " + winner);
  }
}

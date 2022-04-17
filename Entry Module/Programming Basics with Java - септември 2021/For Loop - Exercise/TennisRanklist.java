import java.util.Scanner;

public class TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTournamentsInWhichHeParticipated = Integer.parseInt(scanner.nextLine());
        int initialNumberOfPointsInTheRanking = Integer.parseInt(scanner.nextLine());
        String reachedStageOfTheTournament = null;
        int finalPoints = 0;
        double numberOfTournamentsWon = 0;
        for (int i = 1; i <= numberOfTournamentsInWhichHeParticipated; i++) {
            reachedStageOfTheTournament = scanner.nextLine();
            if (reachedStageOfTheTournament.equals("W")) {
                finalPoints+=2000;
                numberOfTournamentsWon++;
            } else if (reachedStageOfTheTournament.equals("F")) {
                finalPoints+=1200;
            } else if (reachedStageOfTheTournament.equals("SF")) {
                finalPoints+=720;
            }
        }
        System.out.printf("Final points: %d\n", finalPoints + initialNumberOfPointsInTheRanking);
        System.out.printf("Average points: %.0f\n", Math.ceil(finalPoints / numberOfTournamentsInWhichHeParticipated));
        System.out.printf("%.2f%%", (numberOfTournamentsWon / numberOfTournamentsInWhichHeParticipated) * 100);
    }
}

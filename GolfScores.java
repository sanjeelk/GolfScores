import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Score {

    int score;
    LocalDate date;

    Score(int score, LocalDate date) {
        this.score = score;
        this.date = date;
    }
}

public class GolfScores {

    static ArrayList<Score> scores = new ArrayList<>();

    static void addScore(int score, LocalDate date) {

        if (score < 1 || score > 45) {
            System.out.println("Invalid score!");
            return;
        }

        if (scores.size() == 5) {
            scores.remove(0);
        }

        scores.add(new Score(score, date));
    }

    static void displayScores() {

        Collections.sort(scores,
                Comparator.comparing(s -> s.date));

        Collections.reverse(scores);

        for (Score s : scores) {
            System.out.println(s.date +
                    " - Score: " + s.score);
        }
    }

    public static void main(String[] args) {

        addScore(40, LocalDate.of(2026, 4, 1));
        addScore(35, LocalDate.of(2026, 3, 30));
        addScore(42, LocalDate.of(2026, 3, 28));
        addScore(38, LocalDate.of(2026, 3, 25));
        addScore(41, LocalDate.of(2026, 3, 22));
        addScore(39, LocalDate.of(2026, 4, 2));

        displayScores();
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("Welcome to PPTHangman!");
        System.out.println("Please enter the number of players:");

        Scanner scanner = new Scanner(System.in);

        int numPlayers = Integer.parseInt(scanner.nextLine());
        List<Player> allPlayers = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Please enter the name of the " + (i + 1) + "th player");
            allPlayers.add(new Player(scanner.nextLine()));
        }

        int currentLeaderIndex = 0;

        while (true) {
            System.out.println("Do you wish to start a new game? Y/N");
            String answer = scanner.nextLine();

            if (answer.startsWith("N")) {
                break;
            }

            Player leader = allPlayers.get(currentLeaderIndex);

            System.out.println(leader + ", you are the leader, please pick a word:");

            Word word = new Word(scanner.nextLine());

            List<Player> players = new ArrayList<>(allPlayers);
            players.remove(leader);

            Session session = new Session(scanner, players, leader, word);
            session.play();

            currentLeaderIndex = (currentLeaderIndex + 1) % allPlayers.size();
        }
    }
}

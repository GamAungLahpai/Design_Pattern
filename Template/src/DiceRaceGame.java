import java.util.Random;

public class DiceRaceGame extends Game {
    private int[] positions;
    private int finishLine;
    private int winner;
    private Random random;

    @Override
    public void initializeGame(int numberOfPlayers) {
        if (numberOfPlayers < 2) {
            throw new IllegalArgumentException("At least 2 players are required.");
        }

        positions = new int[numberOfPlayers];
        finishLine = 20;
        winner = -1;
        random = new Random();

        System.out.println("Starting Dice Race with " + numberOfPlayers + " players.");
        System.out.println("First player to reach " + finishLine + " wins.\n");
    }

    @Override
    public boolean endOfGame() {
        return winner != -1;
    }

    @Override
    public void playSingleTurn(int player) {
        int roll = random.nextInt(6) + 1;
        positions[player] += roll;

        System.out.println(
            "Player " + (player + 1) +
            " rolled " + roll +
            " and moved to " + positions[player]
        );

        if (positions[player] >= finishLine) {
            winner = player;
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("\nGame over!");
        System.out.println("Winner: Player " + (winner + 1));
    }
}

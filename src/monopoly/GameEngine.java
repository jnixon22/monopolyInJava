package monopoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameEngine {

    private static final Random random = new Random(System.currentTimeMillis());

    private Board board;

    private List<Player> players;

    private boolean gameOver;

    public GameEngine(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
    }

    public void start() {
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inp);
        Map<String, PlayerOption> defaultOptions = new HashMap<String, PlayerOption>();
        defaultOptions.put("E", new EndTurnOption());
        defaultOptions.put("Q", new EndGameOption(this));

        while (!gameOver) {
            for (Player player : players) {
                int dice1 = rollDice();
                int dice2 = rollDice();
                Square square = board.movePiece(player, dice1 + dice2);
                System.out.println("-----------------------------------------");
                System.out.println(player.getName() + "'s Turn");
                System.out.println("Rolled [" + dice1 + "][" + dice2 + "]");
                System.out.println("Landed on " + square.toString());
                Map<String, PlayerOption> options = getPlayerOptions(defaultOptions);
                printOptions(options);

                System.out.println("What will you do?");
                PlayerOption option = null;
                while (option == null) {
                    try {
                        String input = br.readLine().trim();
                        option = options.get(input);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (option == null) {
                        System.out.println("Sorry, what was that?");
                        printOptions(options);
                    }
                }
                option.execute(player);
                if (gameOver) {
                    break;
                }
            }
        }
    }

    public void endGame() {
        gameOver = true;
    }

    private void printOptions(Map<String, PlayerOption> options) {
        for (Map.Entry<String, PlayerOption> entry : options.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue().getDescription());
        }
    }

    private Map<String, PlayerOption> getPlayerOptions(Map<String, PlayerOption> defaultOptions) {
        Map<String, PlayerOption> options = new HashMap<String, PlayerOption>();
        options.putAll(defaultOptions);
        //TODO: add more options
        return options;
    }

    private int rollDice() {
        return random.nextInt(6) + 1;
    }

}

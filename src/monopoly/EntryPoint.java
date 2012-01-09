package monopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntryPoint {

    public static void main(String[] args) {
        Player justin = new Player("Justin");
        Player alex = new Player("Alex");
        List<Player> players = new ArrayList<Player>(Arrays.asList(justin, alex));

        List<Square> squares = new ArrayList<Square>(Arrays.asList(
                new Property("Mediterranean Ave.", PropertyColor.INDIGO, 60),
                new Property("Baltic Ave.", PropertyColor.INDIGO, 60),
                new Property("Oriental Ave.", PropertyColor.LIGHT_BLUE, 100),
                new Property("Vermont Ave.", PropertyColor.LIGHT_BLUE, 100),
                new Property("Connecticut Ave.", PropertyColor.LIGHT_BLUE, 120),
                new Property("St. Charles Place", PropertyColor.VIOLET, 140),
                new Property("States Ave.", PropertyColor.VIOLET, 140),
                new Property("Virginia Ave.", PropertyColor.VIOLET, 160),
                new Property("St. James Place", PropertyColor.ORANGE, 180),
                new Property("Tennessee Ave.", PropertyColor.ORANGE, 180),
                new Property("New York Ave.", PropertyColor.ORANGE, 200),
                new Property("Kentucky Ave.", PropertyColor.RED, 220),
                new Property("Indiana Ave.", PropertyColor.RED, 220),
                new Property("Illinois Ave.", PropertyColor.RED, 240),
                new Property("Atlantic Ave.", PropertyColor.YELLOW, 260),

                new Property("Ventnor Ave.", PropertyColor.YELLOW, 260),
                new Property("Marvin Gardens", PropertyColor.YELLOW, 280)
        ));
        Board board = new Board(squares, players);

        GameEngine gameEngine = new GameEngine(board, players);
        gameEngine.start();

    }

}

package monopoly;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private List<Square> squares;

    private Map<Player, Integer> playerToPosition = new HashMap<Player, Integer>();

    public Board(List<Square> squares, List<Player> players) {
        this.squares = squares;

        for (Player player : players) {
            playerToPosition.put(player, 0);
        }
    }

    public Square movePiece(Player player, int roll) {
        int position = playerToPosition.get(player);
        position += roll;
        if (position >= squares.size()) {
            position = position % squares.size();
        }
        playerToPosition.put(player, position);
        return squares.get(position);
    }

}

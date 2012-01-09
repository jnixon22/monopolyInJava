package monopoly;

public class EndTurnOption implements PlayerOption {


    public String getDescription() {
        return "End Turn";
    }

    public void execute(Player player) {
        // no need to do anything on end turn
        System.out.println(player.getName() + " Ended Turn");
    }

}

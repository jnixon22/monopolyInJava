package monopoly;

public class EndGameOption implements PlayerOption {

    private GameEngine gameEngine;

    public EndGameOption(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public String getDescription() {
        return "End Game";
    }

    public void execute(Player player) {
        gameEngine.endGame();
        System.out.println(player.getName() + " Ended Game");
    }

}

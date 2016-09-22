package cards;

public class Player {

    private String name;
    private int id;

    private static int numberOfPlayers = 0;

    public Player() {
    }

    public Player(String name, int id) {
        this.name = name;
        numberOfPlayers++;
        this.id = numberOfPlayers;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String playerName) {
        this.name = playerName;
    }

    public void setId(int playerId) {
        this.id = playerId;
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }
}

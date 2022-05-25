package SeaBattle;

public class Ship {
    private int deck;
    private int direction;

    public Ship(int deck, int direction) {
        this.deck = deck;
        this.direction = direction;
    }

    public int getDeck() {
        return deck;
    }
    public int getDirection() {
        return direction;
    }
}

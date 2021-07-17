import java.util.ArrayList;
import java.util.Random;

public class Card {

    private Suit suit;
    private Value value;


    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = getRandomValue();

    }

    public static Value getRandomValue() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];

    }


    public void makeBet() {

    }

}

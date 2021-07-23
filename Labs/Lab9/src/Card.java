import java.util.ArrayList;
import java.util.List;


/**
 * An object of type Card represents a playing card from a standard Poker
 * deck without the Joker.  The card has a suit, which can be one of the enumerated
 * type values from enum Suit.  A card has one of the 13 enumerated type values
 * from enum CardValue.  Note that "ace" is considered to be the smallest value.
 */
public class Card {
    private Suit suit;          // The suit of this card.
    private Value value;        // The value of this card.
    private static final List<Card> allCards = new ArrayList<Card>(52);

    /**
     * Creates a card with a specified suit and value.
     * @param theValue the non-null value of the new card.
     * @param theSuit the non-null suit of the new card.
     * @throws NullPointerException if a parameter value is null.
     */
    public Card( Suit theSuit, Value theValue ) {
        this.suit = theSuit;
        this.value = theValue;
        if (theValue == null || theSuit == null)
            throw new NullPointerException("Card suit and value cannot be null.");
    }

    /**
     * Returns the suit of this card.
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Returns the value of this card.
     */
    public Value getValue() {
        return value;
    }

    /**
     * Returns a string representation of this card, including both
     * its suit and its value.  Sample return values are:
     * "Queen of Hearts", "10 of Diamonds", "Ace of Spades".
     */
    public String toString() {
        return value + " of " + suit;  // A string such as "Ace of Spades"
    }

    /**
     * The makeBets gives a bitcoin number when meet different suit of the card.
     * @return an integer of the bitcoin.
     */
    public int makeBet() {
        int bitcoins;
        switch(getSuit()){
            case CLUBS:
                bitcoins = 100;
                break;
            case HEARTS:
                bitcoins = 200;
                break;
            case SPADES:
                bitcoins = 300;
                break;
            case DIAMONDS:
                bitcoins = 0;
                System.out.println("If I met Diamonds, I give up betting_(:з」∠)_");
                break;
            default:
                bitcoins = 0;
                break;
        }
        return bitcoins;
    }

    public static void main(String[] args) {
        System.out.println("***** Randomly choose 10 cards for you *****");
        List<Card> tenCards = new ArrayList<Card>();
        int i = 1;
        while (i <= 10) {
             Card cardRandom = new Card(Suit.randomSuit(), Value.randomValue());
             if(!tenCards.contains(cardRandom)){
                 System.out.println("Card " + i + "--------");
                 System.out.println(cardRandom);
                 System.out.println("Bet for this suit: " + cardRandom.makeBet());
                 tenCards.add(cardRandom);
                 i++;
             }
        }

        System.out.println("\n***** A list of all 52 cards *****");

        List<Suit> suits = java.util.Arrays.asList(Suit.values());
        List<Value> values = java.util.Arrays.asList(Value.values());

        for (int k = 0; k < 4; k++) {
             for (int j = 0; j < 13; j++){
                Card card = new Card(suits.get(k), values.get(j));
                allCards.add(card);
            }
        }
        System.out.println(allCards);

//        // You can try this by commenting it:D
//        try {
//            allCards = new ArrayList<Card>();
//        }
//        catch (Exception e) {
//            System.out.println("You can't modify a final variable!");
//        }
    }
}




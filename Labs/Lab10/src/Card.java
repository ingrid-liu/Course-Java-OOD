import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class Card implements Comparable<Card> {
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

    /**
     * Override the compareTo by following these rules:
     * (1). SPADES > HEARTS > DIAMONDS > CLUBS
     * (2). ACE > KING > QUEEN and so on -- without relying on the order used in your enum definitions
     * (3). Suit is more important than Value (eg, TWO of SPADES beats THREE of HEARTS.
     * @param another card
     * @return integer
     */
    @Override
    public int compareTo(Card another){
        Hashtable<Suit, Integer> suits = new Hashtable<>(4);
        suits.put(Suit.SPADES, 4);
        suits.put(Suit.HEARTS, 3);
        suits.put(Suit.DIAMONDS, 2);
        suits.put(Suit.CLUBS,1);

        if (suits.get(this.suit) == suits.get(another.suit)) {
            if (this.value == another.value) return 0;
            if (this.value == Value.ACE && another.value != Value.ACE) return 1;
            if (this.value != Value.ACE && another.value == Value.ACE) return -1;
            else if (this.value.ordinal() > another.value.ordinal()) return 1;
            else return -1;
        } else if (suits.get(this.suit) > suits.get(another.suit)) {
            return 1;
        } else {
            return -1;
        }

    }


    public static void main(String[] args) {
        System.out.println("*************************************** RULES " +
                "****************************************************");
        System.out.println("* (1). SPADES > HEARTS > DIAMONDS > CLUBS" +
                "\n* (2). ACE > KING > QUEEN and so on -- without relying on the order used in your enum definitions " +
                "\n* (3). Suit is more important than Value (eg, TWO of SPADES beats THREE of HEARTS.");
        System.out.println("***********************************************" +
                "***************************************************");
        System.out.println("\n====== Randomly choose 2 cards ======");
        Card card1 = new Card(Suit.randomSuit(), Value.randomValue());
        System.out.println("Card1: " + card1);
        Card card2 = new Card(Suit.randomSuit(), Value.randomValue());
        System.out.println("Card2: " + card2);


//        // Designed cards comparison
//        Card card1 = new Card(Suit.CLUBS, Value.ACE);
//        Card card2 = new Card(Suit.DIAMONDS, Value.TWO);
//        System.out.println("Card1: " + card1);
//        System.out.println("Card2: " + card2);



        System.out.println("\n====== Compare the cards ======");
        if (card1.compareTo(card2) > 0) {
            System.out.println("Card 1 won!");
        } else if (card1.compareTo(card2) == 0) {
            System.out.println("Card1 & Card2 tied.");
        } else
            System.out.println("Card 2 won!");

        System.out.println("\nPlease run more times to see the results ^^");



    }
}




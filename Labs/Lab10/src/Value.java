
/**
 * Values of type CardValue represent the 13 possible values of
 * an ordinary playing card.
 */
public enum Value {
    ACE,
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
    JACK, QUEEN, KING;

    /**
     * Return a String representation of this CardValue, using numbers
     * for the numerical cards and names for the ace and face cards.
     */
    public String toString() {
        switch (this) {       // "this" is one of the enumerated type values
            case ACE:             // ordinal number of ACE
                return "Ace";
            case JACK:            // ordinal number of JACK
                return "Jack";
            case QUEEN:            // ordinal number of QUEEN
                return "Queen";
            case KING:            // ordinal number of KING
                return "King";
            default:            // it's a numeric card value
                int numericValue = 1 + ordinal();
                return "" + numericValue;
        }
    }

    public static Value randomValue() {
        int max = Value.values().length - 1;
        int pick = (int) Math.round(Math.random() * max);
        return Value.values()[pick];
    }

//    @Override
//    public int compareTo(Value another){
//        if (this == another) return 0;
//        if (this == ACE && another != ACE) return 1;
//        if (this != ACE && another == ACE) return -1;
//        else if (this.ordinal() > another.ordinal()) return 1;
//        else return -1;
//    }



}


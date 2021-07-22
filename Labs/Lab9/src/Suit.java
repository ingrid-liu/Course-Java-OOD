public enum Suit {
//    Clubs, Spades, Hearts, Diamonds
    CLUBS, SPADES, HEARTS, DIAMONDS;

    public String toString() {
        switch (this) {
            case CLUBS:   return "Clubs";
            case SPADES:   return "Spades";
            case HEARTS:   return "Hearts";
            case DIAMONDS: return "Diamonds";
            default:       return "Clubs";    // (CLUBS is the only other possibility.)
        }
    }

    public static Suit randomSuit() {
        int max = Suit.values().length - 1;
        int pick = (int) Math.round(Math.random() * max);
        return Suit.values()[pick];
    }

}

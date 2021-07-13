package cs5004.marblesolitaire.model;

/**
 * MarbleSolitaireModelImpl is the implementation of MarbleSolitaireModel.
 * It designs a suitable representation of the Marble Solitaire game.
 *
 * @author 'Ingrid' Xiaoying Liu
 * @version 1.0
 * @since 7-4-2021
 *
 * Requirement: Think carefully about what fields and types you will need
 * and how possible values of the fields correspond to game states.
 *
 * TODO Q1: do I need to consider about arm thick = 1? otherwise, it must >= 3?
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel{
    /**
     * Define the armThink of the game board, and the coordinate (sRow, sCol) of the marble's position.
     */
    public int armThick;
    public int sRow;
    public int sCol;
    public Board board;

    /**
     * This 1st constructor takes no parameters, and initialize the game board with arm thickness = 3
     * and empty slot at the center.
     */
    public MarbleSolitaireModelImpl() {
        this(3,3,3);
    }

    /**
     * This 2nd constructor takes two parameters: sRow and sCol, and it initialize the game board
     * with the arm thickness = 3 and the empty slot is at the position (sRow, sCol).
     * @param sRow an integer of the center's row
     * @param sCol an integer of the center's column
     * @throws IllegalArgumentException when specified an invalid position of the center
     */
    public MarbleSolitaireModelImpl(int sRow, int sCol) throws IllegalArgumentException {
        this(3, sRow, sCol);
        if (!(this.isValid(sRow, sCol))) {
            throw new IllegalArgumentException("Invalid empty cell position (" + sRow + ", " + sCol + ")");
        }
    }

    /**
     * This 3rd constructor takes the arm thickness as its only parameter and initialize a game board
     * by setting the empty slot at the center.
     * @param armThick a positive odd number
     * @throws IllegalArgumentException when arm thickness is not a positive odd number.
     */
    public MarbleSolitaireModelImpl(int armThick) throws IllegalArgumentException{
        this(armThick, armThick, armThick);
        if (armThick <= 0 || armThick % 2 == 0) {
            throw new IllegalArgumentException("arm thickness is not a positive odd number:" + armThick);
        }
    }

    /**
     * This 4th constructor takes the arm thickness, row and column of the empty slot in that order.
     * @param armThick a positive odd number
     * @param sRow an integer of the center's row
     * @param sCol an integer of the center's column
     * @throws IllegalArgumentException when arm thickness is not a positive odd number, or empty cell is invalid.
     */
    public MarbleSolitaireModelImpl(int armThick, int sRow, int sCol) throws IllegalArgumentException{
        this.armThick = armThick;
        this.sRow = sRow;
        this.sCol = sCol;

        if (armThick <= 0 || armThick % 2 == 0) {
            throw new IllegalArgumentException("arm thickness is not a positive odd number:" + armThick);
        }
        if (!(this.isValid(sRow, sCol))) {
            throw new IllegalArgumentException("Invalid empty cell position (" + sRow + ", " + sCol + ")");
        }

    }


    /**
     * The getGameState method is used to print the game state in the format of characters(' ', 'O' or '_').
     * @return a String
     *
     * Note: The string you return should not have a newline at the end of the last line.
     *      (O, _ or space for a marble, empty and invalid position respectively).
     */
    @Override
    public String getGameState() {
        this.board = new Board(this.armThick, this.sRow, this. sCol);
        return this.board.getGameState();
    }

    /**
     * Move a single marble from a given position to another given position.
     * @param fromRow the row number of the position to be moved from
     *                (starts at 0)
     * @param fromCol the column number of the position to be moved from
     *                (starts at 0)
     * @param toRow the row number of the position to be moved to
     *              (starts at 0)
     * @param toCol the column number of the position to be moved to
     *              (starts at 0)
     * @throws IllegalArgumentException if any invalid move is generated
     */
    @Override
    public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
        /**
         * A move is valid if all these conditions are true:
         * (a) the “from” and “to” positions are valid
         * (b) there is a marble at the specified “from” position
         * (c) the “to” position is empty
         * (d) the “to” and “from” positions are exactly two positions away (horizontally or vertically)
         * (e) there is a marble in the slot between the “to” and “from” positions.
         */

        this.board.move(fromRow, fromCol, toRow, toCol);

    }



    /**
     * Determine and return if the game is over or not, based on if there's more moves can be made.
     * @return true if the game is over, false otherwise
     */
    @Override
    public boolean isGameOver() {
        // iterate each existing marble and check if it has valid move to go, if not return true
        return false;
    }


    /**
     * The getScore method returns the number of marbles currently on the board.
     * @return current score: the number of marbles currently on the board
     */
    @Override
    public int getScore() {
        // initialization
        int initialScore = this.armThick * this.armThick * 4 - 4;

        // left marble number
        int currScore;
        return initialScore;
    }

    // check if empty cell position is invalid. todo: optimize here without repeating code
    /**
     * Helper method isValid is checking if the position is valid or not
     * @return true if the position is valid, false other wise
     */
    private boolean isValid(int row, int col) {
//        return !board.checkBoundariesFalse(sRow, sCol);
        int size = 2 * armThick + 1;
        if ((row < ((armThick + 1)/2)  && col < (armThick + 1)/2) || // top left
                (row < ((armThick + 1)/2)  && col >= ((3*armThick + 1)/2)) || // top right
                (row >= ((3*armThick + 1)/2) && col < ((armThick + 1)/2)) || // bottom left
                (row >= ((3*armThick + 1)/2) && col >= ((3*armThick + 1)/2)) || // bottom right
                row < 0 || row > (size-1) || col > (size-1) || col < 0) return false;
        return true;
    }

    public String toString() {
        return ("There are " + this.getScore() + " marbles on the board.");
    }

    public int getArmThick() {
        return armThick;
    }

    public void setArmThick(int armThick) {
        this.armThick = armThick;
    }

    public int getsRow() {
        return sRow;
    }

    public void setsRow(int sRow) {
        this.sRow = sRow;
    }

    public int getsCol() {
        return sCol;
    }

    public void setsCol(int sCol) {
        this.sCol = sCol;
    }



    public static void main(String[] args) {
        System.out.println("The main function in MarbleSolitaireModelImpl runs...");

        System.out.println("\n******** Test on the board initialization ********");
        MarbleSolitaireModelImpl modelTest1 = new MarbleSolitaireModelImpl();
        System.out.println("When arm thick is default: ");
        System.out.println(modelTest1.getGameState());

//        MarbleSolitaireModelImpl modelTest2 = new MarbleSolitaireModelImpl(5);
//        System.out.println("\nWhen arm thick is 5: ");
//        System.out.println(modelTest2.getGameState());
//
//        MarbleSolitaireModelImpl modelTest3 = new MarbleSolitaireModelImpl(7);
//        System.out.println("\nWhen arm thick is 7: ");
//        System.out.println(modelTest3.getGameState());
//
//        MarbleSolitaireModelImpl modelTest4 = new MarbleSolitaireModelImpl(9);
//        System.out.println("\nWhen arm thick is 9: ");
//        System.out.println(modelTest4.getGameState());

        modelTest1.move(5,3,3,3);
        System.out.println("\n" + modelTest1.board.getGameState());




    }
}

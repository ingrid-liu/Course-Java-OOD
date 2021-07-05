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
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel{
    /**
     * Define
     */
    int armThick;
    int sRow;
    int sCol;


    public MarbleSolitaireModelImpl() {
        armThick = 3;
        sRow = 3;
        sCol = 3;
    }

    public MarbleSolitaireModelImpl(int sRow, int sCol) throws IllegalArgumentException {
        armThick = 3;
        this.sRow = sRow;
        this.sCol = sCol;

        // todo merge sRow and sCol into one coordinate
        if (!(this.isValid(sRow)) || !(this.isValid(sCol))) {
            throw new IllegalArgumentException("Invalid empty cell position (" + sRow + ", " + sCol + ")");
        }
    }

    public MarbleSolitaireModelImpl(int armThick) throws IllegalArgumentException{
        this.armThick = armThick;
        sRow = 3;
        sCol = 3;
        if (armThick <= 0 || armThick % 2 == 0) {
            throw new IllegalArgumentException("arm thickness is not a positive odd number:" + armThick);
        }
    }

    public MarbleSolitaireModelImpl(int armThick, int sRow, int sCol) throws IllegalArgumentException{
        this.armThick = armThick;
        this.sRow = sRow;
        this.sCol = sCol;

        if (armThick <= 0 || armThick % 2 == 0) {
            throw new IllegalArgumentException("arm thickness is not a positive odd number:" + armThick);
        }
        if (!(this.isValid(sRow)) || !(this.isValid(sCol))) {
            throw new IllegalArgumentException("Invalid empty cell position (" + sRow + ", " + sCol + ")");
        }
    }


    /**
     * The getGameState method is used to print the game state in the format of characters(' ', 'O' or '_').
     * @return a String
     *
     * Note: The string you return should not have a newline at the end of the last line.
     *      (O, X or space for a marble, empty and invalid position respectively).
     */
    @Override
    public String getGameState() {
        return null;
    }

    /**
     * The move method should make the move and change the game state appropriately.
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

    }

    /**
     * Determine and return if the game is over or not, based on if there's more moves can be made.
     * @return true if the game is over, false otherwise
     */
    @Override
    public boolean isGameOver() {
        return false;
    }


    /**
     * The getScore method returns the number of marbles currently on the board.
     * @return the number of marbles currently on the board
     */
    @Override
    public int getScore() {
        return 0;
    }

    // check if empty cell position is invalid.

    /**
     * Helper method isValid is checking if the position is valid or not
     * @param coordinate int, value of sRow of sCol
     * @return true if the position is valid, false other wise
     */
    private boolean isValid(int coordinate) {
        return false;
    }


}

package cs5004.marblesolitaire.model;

public class Board {

    protected Marbles[][] board;
    protected int armThick;
    protected int size;
    protected Marbles centerCell;

    /**
     * Constructs an instance of a game board based on armThick and empty space coordinates.
     * @param armThick the thickness of the squares that make up the board.
     * @param sRow the column position of the empty space.
     * @param sCol the row position of the empty space.
     */
    public Board(int armThick, int sRow, int sCol) {
        this.size = (armThick * 2) + 1;
        this.armThick = armThick;
        generateBoard(sRow, sCol);
    }

    /**
     * This generateBoard methods creates a 2D array to save the marbles in its proper slot.
     * @param emptyR the empty slot in the row
     * @param emptyC the empty slot in the column
     */
    protected void generateBoard(int emptyR, int emptyC) {
        board = new Marbles[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (checkBoundariesFalse(row, col)) {
                    board[row][col] = null;
                } else board[row][col] = new Marbles();
            }
        }
        this.board[emptyR][emptyC].gone = true;
    }

    /**
     * Checks whether or not the given row and column are out of bounds.
     * @param row the row value
     * @param col the column value
     * @return whether or not the given row and column are out of bounds
     */
    protected boolean checkBoundariesFalse(int row, int col) {
        return (row < ((armThick + 1)/2)  && col < (armThick + 1)/2) || // top left
                (row < ((armThick + 1)/2)  && col >= ((3*armThick + 1)/2)) || // top right
                (row >= ((3*armThick + 1)/2) && col < ((armThick + 1)/2)) || // bottom left
                (row >= ((3*armThick + 1)/2) && col >= ((3*armThick + 1)/2)) || // bottom right
                row < 0 || row > (size-1) || col > (size-1) || col < 0;

    }

    /**
     * The getGameState method is used to print the game state in the format of characters(' ', 'O' or '_').
     * @return the game state as a string
     *
     * Note: The string you return should not have a newline at the end of the last line.
     *      (O, _ or space for a marble, empty and invalid position respectively).
     */
    public String getGameState() {
        String initial = "";

        for (int row = 0; row < this.size; row++) {
            boolean drewM = false;
            for (int col = 0; col < this.board[row].length; col++) {
                if (this.board[row][col] == null) {
//                    System.out.println("here1 drewM: " + drewM);
                    if (!drewM) {
                        initial += "  ";
                    }
                } else {
                    if (col == 0  || this.board[row][col - 1] == null) {
                        initial += this.board[row][col].status();   // first marble on the board in each row
                    } else {
                        initial += " " + this.board[row][col].status();
                    }
                    drewM = true;
                }
            }
            if ((row != this.board.length - 1)) {
            //if ((row != this.size - 1)) {
                initial += "\n";
            }
        }
        return initial;
    }

    /**
     * This validTargetPosition method determines whether the given target position is a valid or not.
     * @param row the y position of the given position.
     * @param col the x position of the given position.
     * @return whether or not the given posn is a valid position on the board.
     */
    protected boolean onBoard(int row, int col) {
        return !(checkBoundariesFalse(row, col));
    }



    /**
     * Determines whether or not the given move action is valid.
     * @param fromRow the row position of the marble before it is moved.
     * @param fromCol the column position of the marble before it is moved.
     * @param toRow the row position of the marble after it is moved.
     * @param toCol the column position of the marble after it is moved.
     * @return whether or not the given move action is valid.
     */
    protected boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {
        System.out.println("validMove method in Board runs...");
//        if (!(onBoard(fromRow, fromCol))
//                || !(onBoard(toRow, toCol))
//                || (!(!this.board[fromRow][fromCol].gone && this.board[toRow][toCol].gone))
//                || !((Math.abs(toRow - fromRow) == 2) && fromCol == toCol)
//                || !((Math.abs(toCol - fromCol) == 2) && toRow == fromRow)){
//            return false;

        if (!(onBoard(fromRow, fromCol))
                || !(onBoard(toRow, toCol))
                || (!(!this.board[fromRow][fromCol].gone && this.board[toRow][toCol].gone))
                || (!((Math.abs(toRow - fromRow) == 2 && fromCol == toCol)
                    || (Math.abs(toCol - fromCol) == 2 && toRow == fromRow)))) {
            return false;
        } else {
            centerCell = this.board[fromRow + (toRow - fromRow) / 2][(fromCol + (toCol - fromCol) / 2)];
            return !(centerCell.gone);

        }
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
    public void move(int fromRow, int fromCol, int toRow, int toCol) {
        System.out.println("move method in Board runs...");
        if (validMove(fromRow, fromCol, toRow, toCol)) {
            System.out.println("Before -- from spot is:" + this.board[fromRow][fromCol].status() );
            this.board[fromRow][fromCol].gone = true;
            System.out.println("After -- from spot is:" + this.board[fromRow][fromCol].status() );
            centerCell.gone = true;
            System.out.println("Before -- to spot is:" + this.board[toRow][toCol].status() );
            this.board[toRow][toCol].gone = false;
            System.out.println("After -- to spot is:" + this.board[toRow][toCol].status() );
        } else {
            throw new IllegalArgumentException("Move must be valid");
        }
    }

    /**
     * Determine and return if the game is over or not. A game is over if no
     * more moves can be made.
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        for (int row = 0; row < this.board.length - 1; row++) {
            for (int col = 0; col  < this.board[row].length - 1; col++) {
                if (row + 2 < size && validMove(row, col, row + 2, col)) {
                    return false;
                } else if ( row - 2 > 0 && validMove(row, col, row - 2, col)) {
                    return false;
                } else if (col + 2 < size && validMove(row, col, row, col + 2)) {
                    return false;
                } else if (col - 2 > 0 && validMove(row, col, row, col - 2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Calculates the current score at any moment in the game.
     * @return an integer representing the current score
     */
    public int calculateScore() {
        int count = 0;
        for (int i = 0; i < this.size; i++ ) {
            for (int k = 0; k < this.size; k++) {
                if ((this.board[i][k] != null) && this.board[i][k].status().equals("O")) {
                    count++;
                }
            }
        }
        return count;
    }

}
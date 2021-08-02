package cs5004.marblesolitaire.model;

/**
 * Marbles file is defining each marble's statement with gone or not.
 * @author 'Ingrid' Xiaoying Liu
 * @version 1.0
 * @since 7-23-2021
 *
 */
public class Marbles {
    public boolean gone;

    /**
     * This constructor creates an instance of the Marble object.
     */
    public Marbles() {
        this.gone = false;
    }

    /**
     * The string method represents the current state of the marble with "_" or "O" based on its status.
     * @return "O" if there's a marble on that position, otherwise return "_"
     */
    public String status() {
        if (gone) return "_";
        else return "O";
    }
}
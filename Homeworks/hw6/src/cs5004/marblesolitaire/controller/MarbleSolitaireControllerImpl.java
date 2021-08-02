package cs5004.marblesolitaire.controller;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
    private final Readable rd;
    private final Appendable ap;

    /**
     * Constructs with passing rd and ap.
     * @param rd readable
     * @param ap appendable
     * @throws IllegalArgumentException if and only if the readable or appendable objects are null
     */
    public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
        if (rd == null || ap == null) {
            throw new IllegalArgumentException("The readable or appendable objects are null");
        }
        this.rd = rd;
        this.ap = ap;
    }

    /**
     * Plays the game by using the passing model.
     * @param model provided MarbleSolitaireModel
     * @throws IllegalArgumentException when provided mode is null
     * @throws IllegalStateException if the Appendable object is unable to transmit output
     */
    public void playGame(MarbleSolitaireModel model) throws IllegalArgumentException, IllegalStateException {
        // Exceptions handling: throws IllegalArgumentException if the provided model is null
        if (model == null) {
            throw new IllegalArgumentException("The model provided is null");
        }

        // play a new game of Marble Solitaire using the provided model
        this.playGameWithModel(model);

        Scanner scan = new Scanner(rd);
        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(0); arr.add(0); arr.add(0); arr.add(0);
        arr.add(null); arr.add(null); arr.add(null); arr.add(null);

        int i = 0;
        //todo
        //  ??? The controller should not propagate any exceptions thrown by the model to its caller.
        //  If the Appendable object is unable to transmit output, this method should throw an IllegalStateException
        //  to its caller. Likewise
        // (only if the controller is unable to successfully receive input or transmit output)
        // if (???) throw new IllegalStateException("Unable to successfully receive input or transmit output");




        while (true) {
            String input;
            // When "Game over!"
            if (model.isGameOver()) {
                try {
                    ap.append("Game over!\n" +
                            model.getGameState() + "\n" +
                            "Score: " + model.getScore() + "\n");
                } catch (IOException t) {
                    throw new IllegalStateException("Unable to successfully receive input or transmit output");
                }
                return;
            }

            try {
                input = scan.next();
            } catch (NoSuchElementException e) {  //todo Question: why not IllegalStateException??
                // if unable to read from the Readable object (i.e. it ran out of inputs),
                // should throw an IllegalStateException to its caller.
                throw new IllegalStateException("Ran out of inputs.");
            }

            //  When meet 'q' or 'Q': 'Game quit!'
            if (input.equals("Q") || input.equals("q")) {
                int n = model.getScore();
                try {
                    ap.append("Game quit!\n" +
                            "State of game when quit:\n" +
                            model.getGameState() + "\n" +
                            "Score: " + n);
                } catch (IOException e) {
                    throw new IllegalStateException("Unable to successfully receive input or transmit output");
                }
                return;
            }

            // todo Bad inputs:
            //  If an input is unexpected (i.e. something other than 'q', 'Q' or a positive number)
            //  it should ask the user to input it again. If the user entered the from-row and from-column correctly
            //  but the to-row incorrectly, the controller should ask only for to-row before moving on to to-column.

            // todo If the move was invalid as signaled by the model, the controller should transmit a message to
            //  the Appendable object "Invalid move. Play again." plus any informative message about why the move was invalid
            //  (all on one line),
            //  and resume waiting for valid input.

             try {
                if (Integer.parseInt(input) > 0) {
                    arr.set(i++, Integer.parseInt(input));
                    if (i == 4) {
                        try {
                            // To make the inputs more user-friendly, all row and columns numbers in the input begin from 1.
                            model.move(arr.get(0) - 1, arr.get(1) - 1, arr.get(2) - 1,
                                    arr.get(3) - 1);
                        } catch (IllegalArgumentException e) {
                            try {
                                ap.append("Invalid move. Play again. " + e.getMessage() + "\n");
                            } catch (IOException p) {
                                throw new IllegalStateException("Unable to successfully receive input or transmit output");
                            }
                        }
                        i = 0;
                        this.playGameWithModel(model);
                    }
                }
            } catch (Exception e) {
                // throw exception away with no action.
            }
        }
    }

    /**
     * This helper function tests if the transmit is successful or not.
     * @param model
     */
    private void playGameWithModel(MarbleSolitaireModel model) {
        try {
            ap.append(model.getGameState() + "\n" + "Score: " + model.getScore() + "\n");
        } catch (IOException e) {
            throw new IllegalStateException("Unable to successfully receive input or transmit output");
        }
    }


}

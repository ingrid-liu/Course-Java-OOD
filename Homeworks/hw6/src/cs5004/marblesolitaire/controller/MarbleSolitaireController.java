package cs5004.marblesolitaire.controller;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;

/**
 * Defines the interface of the controller.
 */
public interface MarbleSolitaireController {

    /**
     * Plays a new game of Marble Solitaire using the provided model.
     * @param model provided MarbleSolitaireModel
     * @throws IllegalArgumentException if the provided model is null
     * @throws IllegalStateException only if the controller can't receive input or transmit output
     */
    void playGame(MarbleSolitaireModel model) throws IllegalArgumentException, IllegalStateException;

}

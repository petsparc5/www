package com.clean.communication;

import com.clean.interfaces.Torpedo;

/**
 * Handling the protocol messages.
 * @author Csaba_Valyi
 *
 */
public class TorpedoProtocol {
    private Torpedo torpedo;

    /**
     * Constructor.
     * @param torpedo : the interface that is needed for playing the game.
     */
    public TorpedoProtocol(Torpedo torpedo) {
        super();
        this.torpedo = torpedo;
    }

    /**
     * Tells whether the fire message hit/miss/sunk a ship.
     * @param theInput : the message from the input.
     * @return the response for the fire message,
     */
    public String processInput(String theInput) {
        String outputLine = "init";
        if (theInput.split(" ").length > 2) {
            int x = Integer.parseInt(theInput.split(" ")[1]);
            int y = Integer.parseInt(theInput.split(" ")[2]);
            outputLine = torpedo.fire(x, y).name().toLowerCase();
        }
        return outputLine;
    }

}

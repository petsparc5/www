package com.clean.interfaces;

import com.clean.shipgame.Status;

/**
 * Interface for Strategies.
 * @author Peter_Takacs
 *
 */
public interface GameStrategy {

    /**
     * Returns the next target.
     * @param input the response for the previous fire message.
     * @return the next target.
     */
    String getTarget(Status input);

    /**
     * Initialise method.
     */
    void initialise();

    /**
     * Peter keeps track of how optimal the gaming strategy is.
     * @return the Peter for the game.
     */
    int getPeter();
}

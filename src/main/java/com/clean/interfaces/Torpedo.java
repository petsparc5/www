package com.clean.interfaces;

import com.clean.shipgame.Status;

/**
 * Tamas' interface.
 * @author Peter_Takacs
 *
 */
public interface Torpedo {
    /**
     * Fires at Position (x,y).
     * @param x Coordinate x
     * @param y Coordinate y
     * @return Miss/Hit/Sunk/Win, depending on the game.
     */
    Status fire(int x, int y);

}

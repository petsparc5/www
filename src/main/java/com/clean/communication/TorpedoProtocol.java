package com.clean.communication;

import com.clean.interfaces.Torpedo;


public class TorpedoProtocol {
    private Torpedo torpedo;
    
    public TorpedoProtocol(Torpedo torpedo) {
        super();
        this.torpedo = torpedo;
    }

    public String processInput(String theInput) {
        String outputLine = "init";
        if(theInput.split(" ").length >= 3){
        	int x = Integer.parseInt(theInput.split(" ")[1]);
        	int y = Integer.parseInt(theInput.split(" ")[2]);
        	switch (torpedo.fire(x, y)) {
		    case HIT: 
		        outputLine = "hit";
		        break;
		    case MISS:
		        outputLine = "miss";
		        break;
		    case SUNK:
		        outputLine = "sunk";
		        break;
		    case WIN:
		        outputLine = "win";
		        break;
		    default:
		        outputLine = "not valid";
		        break;
		    }
        }
        return outputLine;
    }

}

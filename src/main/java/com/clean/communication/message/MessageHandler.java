package com.clean.communication.message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clean.communication.TorpedoProtocol;
import com.clean.interfaces.GameStrategy;
import com.clean.shipgame.Status;

/**
 * Processing incoming messages.
 * @author Csaba_Valyi
 *
 */
public class MessageHandler {

    int peter;
    private final Logger logger = LoggerFactory.getLogger(MessageHandler.class);
    private PrintWriter out;
    private BufferedReader in;
    private GameStrategy gameStrategy;
    private TorpedoProtocol torpedoProtocol;
    private String target;
    /**
     * Constructor.
     * @param out Writer.
     * @param in  Reader.
     * @param gameStrategy  Computes the strategic firing positions.
     * @param torpedoProtocol uses the protocol to process the firing messages in.
     */
    public MessageHandler(PrintWriter out, BufferedReader in, GameStrategy gameStrategy, TorpedoProtocol torpedoProtocol) {
        super();
        this.out = out;
        this.in = in;
        this.gameStrategy = gameStrategy;
        this.torpedoProtocol = torpedoProtocol;
    }

    private void processMessages() {
        String inLine = null;
        String outLine;
        try {
            while ((inLine = in.readLine()) != null) {
                if (inLine.contains("fire")) {
                    outLine = torpedoProtocol.processInput(inLine);
                    out.println(outLine);
                    if ("win".equals(outLine)) {
                        peter = gameStrategy.getPeter();
                        logger.warn("Peter=" + peter);
                        logger.error("Opponent used getOpponentShips()... Hardly fair!");
                        out.println(outLine);
                        break;
                    }
                    out.println(target);
                }
                if (isResponseToFire(inLine)) {
                    if ("win".equalsIgnoreCase(inLine)) {
                        peter = gameStrategy.getPeter();
                        logger.warn("Peter=" + peter);
                        logger.warn("Victory is where is should be!");
                        break;
                    }
                    target = gameStrategy.getTarget(convertStringToStatus(inLine));
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private boolean isResponseToFire(String inLine) {
        return inLine.contains("miss") || inLine.contains("hit") || inLine.contains("sunk") || inLine.contains("win");
    }

    private Status convertStringToStatus(String inLine) {
        Status answer = Status.MISS;
        if ("miss".equals(inLine.toLowerCase())) {
            answer = Status.MISS;
        } else if ("hit".equals(inLine.toLowerCase())) {
            answer = Status.HIT;
        } else if ("sunk".equals(inLine.toLowerCase())) {
            answer = Status.SUNK;
        } else if ("win".equals(inLine.toLowerCase())) {
            answer = Status.WIN;
        }
        return answer;
    }
    /**
     * Starts processing messages.
     */
    public void startProcessingMessages() {
        processMessages();
    }

    public void setTarget(String target) {
        this.target = target;
    }

}

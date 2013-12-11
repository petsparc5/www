package com.clean.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clean.communication.message.MessageHandler;
import com.clean.interfaces.GameStrategy;
import com.clean.shipgame.GameWithShips;
import com.clean.shipgame.Status;

/**
 * TorpedoClient.
 * @author Csaba_Valyi
 *
 */
public class TorpedoClient {

    private final Logger logger = LoggerFactory.getLogger(TorpedoClient.class);
    private final int portNumber;
    private final String hostName;
    private MessageHandler messageHandler;
    /**
     * Sets up the host and port.
     * @param string host:port
     */
    public TorpedoClient(String string) {
        hostName = string.split(":")[0];
        portNumber = Integer.parseInt(string.split(":")[1]);
    }
    /**
     * This method sets up connection on the client's side.
     * @param gameWithShips has the board
     * @param gameStrategy has the strategy to fire on the opponent.
     * @param boardSize is the boardsize that will be used to initialise both previous params.
     */
    public void initClient(GameWithShips gameWithShips, GameStrategy gameStrategy, String boardSize) {
        try (Socket clientSocket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            out.println("greeting " + boardSize);
            String first = gameStrategy.getTarget(Status.MISS);
            out.println(first);
            gameWithShips.initialise();
            TorpedoProtocol torpedoProtocol = new TorpedoProtocol(gameWithShips);
            messageHandler = new MessageHandler(out, in, gameStrategy, torpedoProtocol);
            messageHandler.startProcessingMessages();
        } catch (UnknownHostException e) {
            logger.error("Don't know about host " + hostName);
        } catch (IOException e) {
            logger.warn("Couldn't get I/O for the connection to " + hostName);
        }

    }
}

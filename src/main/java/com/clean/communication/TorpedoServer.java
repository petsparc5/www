package com.clean.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clean.communication.message.MessageHandler;
import com.clean.shipgame.GameWithShips;
import com.clean.shipgame.Status;
import com.clean.strategy.FirePositionStrategy;
import com.clean.strategy.XYGuessGenerator;

/**
 * TorpedoServer.
 * @author Csaba_Valyi
 *
 */
public class TorpedoServer {

    private final Logger logger = LoggerFactory.getLogger(TorpedoServer.class);
    private final int portNumber;
    private MessageHandler messageHandler;
    /**
     * Sets up the port.
     * @param string port
     */
    public TorpedoServer(String string) {
        portNumber = Integer.parseInt(string);
    }
    /**
     * Sets up the game on the client's side.
     * @param gameWithShips contains the game.
     */
    public void initServer(GameWithShips gameWithShips) {
        try (ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            String inputLine;
            inputLine = waitForGreeting(gameWithShips, in);

            XYGuessGenerator generator = new XYGuessGenerator(Integer.parseInt(inputLine.split(" ")[1]));
            FirePositionStrategy gameStrategy = new FirePositionStrategy();
            gameStrategy.setGenerator(generator);
            gameStrategy.initialise();
            TorpedoProtocol torpedoProtocol = new TorpedoProtocol(gameWithShips);
            messageHandler = new MessageHandler(out, in, gameStrategy, torpedoProtocol);
            messageHandler.setTarget(gameStrategy.getTarget(Status.MISS));
            messageHandler.startProcessingMessages();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private String waitForGreeting(GameWithShips gameWithShips, BufferedReader in) throws IOException {
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.contains("greeting")) {
                gameWithShips.setBoardSize(Integer.parseInt(inputLine.split(" ")[1]));
                gameWithShips.initialise();
                break;
            }
        }
        return inputLine;
    }
}

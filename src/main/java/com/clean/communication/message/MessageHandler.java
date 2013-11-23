package com.clean.communication.message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.clean.communication.TorpedoProtocol;
import com.clean.interfaces.GameStrategy;

public class MessageHandler {

    PrintWriter out;
    BufferedReader in;
    GameStrategy gameStrategy;
    TorpedoProtocol torpedoProtocol;
    private final Logger logger = LoggerFactory.getLogger(MessageHandler.class);
    
    public MessageHandler(PrintWriter out, BufferedReader in, GameStrategy gameStrategy, TorpedoProtocol torpedoProtocol) {
        super();
        this.out = out;
        this.in = in;
        this.gameStrategy = gameStrategy;
        this.torpedoProtocol = torpedoProtocol;
    }
    
    public void run() {
        try {
            processMessages();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void processMessages() throws IOException {
        out.println(gameStrategy.firstTarget());
        String inputLine;
        String outputLine;
        String outPut;
        int counter = 0;
        List<String> input = new ArrayList<>();
        while((inputLine = in.readLine()) != null){
            input.add(inputLine);
            logger.debug("###############");
            logger.warn("counter:{}", counter++);
            logger.debug("input: {}" ,input);
            if(inputLine.toLowerCase().equals("win")){
                System.out.format("Win!%n");
                System.out.format("Peter=%s %n", gameStrategy.getPeter());
                break;
            }
            if(isValidProtocolMessage(inputLine)) {
                outputLine = torpedoProtocol.processInput(inputLine);
                if(outputLine.equals("win")){
                    System.out.format("Defeat!%n");
                    System.out.format("Peter=%s %n", gameStrategy.getPeter());
                    out.println(outputLine);
                    break;
                }if(inputLine.toLowerCase().contains("fire")){
                    logger.debug("response to fire: {}", outputLine);
                    out.println(outputLine);
                }
                if(inputIsResponseToFireMessage(inputLine)){
                    outPut = gameStrategy.nextTarget(inputLine);
                    logger.debug("fire: {}", outPut);
                    out.println(outPut);
                }
            }
            logger.debug("###############");
        }
    }
    
    private boolean inputIsResponseToFireMessage(String inputLine) {        
        return inputLine.toLowerCase().contains("hit") || inputLine.toLowerCase().contains("miss") || 
                inputLine.toLowerCase().contains("sunk");
    }

    private boolean isValidProtocolMessage(String inputLine) {
        return inputLine.toLowerCase().contains("fire") || inputLine.toLowerCase().contains("hit") ||
                inputLine.toLowerCase().contains("miss") || inputLine.toLowerCase().contains("sunk");
    }
}

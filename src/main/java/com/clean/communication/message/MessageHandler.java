package com.clean.communication.message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.clean.communication.TorpedoProtocol;
import com.clean.interfaces.GameStrategy;
import com.clean.shipgame.Status;

public class MessageHandler {

    PrintWriter out;
    BufferedReader in;
    GameStrategy gameStrategy;
    TorpedoProtocol torpedoProtocol;
    
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
        out.println(gameStrategy.getTarget(Status.MISS));
        String inputLine;
        String outputLine;
        String outPut;
        while((inputLine = in.readLine()) != null){
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
                    out.println(outputLine);
                }
                if(inputIsResponseToFireMessage(inputLine)){
                	Status inStatus = convert(inputLine);
                    outPut = gameStrategy.getTarget(inStatus);
                    out.println(outPut);
                }
            }
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
    
    private Status convert(String inputLine) {
        Status answer;
        if(inputLine.toLowerCase().equals("hit")){
            answer = Status.HIT;
        } else if(inputLine.toLowerCase().equals("miss")){
            answer = Status.MISS;
        } else {
            answer = Status.SUNK;
        }
        
        return answer;
    }
}
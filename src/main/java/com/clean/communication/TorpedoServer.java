package com.clean.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.clean.interfaces.GameStrategy;
import com.clean.shipgame.GameWithShips;
import com.clean.strategy.FirePositionStrategy;

public class TorpedoServer {

    private final int portNumber;
    
    public TorpedoServer(String string) {
        portNumber = Integer.parseInt(string);
    }

    public void initServer(GameWithShips gameWithShips){
        try (
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine, outputLine;
            while((inputLine = in.readLine()) != null){
            	if(inputLine.contains("greeting")){
            	    System.out.format("Greeeting happened%n");
            		gameWithShips.setBoardSize(Integer.parseInt(inputLine.split(" ")[1]));
            		gameWithShips.initialise();
            		break;
            	}
            }
            GameStrategy gameStrategy = new FirePositionStrategy(Integer.parseInt(inputLine.split(" ")[1]));
            gameStrategy.initialise();
            TorpedoProtocol torpedoProtocol = new TorpedoProtocol(gameWithShips);
            while((inputLine = in.readLine()) != null){
            	if(inputLine.toLowerCase().equals("win")){
                    System.out.format("Win!%n");
                	System.out.format("Peter=%s %n", gameStrategy.getPeter());
                    break;
                }
            	if(inputLine.toLowerCase().contains("fire") || inputLine.toLowerCase().contains("hit") ||
            		inputLine.toLowerCase().contains("miss") || inputLine.toLowerCase().contains("sunk")) {
	                outputLine = torpedoProtocol.processInput(inputLine);
	                if(!outputLine.contains("init") && inputLine.toLowerCase().contains("fire")){
	                	out.println(outputLine);
	                	out.println(gameStrategy.nextTarget(inputLine));
	                }
	                if(outputLine.equals("win")){
	                	out.println(outputLine);
	                    System.out.format("Defeat!%n");
	                    break;
	                }
	                
	            }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

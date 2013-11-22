package com.clean.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.clean.interfaces.GameStrategy;
import com.clean.shipgame.GameWithShips;

public class TorpedoClient {

    private final int portNumber;
    private final String hostName;
    
    public TorpedoClient(String string) {
        hostName = string.split(":")[0];
        portNumber = Integer.parseInt(string.split(":")[1]);
    }

    public void initClient(GameWithShips gameWithShips, GameStrategy gameStrategy, String boardSize){
        try (
            Socket clientSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
          ) {
        	gameWithShips.initialise();
            String fromServer;
            String fromUser;
            TorpedoProtocol torpedoProtocol = new TorpedoProtocol(gameWithShips);
            out.println("greeting "+boardSize);
            out.println(gameStrategy.firstTarget());
            while ((fromServer = in.readLine()) != null) {
                if (fromServer.toLowerCase().contains("win")){
                	System.out.format("Peter=%s %n", gameStrategy.getPeter());
                    System.out.format("Win!%n");
                    break;
                }
            	if(fromServer.toLowerCase().contains("fire") || fromServer.toLowerCase().contains("hit") ||
            	   fromServer.toLowerCase().contains("miss") || fromServer.toLowerCase().contains("sunk")){
            		fromUser = torpedoProtocol.processInput(fromServer);
	                if(fromServer.toLowerCase().contains("fire") && !fromUser.contains("init")){
	                	out.println(fromUser);
			            fromUser = gameStrategy.nextTarget(fromServer);
			            System.out.format("fromUser=%s %n",	fromUser);
			            out.println(fromUser);
	                }
	                if(fromUser.toLowerCase().equals("win")){
			            out.println(fromUser);
			            System.out.format("Defeat!%n");
	                    break;
	                }

            	}
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    
    }
}

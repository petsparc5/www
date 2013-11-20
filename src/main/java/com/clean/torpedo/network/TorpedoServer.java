package com.clean.torpedo.network;

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
            while(!(inputLine = in.readLine()).contains("greeting")){
                gameWithShips.setBoardSize(Integer.parseInt(inputLine.split(" ")[1]));
                gameWithShips.initialise();
            }
            GameStrategy gameStrategy = new FirePositionStrategy(Integer.parseInt(inputLine.split(" ")[1]));
            gameStrategy.initialise();
            TorpedoProtocol torpedoProtocol = new TorpedoProtocol(gameWithShips);
            while((inputLine = in.readLine()) != null){
                if(inputLine.toLowerCase().equals("win")){
                    System.out.format("Win!%n");
                    break;
                }
                outputLine = torpedoProtocol.processInput(inputLine);
                out.println(outputLine);
                if(outputLine.equals("win")){
                    System.out.format("Defeat!%n");
                    break;
                }
                out.println(gameStrategy.nextTarget(inputLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

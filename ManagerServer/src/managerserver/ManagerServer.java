/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Nawie
 */



class ManagerServer extends Thread
{
    public static final int SERVICE_PORT=5001;
    
    public static void main(String[] args) {
        try{
            ServerSocket server=new ServerSocket(SERVICE_PORT);
            System.out.println("Servidor aberto!");
            
            while(true){
                Socket nextClient=server.accept();
                System.out.println("Received request from " + nextClient.getInetAddress() + ":" + nextClient.getPort());
                
                nextClient.close();
                //System.out.println("Not able to do client request");
            }
            
        }catch(BindException e){
            System.err.println("Service already running on port " + SERVICE_PORT);
            
        }catch(IOException e){
            System.err.println("I/O error " + e);
        }
    }
       
}

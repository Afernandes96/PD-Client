/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreeinRowCom;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nawie
 */
public class ObsGameModel extends Observable{
    private String username;
    private InetAddress address;
    private int port;
    private int updatePort;
    private GameServerUtils gameServer;

    
    public ObsGameModel() {
    }
    
    public void connectGameServer(final String username, final InetAddress address, final int port) throws UnknownHostException, IOException {
        this.username = username;
        this.address = address;
        this.port = port;
        this.updatePort = port + 1;

        this.gameServer = new GameServerUtils(address, port);
        this.gameServer.startConnection();

        startUpdateThread(updatePort);
    }

    private void startUpdateThread(int updatePort) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Socket updateSocket = new Socket(address, updatePort);
                    ObjectOutputStream oos = new ObjectOutputStream(updateSocket.getOutputStream());    
                    ObjectInputStream ois = new ObjectInputStream(updateSocket.getInputStream());

                    while (true) {
                        Object obj = ois.readBoolean();
                        Boolean bool = (Boolean) obj;
                        if (bool) {
                            System.out.println("Update Game");
                            setChanged();
                            notifyObservers();
                        }
                    }
                } catch (IOException ex) {
                   // Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();
    }
    
}

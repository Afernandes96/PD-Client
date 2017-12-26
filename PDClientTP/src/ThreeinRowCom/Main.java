package ThreeinRowCom;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main{
    
    
    private ObsManagerModel manager;
    private ObsGameModel game;

    public Main() {
        manager = new ObsManagerModel(this);
        game = new ObsGameModel();
    }
 
    public synchronized ObsManagerModel getManager() {
        return manager;
    }

    /**
     *
     */
    public boolean connectMngServer(String serverAddr){
        try {
            manager.connect(serverAddr);
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    /**
     * Do not call this method from the GUI
     *
     * @param serverAddr
     * @param port
     */
    public void connectGameServer(String serverAddr, int port) {
        try {
            InetAddress addr = InetAddress.getByName(serverAddr);
            game.connectGameServer(manager.getUsername(), addr, port);
            
            //throw new RuntimeException("This method should only be called to connect with the Game Server");
        } catch (UnknownHostException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized ObsGameModel getGame() {
        if (game == null) {
            throw new RuntimeException("Connection with GameServer should be done firstly");
        }
        return game;
    }
}


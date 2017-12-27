package ThreeinRowCom;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainM{
    
    
    private ObsManagerModel manager;
    private ObsGameModel game;

    public MainM() {
        manager = new ObsManagerModel(this);
        game = new ObsGameModel();
    }
 
    public synchronized ObsManagerModel getManager() {
        return manager;
    }

    /**
     *
     */
    public boolean connectManager(String serverAddr) throws UnknownHostException, InterruptedException{
        try {
            manager.connectManager(serverAddr);
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
    public void connectGame(String serverAddr, int port) {
        try {
            InetAddress addr = InetAddress.getByName(serverAddr);
            game.connectGameServer(manager.getUsername(), addr, port);
            
            //throw new RuntimeException("This method should only be called to connect with the Game Server");
        } catch (UnknownHostException ex) {
            Logger.getLogger(MainM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized ObsGameModel getGame() {
        if (game == null) {
            throw new RuntimeException("Connection with GameServer should be done firstly");
        }
        return game;
    }
}


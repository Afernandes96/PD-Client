package ThreeinRowCom;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author henri
 */
public class GameServerUtils {
    
    public static final int TIMEOUT = 20;

    private int port;
    private InetAddress serverAddr = null;
    private Socket socket = null;
    ObjectOutputStream out;
    ObjectInputStream in;
    
    private boolean connected;

    public GameServerUtils (InetAddress serverAddr, int port) throws UnknownHostException{
        this.serverAddr = serverAddr;
        this.port = port;
        this.connected = false;
    }
    
    public void connect() throws IOException {

        socket = new Socket(serverAddr, port);
        socket.setSoTimeout(TIMEOUT * 1000);

        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
        
        connected = true;
    }

    public void disconnect() throws IOException {
        out.close();
        in.close();
        if (!socket.isClosed()) {
            socket.close();
        }
        socket = null;
        connected = false;
    }
    
    public void receiveMngServer() throws IOException, ClassNotFoundException{
        Object obj;  
        obj = in.readObject();

    }
    
    public boolean isConnected() {
        return connected;
    }
}


package ThreeinRowCom;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Thread.sleep;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ManagerServerUtils {
     public static final int TIMEOUT = 20;
    public static final int SERVER_PORT = 5001;

    private InetAddress serverAddr = null;
    private Socket socket = null;
    ObjectOutputStream out;
    ObjectInputStream in;

    private boolean connected;
    
    public ManagerServerUtils(String serverAddr) throws UnknownHostException {
        this.serverAddr = InetAddress.getByName(serverAddr);
        this.connected = false;
    }

    public void connect() throws IOException, InterruptedException {
        
        socket = new Socket(serverAddr,SERVER_PORT);
        socket.setSoTimeout(TIMEOUT * 1000);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
        this.connected = true;
    }

    public void disconnect() throws IOException {
        out.close();
        in.close();
        if (!socket.isClosed()) {
            socket.close();
        }
        socket = null;
        this.connected = false;
    }

    public boolean isConnected() {
        return connected;
    }
}

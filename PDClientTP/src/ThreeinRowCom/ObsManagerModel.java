package ThreeinRowCom;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Integer.parseInt;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObsManagerModel extends Observable {

    public static final int PORT = 5001;
    public static final int UPDATE_PORT = 5002;
    private final Main parent;

    private String username;
    private String address;
    private ManagerServerUtils server;
    Thread updateSocketThread;
    private boolean isLoggedIn;

    public ObsManagerModel(Main parent) {
        this.parent = parent;

    }

    public void connectManager(String address) throws UnknownHostException, IOException {
        this.isLoggedIn = false;
        this.address = address;
        this.username = null;

        this.server = new ManagerServerUtils(address);
        server.connect();
        UpdateThread(UPDATE_PORT);
    }

    private void UpdateThread(int updatePort) {
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
                            System.out.println("Update");
                            setChanged();
                            notifyObservers();
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ObsManagerModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();
    }

//    // Request Methods -------------------------------------------------------------------------------------------
//    public boolean singUp(String name, String username, String password) {
//        try {
//            mngServer.oos.writeObject(new SingUpRequest(name, username, password));
//            mngServer.oos.flush();
//            Object obj = mngServer.ois.readObject();
//            GetSignUpAcceptanceResponse msg = (GetSignUpAcceptanceResponse) obj;
//            return msg.isAccepted();
//        } catch (IOException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;
//    }
//
//    public void login(String username, String password) {
//        try {
//            this.username = username;
//            mngServer.oos.writeObject(new LoginRequest(username, password));
//            mngServer.oos.flush();
//        } catch (IOException ex) {
//            System.out.println("Could not send a Login Request.");
//        }
//    }
//
//    public void askMakeGroup(String fellowName) {
//        try {
//            mngServer.oos.writeObject(new AskMakeGroupRequest(username, fellowName));
//            mngServer.oos.flush();
//        } catch (IOException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void answerMakeGroup(boolean wantToJoin) {
//        try {
//            mngServer.oos.writeObject(new AnswerMakeGroupRequest(username, wantToJoin));
//            mngServer.oos.flush();
//        } catch (IOException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void sendMessage(String fellowName, String message) {
//        try {
//            mngServer.oos.writeObject(new SendMessageRequest(username, message, fellowName));
//            mngServer.oos.flush();
//        } catch (IOException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void sendBroadcastMessage(String message) {
//        try {
//            mngServer.oos.writeObject(new SendBroadcastMessageRequest(username, message));
//            mngServer.oos.flush();
//        } catch (IOException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    // Retrieve Data Methods --------------------------------------------------------------------------------------
//    public boolean isLoggedIn() {
//        try {
//            mngServer.oos.writeObject(new GetMngRequests(username, 6));
//            mngServer.oos.flush();
//            Object obj = mngServer.ois.readObject();
//            GetIsLoggedInResponse msg = (GetIsLoggedInResponse) obj;
//            if (msg.isIsLoggenIn() && !this.isLoggedIn) {
//                this.isLoggedIn = true;
//                this.username = username;
//                //    this.startUpdateThread(UPDATE_PORT);
//            }
//            return msg.isIsLoggenIn();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;
//    }
//
//    public GetAuthenticatedUsersResponse getAuthenticatedUsers() {
//        try {
//            mngServer.oos.writeObject(new GetMngRequests(username, 2));
//            mngServer.oos.flush();
//            Object obj = mngServer.ois.readObject();
//            GetAuthenticatedUsersResponse msg = (GetAuthenticatedUsersResponse) obj;
//            return msg;
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    public List<String> getHistoryGames() {
//        try {
//            mngServer.oos.writeObject(new GetMngRequests(username, 5));
//            mngServer.oos.flush();
//            Object obj = mngServer.ois.readObject();
//            GetHistoryGamesResponse msg = (GetHistoryGamesResponse) obj;
//
//            List<String> history = new ArrayList<>();
//            for (int i = 0; i < msg.getOpponentName().size(); i++) {
//                history.add("Opponent name: " + msg.getOpponentName().get(i) + "\tScore:" + msg.getScore().get(i));
//            }
//            return history;
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    public List<String> getNotFinishedGames() {
//        try {
//            mngServer.oos.writeObject(new GetMngRequests(username, 9));
//            mngServer.oos.flush();
//            Object obj = mngServer.ois.readObject();
//            GetNotFinishedGamesResponse msg = (GetNotFinishedGamesResponse) obj;
//            return msg.getOpponentName();
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    public List<String> getMessages() {
//        try {
//            mngServer.oos.writeObject(new GetMngRequests(username, 8));
//            mngServer.oos.flush();
//            Object obj = mngServer.ois.readObject();
//            GetMessagesResponse msg = (GetMessagesResponse) obj;
//            if(!(obj instanceof GetMessagesResponse))
//                System.out.println("Not an instance");
//            else
//                System.out.println("Is an instance");
//            List<String> logs =  msg.getMessages();
//            System.out.println("MESSAGE__:" + msg.getMessages().size());
//            for(String l : logs){
//                System.out.println(l);
//            }
//            return msg.getMessages();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    public String getMakeGroupAnswer() {
//        try {
//            mngServer.oos.writeObject(new GetMngRequests(username, 7));
//            mngServer.oos.flush();
//            Object obj = mngServer.ois.readObject();
//            GetMakeGroupAnswerRequestResponse msg = (GetMakeGroupAnswerRequestResponse) obj;
//            if (!msg.isAnswer()) {
//                return null;
//            } else {
//                return msg.getOpponentName();
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    public String getAnyMakeGroupRequest() {
//        try {
//            mngServer.oos.writeObject(new GetMngRequests(username, 1));
//            mngServer.oos.flush();
//            Object obj = mngServer.ois.readObject();
//            GetAnyMakeGroupRequestResponse msg = (GetAnyMakeGroupRequestResponse) obj;
//            if (!msg.hasRequest()) {
//                return null;
//            } else {
//                return msg.getOpponentName();
//            }
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    public String hasOpponent() {
//        try {
//            mngServer.oos.writeObject(new GetMngRequests(username, 4));
//            mngServer.oos.flush();
//            Object obj = mngServer.ois.readObject();
//            GetHasOpponentResponse msg = (GetHasOpponentResponse) obj;
//            if (!msg.isHasOpponent()) {
//                return null;
//            } else {
//                Map<String, String> gameServerAddr = getGameServerAddress();
//                if (parent.game() == null) {
//                    parent.connectGameServer(
//                            gameServerAddr.get("GAME_SERVER_IP"),
//                            parseInt(gameServerAddr.get("GAME_SERVER_PORT")));
//                }
//
//                return msg.getFellowName();
//            }
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    public Map<String, String> getGameServerAddress() {
//        try {
//            mngServer.oos.writeObject(new GetMngRequests(username, 3));
//            mngServer.oos.flush();
//            Object obj = mngServer.ois.readObject();
//            GetGameServerAddrResponse msg = (GetGameServerAddrResponse) obj;
//            Map<String, String> gameServerAddr = new HashMap<>();
//            gameServerAddr.put("GAME_SERVER_IP", msg.getAddress());
//            gameServerAddr.put("GAME_SERVER_PORT", String.valueOf(msg.getPort()));
//            return gameServerAddr;
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ObservableMngModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    public String getUsername() {
//        return username;
//    }
}


package managerRequests;

import java.io.Serializable;

public class BroadcastRequest implements Serializable{
  
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String message;

    public BroadcastRequest(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getUsername() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}  


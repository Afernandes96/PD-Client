package managerRequests;

import java.io.Serializable;

public class MessageRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String message;
    private final String user;

    public MessageRequest(String name, String message, String user) {
        this.name = name;
        this.message = message;
        this.user = user;
    }

    public String getUsername() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getFellowName() {
        return user;
    }
}
